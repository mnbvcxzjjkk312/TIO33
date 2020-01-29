package tischats;


/*
 * /**프로토콜 정의
100 : 클라이언트 리스트 정보(100|아이디|대화명|성별)
300 : 이모티아이콘 보내기
400: 일반 대화 메시지(400|글꼴색|메시지)
500: 귓속말(500|귓속말 보내는 사람의 대화명|귓속말 메시지)
600: 대화명 변경(600|아이디|기존대화명|바뀐대화명)
800 : 동일한 아이디가 있을 시 접속을 종료시킨다(800|)
810 : 로그아웃-퇴장 처리(810|아이디)
900 : 채팅 종료 (900|아이디)
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class tisChatsGui extends javax.swing.JFrame implements Runnable
{
	Socket sock;
	String id, chatName, host;
	final int port = 7777;
	boolean isStop = false;
	ObjectOutputStream out;
	ObjectInputStream in;

	boolean isSendOne = false;	// 귓속말 보내기라면 true값을 가질 예정.
	Color fontCr = Color.black;
	
	DefaultTableModel userModel;
	String [] colHeader = {"아이디", "대화명", "성별"};
	
	StyledDocument doc;
	SimpleAttributeSet attr;
	
	public static final int LOGOUT = 1;		// 퇴장
	public static final int EXIT = 0;		// 종료

    public tisChatsGui()
    {
        initComponents();
        doc = tpMsg.getStyledDocument();
    }// Constructor-------------------------------------------------------------------------
    
    /** 서버가 보내오는 메시지를 계속 듣고, 파싱한다. */
    @Override
	public void run()
	{
    	try
		{
    		while(!isStop)
    		{
    			String serverMsg = (String)in.readObject();
    			System.out.println("serverMsg >> " + serverMsg);
    			if(serverMsg == null)
    			{
    				return;
    			}
    			
    			// 서버에게 보내오는 메시지를 분석(파싱)하는 메서드를 호출.
    			parsing(serverMsg);
    		}// while---------------------------------------------------
		} 
    	catch (NullPointerException e)
    	{
    		isStop = false;
    	}
    	catch (Exception e)
		{
    		System.out.println("클라이언트 run()에서 예외 발생 : " + e);
		}
	}
    
    /** 서버에서 온 메시지를 분석하여 프로토콜별로 로직을 처리하는 메서드. */
    private void parsing(String msg)
	{
		// '|' 구분자를 기준으로 문자열을 쪼개어 토큰으로 만들자.
    	String[] tokens = msg.split("\\|");	// ex) 700| 을 기준으로 700은 tokens 1에 , 나머지는 tokens2에 들어옴.
    	String protocol = tokens[0];
    	switch(protocol)
    	{
    	case "100" : 
	    	{
	    		// 서버가 클라이언트에게 "100|아이디|대화명|성별" 을 보냈음.
	    		String [] rowData = {tokens[1], tokens[2], tokens[3]};
	    		userModel = (DefaultTableModel)this.userTable.getModel();
	    		userModel.addRow(rowData);
	    		break;
	    	}
    	case "400" : 
	    	{
	    		// 서버가 클라이언트에게 "400|대화명|글꼴색|메시지"
	    		String fromChatName = tokens[1];
	    		String fntRgb = tokens[2];
	    		String fromMsg = tokens[3];
	    		//showChat(fromChatName, fntRgb, fromMsg);
	    		showCacaoStyle(fromChatName, fntRgb, fromMsg);
	    		break;
	    	}
	    case "500" :
		    {
		    	// 서버가 클라이언트에게 "500|보내는사람대화명|귓속말메시지"
		    	String from = tokens[1];
		    	String oneMsg = tokens[2];
		    	String str = "★[" + from + "]★님이 보낸 귓속말 >> " + oneMsg + "\r\n";
		    	//showChatOne(Color.yellow, Color.blue, str);
		    	showCacaoStyle("Ohter", Color.lightGray, Color.blue, str);
		    	break;
		    }
    	case "700" :	// 대화명 중복일 경우 "700|" 
	    	{
	    		showMsg(chatName + "이란 대화명은 이미 존재해요.");
	    		// 대화명 중복시 로그아웃 처리
	    		exitChat(LOGOUT);
	    		break;
	    	}
    	case "800" : 
	    	{
	    		String logoutChatName = tokens[1];
	    		logout(logoutChatName, 1);		// 1번 : 퇴장처리. 0번 : 종료처리.
	    		break;
	    	}
    	case "900" : 
    	{
    		String exitChatName = tokens[1];
    		logout(exitChatName, EXIT);
    		break;
    	}
    	}
	}

    /** 로그아웃 하는 메서드. */
	private void logout(String logoutChatName, int mode)
	{
		// 1. 퇴장하는 클라이언트가 본인이 아닐 경우.
		// userModel 에서 퇴장하는 고객의 정보를 제거하고, tpMsg에 "xxx님이 퇴장하였습니다." 를 출력.
		int rowCnt = this.userModel.getRowCount();
		String cname="";
		for(int i = 0; i < rowCnt; i++)
		{
			cname = userModel.getValueAt(i, 1).toString();
			if(cname.equals(logoutChatName))
			{
				userModel.removeRow(i);;
				break;
			}
		}
		if(mode == LOGOUT)		// 퇴장
		{
			String str = "[" + cname + "]님이 퇴장하였습니다.\r\n";
			showChatOne(Color.white, Color.blue, str);
		}
		else if(mode == EXIT)	// 종료
		{
			String str = "[" + cname + "]님이 접속을 끊었습니다.\r\n";
			showChatOne(Color.white, Color.red, str);
		}
		
		// 2. 퇴장하는 클라이언트가 본인일 경우. ==> 채팅방에서 로그인 방으로 전환.
		if(cname.contentEquals(this.chatName))
		{
			//isStop = true;
			exitChat(mode);
		}
	}

	/** 채팅을 종료하는 메서드. */
	private void exitChat(int mode)
	{
		isStop = true;
		lbId.setText("");
		lbChatName.setText("");
		lbGender.setText("");
		try
		{
			if(out != null) out.close();
			if(in != null) in.close();
			if(sock != null)
			{
				sock.close();
				sock = null;
			}
		} 
		catch (Exception e)
		{
			System.out.println("exitChat()에서 예외 발생 : " + e);
		}
		if(mode == LOGOUT)
		{
			userModel.setDataVector(null, this.colHeader);
			this.tabEnabled(0, 1);	// 로그인 탭(0)은 활성화, 채팅방 탭(1)은 비활성화.
		}
		else if(mode == EXIT)
		{
			// 프레임 닫기
			this.dispose();
			System.exit(0);
		}
	}

	private void showMsg(String str)
	{
		JOptionPane.showMessageDialog(this, str);		
	}
    
    /** 채팅방에 입장하는 메서드. */
    private void chatEnter()
	{
		try
		{
			isStop = false;		// 스레드 동작을 시키기 위해 false 값 할당.
			sock = new Socket(host, port);
			tpMsg.setText("채팅 서버와 연결됨. \r\n");
			// 서버에서 in을 먼저 생성했으므로 여기에서는 out을 먼저 생성해야 함.
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			
			// 서버의 메시지를 리스닝하는 스레드를 생성 및 동작.
			Thread listener = new Thread(this);
			listener.start();
			
			// 서버에 "아이디|대화명|성별"을 전송.
			out.writeObject(id + "|" + chatName + "|" + gender);
			out.flush();
		} 
		catch (IOException e)
		{
			System.out.println("chatEnter()에서 예외 발생 : " + e);
		}
	}

    public void tabEnabled(int enableIdx, int disableIdx)
    {
    	this.jTabbedPane1.setEnabledAt(enableIdx, true);	// 활성화.
    	this.jTabbedPane1.setEnabledAt(disableIdx, false);	// 비활성화.
    	this.jTabbedPane1.setSelectedIndex(enableIdx);
    }
    
    /** 서버에 클라이언트의 메시지를 전송하는 메서드. 
     * @throws IOException */
    private void sendMessage(String msg) throws IOException
	{
    	// 1) 400: 일반 대화 메시지(400|글꼴색|메시지)
    	if(!isSendOne)
    	{
    		int rgb = this.fontCr.getRGB();	// 글자색
    		String str = "400|" + rgb + "|" + msg;
    		out.writeObject(str);
    		out.flush();
    	}
    	else
    	{
    		// 2) 귓속말 메시지라면 userTable에서 누구에게 보낼건지 선택해야 함.
    		int row = userTable.getSelectedRow();
    		if(row == -1)
    		{
    			showMsg("귓속말 할 사람을 먼저 선택하세요.");
    			return;
    		}
    		// 선택한 행의 대화명을 추출하자.
    		String toChatName = userTable.getValueAt(row, 1).toString();
    		if(toChatName.equals(this.chatName))
    		{
    			showMsg("본인에게는 귓속말을 보낼 수 없어요.");
    			return;
    		}
    		// 500|받을 사람의 대화명|귓속말 메시지
    		String sendMsg = "500|" + toChatName + "|" + msg;
    		out.writeObject(sendMsg);
    		out.flush();
    		
    		// 자신의 텍스트페인에 누구에게 보냈는지 표시.
    		String str = "[" + toChatName + "]님에게 보내는 귓속말 >> " + msg + "\r\n";
    		//showChatOne(Color.yellow, new Color(247, 0, 247), str);
    		showCacaoStyle("Me", Color.orange, Color.yellow, str);
    	}
	}// sendMessage()---------------------------------------------------------------
    

	/** 클라이언트가 전달한 메시지를 JTextPane에 스타일을 적용하여 표현하는 메서드. */
	private synchronized void showChat(String fromChatName, String fntRgb, String fromMsg)
	{
		int rgb = Integer.parseInt(fntRgb);
		Color foCr = new Color(rgb);	// 글자색.
		
		attr = new SimpleAttributeSet();
		StyleConstants.setForeground(attr, foCr);
		StyleConstants.setFontSize(attr, 16);
		int caretPos = doc.getEndPosition().getOffset() - 1;
		//doc.setCharacterAttributes(caretPos, fromMsg.length(), attr, true); // 빼도 됨.
		String msg = fromChatName + ">>" + fromMsg + "\r\n";
		try
		{
			doc.insertString(caretPos, msg, attr);
		} 
		catch (BadLocationException e)
		{
			e.printStackTrace();
		}
	}// showChat()--------------------------------------------------------------------------
	
	/** 귓속말 메시지를 스타일을 적용하여 JTextPane에 표현하는 메서드. */
    private synchronized void showChatOne(Color bgCr, Color fgCr, String str)
	{
		attr = new SimpleAttributeSet();
		StyleConstants.setBackground(attr, bgCr);
		StyleConstants.setForeground(attr, fgCr);
		StyleConstants.setFontSize(attr, 16);
		int offset = doc.getEndPosition().getOffset() - 1;
		try
		{
			doc.insertString(offset, str, attr);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}// showChatOne()-----------------------------------------------------------------------

    public int showConfirm(String msg)
	{
		int yn = JOptionPane.showConfirmDialog(this, msg, "확인", JOptionPane.YES_NO_OPTION);
		return yn;
	}// showConfirm()-------------------------------------------------------------------------
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfHost = new javax.swing.JTextField();
        tfChatName = new javax.swing.JTextField();
        rbM = new javax.swing.JRadioButton();
        rbF = new javax.swing.JRadioButton();
        btCancel = new javax.swing.JButton();
        btCon = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpMsg = new javax.swing.JTextPane();
        tfInput = new javax.swing.JTextField();
        chkSendOne = new javax.swing.JCheckBox();
        comboColor = new javax.swing.JComboBox<>();
        lb = new javax.swing.JLabel();
        btEmo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        lbChatName = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        btOut = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btRename = new javax.swing.JButton();

        // 아래 코드는 단순 종료 코드임. 둘이 채팅하다 윈도우의 [x] 버튼으로 종료했을 경우 문제가 생김.
        // 주석 처리하면 default가 dispose 임. 그래서 DO_NOTHING_ON_CLOSE로 해 주어야 함.
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() 
        {
        	@Override
        	public void windowClosing(WindowEvent e)
        	{
        		//setTitle("여기 들어오나요?");
        		isStop = true;
        		exitProcess();
        	}
        });

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("아이디 : ");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("대화명 : ");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("성    별 : ");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("호스트 : ");

        tfHost.setText("192.168.0.108");

        tfChatName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tfChatNameActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbM);
        rbM.setText("남자");

        buttonGroup1.add(rbF);
        rbF.setText("여자");

        btCancel.setMnemonic('E');
        btCancel.setText("취     소");
        btCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btCancelActionPerformed(evt);
            }
        });

        btCon.setMnemonic('C');
        btCon.setText("연     결");
        btCon.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btConActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfHost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(tfId))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(rbM)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbF)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfChatName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancel)
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfChatName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbM)
                    .addComponent(rbF))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCon)
                    .addComponent(btCancel))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Pristina", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CoCoA Chat    ver. 0.1");
        jLabel11.setOpaque(true);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/tc2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("로그인", jPanel1);

        tpMsg.setEditable(false);
        tpMsg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0)));
        jScrollPane2.setViewportView(tpMsg);

        tfInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        tfInput.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tfInputActionPerformed(evt);
            }
        });

        chkSendOne.setText("귓속말");
        chkSendOne.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                chkSendOneItemStateChanged(evt);
            }
        });

        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "검정색", "파랑색", "빨간색", "초록색", "노란색", "보라색" }));
        comboColor.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comboColorItemStateChanged(evt);
            }
        });

        lb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("가");
        lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btEmo.setText("Icon");
        btEmo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btEmoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chkSendOne)
                        .addGap(19, 19, 19)
                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btEmo)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkSendOne)
                    .addComponent(btEmo)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jTabbedPane1.addTab("채팅방", jPanel2);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                //{null, null, null},
                //{null, null, null},
                //{null, null, null}
            },
            new String []
            {
                "아이디", "대화명", "성    별"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userTable);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "::My Info::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("[아  이  디]");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("[대  화  명]");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("[성        별]");

        lbId.setForeground(new java.awt.Color(0, 0, 0));

        lbChatName.setForeground(new java.awt.Color(0, 0, 0));

        lbGender.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(80, 80, 80)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbGender)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(lbChatName)
                        .addGap(349, 349, 349))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbId)
                    .addComponent(lbChatName))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lbGender))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btOut.setText("퇴     장");
        btOut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btOutActionPerformed(evt);
            }
        });

        btExit.setText("종     료");
        btExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btExitActionPerformed(evt);
            }
        });

        btRename.setText("대화명 변경");
        btRename.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRenameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btOut)
                .addGap(119, 119, 119)
                .addComponent(btRename)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExit)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btExit, btOut, btRename});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btOut)
                            .addComponent(btRename)
                            .addComponent(btExit))
                        .addGap(18, 18, 18))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btExit, btOut, btRename});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfChatNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tfChatNameActionPerformed
    {//GEN-HEADEREND:event_tfChatNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfChatNameActionPerformed

    String gender;
    private void btConActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btConActionPerformed
    {
    	// 1. 사용자가 입력한 값 받기.
    	id = tfId.getText();
    	chatName = tfChatName.getText();
    	host = tfHost.getText();
    	ButtonModel btnModel = this.buttonGroup1.getSelection();
    	if(btnModel == rbM.getModel())
    	{
    		gender = "남자";
    	}
    	else
    	{
    		gender = "여자";
    	}
    	
    	if(id == null || chatName == null || host == null || id.trim().isEmpty() || chatName.trim().isEmpty() || host.trim().isEmpty())
    	{
    		showMsg("모든 값을 입력하세요.");
    		tfId.requestFocus();
    		return;
    	}
    	chatEnter();	// 채팅 시작 메서드.
    	tabEnabled(1, 0);
    	// 채팅방(1) : 탭을 선택, 활성화
    	// 로그인(0) : 탭은 비활성화.
    }

	private void btCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCancelActionPerformed
    {
		tfId.setText("");
		tfChatName.setText("");
		tfHost.setText("127.0.0.1");
    }

    private void btOutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btOutActionPerformed
    {
    	int yn = showConfirm("퇴장할까요?");
    	if(yn == JOptionPane.YES_OPTION)
    	{
    		try
			{
				out.writeObject("800|" + this.tfChatName);
				out.flush();
			} 
    		catch (IOException e)
			{
    			System.out.println("퇴장 중 예외 발생 : " + e);
			}
    		catch(NullPointerException e)
    		{
    			showMsg("서버에 연결되지 않았아요. \n로그인을 먼저 하세요.");
    		}
    		
    	}
    }

    private void btRenameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btRenameActionPerformed
    {//GEN-HEADEREND:event_btRenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRenameActionPerformed

    private void exitProcess()
    {
    	int yn = showConfirm("종료할까요?");
    	if(yn == JOptionPane.YES_OPTION)
    	{
    		// 1) 채팅서버에 접속하고 종료하는 경우
    		if(sock != null && out != null)
    		{
    			try
				{
    				out.writeObject("900|" + this.chatName);
    				out.flush();
				} 
    			catch (Exception e)
				{
    				System.out.println("접속 종료시 예외 : " + e);
				}
    		}
    		else
    		{
        		// 2) 채팅서버에 접속안하고 종료하는 경우
        		System.exit(0);
    		}
    	}
    }
    
    private void btExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btExitActionPerformed
    {
    	exitProcess();
    }

    private void comboColorItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_comboColorItemStateChanged
    {
    	int idx = comboColor.getSelectedIndex();
    	switch(idx)
    	{
	    	case 0 : fontCr = Color.black; break;
	    	case 1 : fontCr = Color.blue; break;
	    	case 2 : fontCr = Color.red; break;
	    	case 3 : fontCr = Color.green; break;
	    	case 4 : fontCr = Color.yellow; break;
	    	case 5 : fontCr = new Color(80,00,80); break;
    	}
    	lb.setForeground(fontCr);
    }

    private void chkSendOneItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_chkSendOneItemStateChanged
    {
    	// 귓속말 보내기에 체크했다면
    	int mode = evt.getStateChange();	// 선택하면 1, 아니면 2를 반환.
    	if(mode == ItemEvent.SELECTED)
    	{
    		// 1
    		isSendOne = true;
    	}
    	else
    	{
    		// 2
    		isSendOne = false;
    	}
    }

    private void btEmoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btEmoActionPerformed
    {//GEN-HEADEREND:event_btEmoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmoActionPerformed

    private void tfInputActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tfInputActionPerformed
    {
    	// tfInput에 입력한 값 얻기.
    	String sendMsg = tfInput.getText();
    	// 대화 내용 중 프로토콜 구분자로 사용하는 "|" 문자가 포함되어 있다면 프로토콜이 엉망이 될 수 있다.
    	// 그래서 "|"를 다른 문자로 바꾸어 줌.		| ==> l(소문자 L)로 바꿈.
    	sendMsg = sendMsg.replace('|', 'l');
    	if(sendMsg == null || sendMsg.equals(""))
    	{
    		return;
    	}
    	try
		{
        	sendMessage(sendMsg);
        	tfInput.setText("");
        	tfInput.requestFocus();
		} 
    	catch (Exception e)
		{
    		System.out.println("sendMessage() 중 예외 발생 : " + e);
		}
    }


	/**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(tisChatsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(tisChatsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(tisChatsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(tisChatsGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new tisChatsGui().setVisible(true);
            }
        });
    }
    
    
    
    public void setStyle(JLabel lb, String msg, SimpleAttributeSet attr){
    	int caretPos=doc.getEndPosition().getOffset()-1;    	
    	tpMsg.setCaretPosition(caretPos);
    	int offset=tpMsg.getCaretPosition();

    	//텍스트페인에 라벨 끼워넣기
	   //(JLabel은 문자열형태,아이콘 형태등 다양하게 표현 가능.)
    	tpMsg.insertComponent(lb);
    	try {
    		String sg="\r\n";//엔터값 끼워넣기(줄바꿈하도록)
    		
			doc.insertString(offset, sg, attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
    	//정렬방식 문단속성 적용
    	doc.setParagraphAttributes(offset+2,msg.length() , attr, true);
    	tpMsg.setCaretPosition(offset+2);
    	//커릿의 위치를 엔터값 2바이트 더해서 위치시킴

	}
    
    // 강사님 배포 코드. 카카오스타일 채팅.
    public synchronized void showCacaoStyle(String who,Color bgCr, 
    		Color fgCr, String msg) {
    	JLabel lb=new JLabel(msg);
    	lb.setOpaque(true);//라벨 배경색이 적용되려면 투명하게
    	lb.setPreferredSize(new Dimension(700,50)); 
    	//lb의 높이를 50으로 줌. 폭은 문자열 내용만큼 차지함
    	lb.setForeground(fgCr);
    	lb.setBackground(bgCr);
    	
    	if(who.equals("Me")) {
    		//내가 귓속말 보낼 경우
    		//보낸이가 나라면 오른쪽에 라벨 보여주기(노란색)
    		attr=new SimpleAttributeSet();
    		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
    	}else {
    		//내가 귓속말을 받을 경우
    		attr=new SimpleAttributeSet();
    		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
    	}
    	
    	setStyle(lb,msg,attr);	
    }// showCaCaoStyle()--------------------------------------------------------
    
    public synchronized void showCacaoStyle(String chatName, String foRgb,String msg) {
    	
    	String msg2="   "+chatName+">>"+msg+"  \n";
    	JLabel lb=new JLabel(msg2);
    	lb.setOpaque(true);//라벨 배경색이 적용되려면 투명하게
    	lb.setPreferredSize(new Dimension(700,50)); 
    	//lb의 높이를 40으로 줌. 폭은 문자열 내용만큼 차지함
    	lb.setForeground(new Color(Integer.parseInt(foRgb)));
    	
    	if(chatName.equals(this.chatName)) {
    		//보낸이가 나라면 오른쪽에 라벨 보여주기(노란색)
    		attr=new SimpleAttributeSet();
    		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
    		lb.setBackground(Color.YELLOW);
    	}else {
    		//보낸이가 다른이라면 왼쪽에 라벨 보여주기(핑크색)
    		attr=new SimpleAttributeSet();
    		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
    		lb.setBackground(Color.pink);
    	}
    	setStyle(lb,msg2,attr);
    	
    }// showCacaoStyle()----------------------------------------------------

    public synchronized void showEmoticon(String chatName, ImageIcon icon) {
        tpMsg.setCaretPosition(doc.getEndPosition().getOffset() - 1);
        int end = tpMsg.getCaretPosition();

        String msg2 = "[" + chatName + "]님" + "\r\n";
        
        JLabel lb=new JLabel(msg2,icon,JLabel.CENTER);
        
    	//lb.setOpaque(true);
        //라벨 배경색이 적용되려면 투명하게 true준다.
        //이모티콘 보낼 때는 불투명하게 false
    	lb.setPreferredSize(new Dimension(700,90)); 
    	//lb의 높이를 90으로 줌. 폭은 문자열 내용만큼 차지함
    	lb.setHorizontalTextPosition(JLabel.CENTER);
    	lb.setVerticalTextPosition(JLabel.BOTTOM);
    	
    	if(chatName.equals(this.chatName)) {
    		//보낸이가 나라면 오른쪽에 라벨 보여주기(노란색)
    		attr=new SimpleAttributeSet();
    		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
    		
    	}else {
    		//보낸이가 다른이라면 왼쪽에 라벨 보여주기(핑크색)
    		attr=new SimpleAttributeSet();
    		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
    		
    	}
    	setStyle(lb,msg2,attr);
    }// showEmotion()----------------------------------------------------
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btCon;
    private javax.swing.JButton btEmo;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btOut;
    private javax.swing.JButton btRename;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkSendOne;
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbChatName;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbId;
    private javax.swing.JRadioButton rbF;
    private javax.swing.JRadioButton rbM;
    private javax.swing.JTextField tfChatName;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfInput;
    private javax.swing.JTextPane tpMsg;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
