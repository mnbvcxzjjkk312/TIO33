package BoardUi;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import memvo.MEMBERVO;

public class LoginSub extends javax.swing.JFrame {
    // 회원 가입 창
    public LoginSub() {
        initComponents();
    }

    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        p1 = new javax.swing.JPanel();
        tfid = new javax.swing.JTextField();
        btcancel = new javax.swing.JButton();
        btsign = new javax.swing.JButton();
        lbid = new javax.swing.JLabel();
        lbpw = new javax.swing.JLabel();
        lbicon = new javax.swing.JLabel();
        btid = new javax.swing.JButton();
        tfmail = new javax.swing.JTextField();
        lbmail = new javax.swing.JLabel();
        tfpw = new javax.swing.JTextField();
        lbtitle = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        p1.setBackground(new java.awt.Color(41, 45, 51));

        tfid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tfid.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N

        btcancel.setBackground(new java.awt.Color(58, 62, 70));
        btcancel.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btcancel.setForeground(new java.awt.Color(196, 205, 216));
        btcancel.setText("취소");
        btcancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btcancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btcancelActionPerformed(evt);
			}
		});
        btsign.setBackground(new java.awt.Color(58, 62, 70));
        btsign.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btsign.setForeground(new java.awt.Color(196, 205, 216));
        btsign.setText("회원가입");
        btsign.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btsign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsignActionPerformed(evt);
            }
        });

        lbid.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lbid.setForeground(new java.awt.Color(196, 205, 216));
        lbid.setText("계정 이름");
        lbid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        lbpw.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lbpw.setForeground(new java.awt.Color(196, 205, 216));
        lbpw.setText("비밀번호");
        lbpw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        lbicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/memo01.png"))); // NOI18N

        btid.setBackground(new java.awt.Color(58, 62, 70));
        btid.setFont(new java.awt.Font("굴림", 1, 15)); // NOI18N
        btid.setForeground(new java.awt.Color(196, 205, 216));
        btid.setText("중복확인");
        btid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btidActionPerformed(evt);
            }
        });

        tfmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tfmail.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N

        lbmail.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lbmail.setForeground(new java.awt.Color(196, 205, 216));
        lbmail.setText("이메일 주소");
        lbmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tfpw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tfpw.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N

        lbtitle.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        lbtitle.setForeground(new java.awt.Color(196, 205, 216));
        lbtitle.setText("계정 등록");
        lbtitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbpw, javax.swing.GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(lbid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p1Layout.createSequentialGroup()
                                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btid))
                            .addComponent(tfpw, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btsign, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(p1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(lbmail, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfmail, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbid, lbpw});

        p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btcancel, btsign});

        p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfid, tfmail, tfpw});

        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(18, 18, 18)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btid, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addComponent(lbid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbpw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btsign, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbid, lbpw});

        p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btcancel, btsign});

        p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfid, tfmail, tfpw});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>   
    
    // 중복확인 버튼
    boolean canUseId=false;
	private void btidActionPerformed(java.awt.event.ActionEvent evt) {
		BoardDAO bdao = new BoardDAO();
		String idn = tfid.getText();

		if (bdao.duplicationCheck(tfid.getText())) {
			JOptionPane.showMessageDialog(this, "아이디가 존재합니다.");
			tfid.setText("");
			return;
		} else if (idn.length() < 6) {
			JOptionPane.showMessageDialog(this, "아이디가 너무 짧습니다.");
			tfid.setText("");
			return;
		} else {
			JOptionPane.showMessageDialog(this, "아이디 사용이 가능합니다!");
			canUseId=true;
		}
	}
    
    // 취소 버튼. 현재 없음.
    private void btcancelActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	JOptionPane.showMessageDialog(this, "창 닫기 메소드 진행..");
    	this.setVisible(false);
		this.dispose();
    }
    
    // 회원가입 버튼
    private void btsignActionPerformed(java.awt.event.ActionEvent evt) 
    {                                       
    	BoardDAO bdao = new BoardDAO();
		String iid = tfid.getText();
		String ipw = tfpw.getText();
		String iname = tfmail.getText();
		if (bdao.duplicationCheck(iid)) {
			if (iid == null || iid.trim().isEmpty() || iid.trim().contentEquals(" ")) 
			{
				// null값과 빈문자열 체크
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
				tfid.requestFocus();
				return;
			} 
			else if (ipw == null || ipw.trim().isEmpty() || ipw.trim().contentEquals(" ")) 
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				tfpw.requestFocus();
				return;
			} 
			else if (iname == null || iname.trim().contentEquals(" ") || iname.trim().isEmpty()) 
			{
				JOptionPane.showMessageDialog(this, "이름을 입력하세요");
				tfmail.requestFocus(); 
				return;
			}
		} 
		else 
		{
			if(!canUseId) 
			{
				JOptionPane.showMessageDialog(this, "아이디 중복체크를 해주세요");
				return;
			}
		}
		MEMBERVO mvo = new MEMBERVO(0, iid, ipw, iname, 0);
		// 4) MemoDAO객체 생성 후 insertMemo()호출하기
		int cnt;
		try 
		{
			cnt = bdao.insertMember(mvo);
			String str = (cnt > 0) ? "회원가입 성공" : "회원가입 실패(알 수 없는 오류)";
			JOptionPane.showMessageDialog(this, "회원가입 완료 " + iname + "님 환영합니다!");
			tfid.setText("");
			tfpw.setText("");
			tfmail.setText("");
			// [추가] 가입완료 시 창닫기
			this.dispose();
		} 
		catch (java.sql.SQLIntegrityConstraintViolationException e) 
		{
			String str = "중복되는 아이디입니다. 아이디 중복 체크를 하세요";
			JOptionPane.showMessageDialog(this, str);
			tfid.setText("");
		} 
		catch(SQLException e) 
		{
			String str = e.getMessage();
			JOptionPane.showMessageDialog(this, str);
		}
    }                                      

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginSub().setVisible(true);
            }
        });
    }
                   
    private javax.swing.JButton btcancel;
    private javax.swing.JButton btid;
    private javax.swing.JButton btsign;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lbmail;
    private javax.swing.JLabel lbpw;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JPanel p1;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfmail;
    private javax.swing.JTextField tfpw;            
}
