package BoardUi;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import boardvo.*;
import memvo.*;
import replyvo.*;

public class BoardList extends javax.swing.JFrame {

	CardLayout card;
	Login main;
	Reply_rg re;
	Reply_list rl;
	public static Integer idx;

	// 12.04 추가한 코드. 생성자.
	public BoardList() {}
	
	public BoardList(Login main) {
        initComponents();
        this.main=main;
        card=(CardLayout)this.jPanel2.getLayout();
        card.addLayoutComponent(pbWrite, "W");
        card.addLayoutComponent(pbList, "L");
        card.addLayoutComponent(pbView, "V");
       
    }

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
        pbList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btCreate = new javax.swing.JButton();
        lbicon1 = new javax.swing.JLabel();
        btboom = new javax.swing.JButton();
        bttyping = new javax.swing.JButton();
        btlib = new javax.swing.JButton();
        pbWrite = new javax.swing.JPanel();
        btSub = new javax.swing.JButton();
        lbicon2 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        tftitle = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tades = new javax.swing.JTextArea();
        lbtitle = new javax.swing.JLabel();
        btReturn = new javax.swing.JButton();
        pbView = new javax.swing.JPanel();
        btRe = new javax.swing.JButton();
        lbicon3 = new javax.swing.JLabel();
        p3 = new javax.swing.JPanel();
        tftitle1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tades1 = new javax.swing.JTextArea();
        lbtitle1 = new javax.swing.JLabel();
        btReturn2 = new javax.swing.JButton();
        btDel = new javax.swing.JButton();
        btRe_view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.CardLayout());

        pbList.setBackground(new java.awt.Color(31, 32, 34));
        pbList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTable1.setBackground(new java.awt.Color(41, 45, 51));
        jTable1.setForeground(new java.awt.Color(196, 205, 216));
        jTable1.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "글번호", "제목", "작성자"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        // 글 목록 창에 글 목록을 보여주는 코드.
        ArrayList<BoardVO> arr = dao.makeList();
        showTable(arr);
        
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		//마우스 클릭시 본문으로 이동
		jTable1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
			// 마우스로 누른 지점의 글 번호
			int row = jTable1.getSelectedRow();
			
			// 선택한 글번호 가져오기
			Object objIdx = jTable1.getValueAt(row,0);
				idx = (Integer) objIdx;
				
				ArrayList<BoardVO> arr = dao.clickContent(idx);
				if(arr!=null&&arr.size()==1) 
				{
					BoardVO b=arr.get(0);
					tftitle1.setText(b.getTitle());
					tades1.setText(b.getContent());
				}
				card.show(jPanel2,"V");
			}
		 });

        btCreate.setBackground(new java.awt.Color(58, 62, 70));
        btCreate.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btCreate.setForeground(new java.awt.Color(196, 205, 216));
        btCreate.setText("글쓰기");
        btCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateActionPerformed(evt);
            }
        });

        lbicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/memo01.png"))); // NOI18N
        
        btboom.setBackground(new java.awt.Color(58, 62, 70));
        btboom.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btboom.setForeground(new java.awt.Color(196, 205, 216));
        btboom.setText("지뢰찾기");
        btboom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btboomActionPerformed(evt);
            }
        });

        bttyping.setBackground(new java.awt.Color(58, 62, 70));
        bttyping.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        bttyping.setForeground(new java.awt.Color(196, 205, 216));
        bttyping.setText("코딩연습");
        bttyping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttypingActionPerformed(evt);
            }
        });

        btlib.setBackground(new java.awt.Color(58, 62, 70));
        btlib.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btlib.setForeground(new java.awt.Color(196, 205, 216));
        btlib.setText("API 사전");
        btlib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlibActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pbListLayout = new javax.swing.GroupLayout(pbList);
        pbList.setLayout(pbListLayout);
        pbListLayout.setHorizontalGroup(
            pbListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbListLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pbListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btlib, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pbListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pbListLayout.createSequentialGroup()
                            .addComponent(btboom, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(bttyping, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(pbListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pbListLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(lbicon1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(618, Short.MAX_VALUE)))
        );
        pbListLayout.setVerticalGroup(
            pbListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbListLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(btlib, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pbListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btboom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttyping, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pbListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pbListLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(lbicon1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );

        jPanel2.add(pbList, "card2");

        pbWrite.setBackground(new java.awt.Color(31, 32, 34));
        pbWrite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btSub.setBackground(new java.awt.Color(58, 62, 70));
        btSub.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btSub.setForeground(new java.awt.Color(196, 205, 216));
        btSub.setText("등록");
        btSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubActionPerformed(evt);
            }
        });

        lbicon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/memo01.png"))); // NOI18N

        p2.setBackground(new java.awt.Color(41, 45, 51));
        
        tftitle.setFont(new java.awt.Font("굴림", 1, 20)); // NOI18N

        tades.setColumns(20);
        tades.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        tades.setRows(5);
        tades.setPreferredSize(new java.awt.Dimension(225, 104));
        jScrollPane2.setViewportView(tades);

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tftitle)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
                .addContainerGap())
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2Layout.createSequentialGroup()
                .addComponent(tftitle, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbtitle.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        lbtitle.setForeground(new java.awt.Color(196, 205, 216));
        lbtitle.setText("글 쓰 기");
        lbtitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        btReturn.setBackground(new java.awt.Color(58, 62, 70));
        btReturn.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btReturn.setForeground(new java.awt.Color(196, 205, 216));
        btReturn.setText("글목록");
        btReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReturnActionPerformed(evt);
            }
        });
        
        btDel.setBackground(new java.awt.Color(58, 62, 70));
        btDel.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btDel.setForeground(new java.awt.Color(196, 205, 216));
        btDel.setText("글 삭제");
        btDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelActionPerformed(evt);
            }
        });
        
        btRe_view.setBackground(new java.awt.Color(58, 62, 70));
        btRe_view.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btRe_view.setForeground(new java.awt.Color(196, 205, 216));
        btRe_view.setText("댓글 보기");
        btRe_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRe_viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pbWriteLayout = new javax.swing.GroupLayout(pbWrite);
        pbWrite.setLayout(pbWriteLayout);
        pbWriteLayout.setHorizontalGroup(
            pbWriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbWriteLayout.createSequentialGroup()
                .addGroup(pbWriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pbWriteLayout.createSequentialGroup()
                        .addGap(510, 510, 510)
                        .addGroup(pbWriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pbWriteLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE))
                            .addGroup(pbWriteLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSub, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pbWriteLayout.createSequentialGroup()
                        .addContainerGap(75, Short.MAX_VALUE)
                        .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(pbWriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pbWriteLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(lbicon2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(618, Short.MAX_VALUE)))
        );
        pbWriteLayout.setVerticalGroup(
            pbWriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbWriteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pbWriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSub, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pbWriteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pbWriteLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(lbicon2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );

        jPanel2.add(pbWrite, "card3");

        pbView.setBackground(new java.awt.Color(31, 32, 34));
        pbView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btRe.setBackground(new java.awt.Color(58, 62, 70));
        btRe.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btRe.setForeground(new java.awt.Color(196, 205, 216));
        btRe.setText("댓글 등록");
        btRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReActionPerformed(evt);
            }
        });

        lbicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/memo01.png"))); // NOI18N

        p3.setBackground(new java.awt.Color(41, 45, 51));

        tftitle1.setEditable(false);
        tftitle1.setFont(new java.awt.Font("굴림", 1, 20)); // NOI18N

        tades1.setEditable(false);
        tades1.setColumns(20);
        tades1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        tades1.setRows(5);
        tades1.setPreferredSize(new java.awt.Dimension(225, 104));
        jScrollPane3.setViewportView(tades1);

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tftitle1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
                .addContainerGap())
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3Layout.createSequentialGroup()
                .addComponent(tftitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbtitle1.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        lbtitle1.setForeground(new java.awt.Color(196, 205, 216));
        lbtitle1.setText("Study Java");
        lbtitle1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        btReturn2.setBackground(new java.awt.Color(58, 62, 70));
        btReturn2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btReturn2.setForeground(new java.awt.Color(196, 205, 216));
        btReturn2.setText("글목록");
        btReturn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReturn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pbViewLayout = new javax.swing.GroupLayout(pbView);
        pbView.setLayout(pbViewLayout);
        pbViewLayout.setHorizontalGroup(
            pbViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbViewLayout.createSequentialGroup()
                .addGroup(pbViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pbViewLayout.createSequentialGroup()
                        .addGap(593, 593, 593)
                        .addComponent(lbtitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE))
                    .addGroup(pbViewLayout.createSequentialGroup()
                        .addContainerGap(83, Short.MAX_VALUE)
                        .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pbViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btDel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btReturn2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRe_view, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(pbViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pbViewLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(lbicon3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(618, Short.MAX_VALUE)))
        );
        pbViewLayout.setVerticalGroup(
            pbViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbViewLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbtitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pbViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRe, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReturn2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRe_view, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pbViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pbViewLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(lbicon3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE)))
        );

        jPanel2.add(pbView, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>     
    
    BoardDAO dao = new BoardDAO();
    // 글 목록 창에서 글쓰기 창으로 가는 버튼
    private void btCreateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        card.show(jPanel2,"W");
    }                                        
    // 글쓰기 창에서 글 등록 버튼
    private void btSubActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	BoardDAO dao = new BoardDAO();
    	BoardVO vo = new BoardVO();
    	
    	// 12.04 추가. 글 등록시 id 추가 및 글 등록 후 글목록 자동 refresh.
    	vo.setTitle(tftitle.getText());
    	vo.setContent(tades.getText());
    	vo.setId(dao.uid);
    	dao.AddBoard(vo);
    	
    	jTable1.removeAll();
    	
        ArrayList<BoardVO> arr = dao.makeList();
        showTable(arr);
    	
        card.show(jPanel2,"L"); // 임시코드
    }                                     
    // 글쓰기 창에서 글목록으로 이동 버튼
    private void btReturnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        card.show(jPanel2,"L");
    }                                        
    // 글 본문 창에서 댓글 등록 버튼
    private void btReActionPerformed(java.awt.event.ActionEvent evt) {                                     
    	re = new Reply_rg();
		re.pack();
		re.setLocation(800, 100);
		re.setVisible(true);
		re.boardNum = idx;
    }
    // 글 본문 창에서 댓글 보기 버튼
    private void btRe_viewActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	rl = new Reply_list();
		rl.pack();
		rl.setLocation(800, 100);
		rl.setVisible(true);
		
    }
    // 글 본문 창에서 글 삭제 버튼
    private void btDelActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = jTable1.getSelectedRow();
    	Object objIdx = jTable1.getValueAt(row, 0);
		Integer idx = (Integer) objIdx;
		int yn = JOptionPane.showConfirmDialog(jTable1, "선택하신 글을 삭제할까요?");
		if(yn == JOptionPane.YES_OPTION) 
		{
			int r = dao.delete(idx);
		}
		
		jTable1.removeAll();
        ArrayList<BoardVO> arr = dao.makeList();
        showTable(arr);
        card.show(jPanel2,"L");
    }
    
    // 글 본문 창에서 글목록으로 이동 버튼
    private void btReturn2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        card.show(jPanel2,"L");
    }  
    // 글 목록 창에 보여줄 글 목록을 생성하는 메서드.
    public void showTable(ArrayList<BoardVO> arr)
    {
    	String [] colHeader = {"글번호", "제목", "글내용", "작성자"};
    	Object [][] data = new Object[arr.size()][5];
    	// ArrayList에 있는 내용을 data에 옮기기.
    	for(int i = 0; i < data.length; i++)
    	{
    		BoardVO contentsList = arr.get(i);
    		data[i][0] = contentsList.getBoardnum();
    		data[i][1] = contentsList.getTitle();
    		data[i][2] = contentsList.getContent();
    		data[i][3] = contentsList.getId();
    		data[i][4] = contentsList.getWdate();
    	}
    	// DefaultTableModel = model = new DefaultTableModel(2차원 배열, 1차원 배열)
    	DefaultTableModel model = new DefaultTableModel(data, colHeader);
    	jTable1.setModel(model);
    }
    
    // 지뢰찾기 버튼
    private void btboomActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      
    
    // 코딩 타자연습 버튼
    private void bttypingActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    // API 사전 버튼
    private void btlibActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btCreate;
    private javax.swing.JButton btDel;
    private javax.swing.JButton btRe;
    private javax.swing.JButton btRe_view;
    private javax.swing.JButton btReturn;
    private javax.swing.JButton btReturn2;
    private javax.swing.JButton btSub;
    private javax.swing.JButton btboom;
    private javax.swing.JButton btlib;
    private javax.swing.JButton bttyping;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbicon1;
    private javax.swing.JLabel lbicon2;
    private javax.swing.JLabel lbicon3;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JLabel lbtitle1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel pbList;
    private javax.swing.JPanel pbView;
    private javax.swing.JPanel pbWrite;
    private javax.swing.JTextArea tades;
    private javax.swing.JTextArea tades1;
    private javax.swing.JTextField tftitle;
    private javax.swing.JTextField tftitle1;
    // End of variables declaration                    
}
