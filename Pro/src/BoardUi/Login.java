package BoardUi;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
	
	// 로그인 화면
	BoardList bl = new BoardList(this); // 게시판 메인
	LoginSub ls; // 회원가입
	FindUser fu; // 회원찾기
	
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")                       
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        p1 = new javax.swing.JPanel();
        tfid = new javax.swing.JTextField();
        tfpw = new javax.swing.JTextField();
        btLogin = new javax.swing.JButton();
        btSub = new javax.swing.JButton();
        lbid = new javax.swing.JLabel();
        lbpw = new javax.swing.JLabel();
        lbicon = new javax.swing.JLabel();
        cbid = new javax.swing.JCheckBox();
        cblog = new javax.swing.JCheckBox();
        btfind = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        p1.setBackground(new java.awt.Color(41, 45, 51));

        tfid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tfpw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btLogin.setBackground(new java.awt.Color(58, 62, 70));
        btLogin.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btLogin.setForeground(new java.awt.Color(196, 205, 216));
        btLogin.setText("로그인");
        btLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btLoginActionPerformed(evt);
			}
		});
        btSub.setBackground(new java.awt.Color(58, 62, 70));
        btSub.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        btSub.setForeground(new java.awt.Color(196, 205, 216));
        btSub.setText("회원가입");
        btSub.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubActionPerformed(evt);
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

        cbid.setBackground(new java.awt.Color(60, 64, 73));
        cbid.setForeground(new java.awt.Color(196, 205, 216));
        cbid.setText("아이디 저장");

        cblog.setBackground(new java.awt.Color(60, 64, 73));
        cblog.setForeground(new java.awt.Color(196, 205, 216));
        cblog.setText("자동 로그인");

        btfind.setBackground(new java.awt.Color(58, 62, 70));
        btfind.setFont(new java.awt.Font("굴림", 1, 15)); // NOI18N
        btfind.setForeground(new java.awt.Color(196, 205, 216));
        btfind.setText("아이디 / 비밀번호 찾기");
        btfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbpw, javax.swing.GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(p1Layout.createSequentialGroup()
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfpw, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(145, Short.MAX_VALUE))
                            .addGroup(p1Layout.createSequentialGroup()
                                .addComponent(cbid, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cblog)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btfind, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(p1Layout.createSequentialGroup()
                                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btSub, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(146, 146, 146))))
        );

        p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbid, lbpw});

        p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfid, tfpw});

        p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbid, cblog});

        p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btLogin, btSub});

        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(lbid)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfpw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbpw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cblog))
                .addGap(18, 18, 18)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSub, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btfind, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbid, lbpw});

        p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btLogin, btSub});

        p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbid, cblog});

        p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfid, tfpw});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>
    
    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {
    	JOptionPane.showMessageDialog(this, "BoardVO bv = new BoardVO(idx, id, pw)");
    	JOptionPane.showMessageDialog(this, "int dao = dao.Login(bv)");
    	//[1] id, pw, 가져오기
    	String id = tfid.getText();
		String pw = tfpw.getText();
		
		// [2] id, pw 유효성 확인
		if (id == null || pw == null) {
			JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하세요");
			tfid.requestFocus();
			return;
		}
    	// [3] VO 불러와서 값 넣어주기
		
		// [4] DAO 쿼리에 입력 : id pw 일치 확인
		
		// [5] 게시판 화면 로드
		bl.pack();
		bl.setLocation(500, 0);
		bl.setVisible(true);
		
		// [6] 로그인창 닫기
		this.setVisible(false);
		this.dispose();
	}

    private void btSubActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	ls = new LoginSub();
		ls.pack();
		ls.setLocation(500, 0);
		ls.setVisible(true);
    }          
    
    private void btfindActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	fu = new FindUser();
		fu.pack();
		fu.setLocation(500, 0);
		fu.setVisible(true);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
                 
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSub;
    private javax.swing.JButton btfind;
    private javax.swing.JCheckBox cbid;
    private javax.swing.JCheckBox cblog;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lbpw;
    private javax.swing.JPanel p1;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfpw;                   
}
