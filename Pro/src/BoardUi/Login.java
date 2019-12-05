package BoardUi;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
        cbpw2 = new javax.swing.JCheckBox();
        lbpw1 = new javax.swing.JLabel();
        lbpw2 = new javax.swing.JLabel();

		jLabel5.setText("jLabel5");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		p1.setBackground(new java.awt.Color(41, 45, 51));

		tfid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
		tfid.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N

		tfpw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
		tfpw.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
		tfpw.setSelectedTextColor(new java.awt.Color(255, 255, 255));
		tfpw.setSelectionColor(new java.awt.Color(255, 255, 255));
		tfpw.setForeground(new java.awt.Color(255, 255, 255));

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
		lbid.setText("아이디");
		lbid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

		lbpw.setFont(new java.awt.Font("굴림", 1, 17)); // NOI18N
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

		cbpw2.setBackground(new java.awt.Color(60, 64, 73));
		cbpw2.setFont(new java.awt.Font("굴림", 1, 15)); // NOI18N
		cbpw2.setForeground(new java.awt.Color(196, 205, 216));
		cbpw2.setSelected(true);
		cbpw2.setText("비밀번호 숨김");
		cbpw2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		cbpw2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				tfpw.setForeground(new java.awt.Color(0, 0, 0));
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tfpw.setForeground(new java.awt.Color(255, 255, 255));
				}
			}
			
		});
		cbpw2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbpw2ActionPerformed(evt);
			}
		});
		
		lbpw1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lbpw1.setForeground(new java.awt.Color(196, 205, 216));
        lbpw1.setText("Release v1.1");
        lbpw1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        lbpw2.setFont(new java.awt.Font("굴림", 0, 11)); // NOI18N
        lbpw2.setForeground(new java.awt.Color(196, 205, 216));
        lbpw2.setText("CopyRight (c) 2019. 3Team. All Rights Reserved");
        lbpw2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

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
                            .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(p1Layout.createSequentialGroup()
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfpw, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addComponent(cbid, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cblog)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpw2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbpw1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSub, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addComponent(btfind, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbpw2)))
                .addGap(12, 12, 12))
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
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbpw2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(p1Layout.createSequentialGroup()
                                .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfpw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpw, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)))
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbpw1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbpw2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cblog))
                        .addGap(18, 18, 18)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSub, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btfind, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(36, Short.MAX_VALUE))))
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

	private void cbpw2ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {
		BoardDAO bdao = new BoardDAO();
		String lid = tfid.getText();
		String lpw = tfpw.getText();
		bdao.login(lid, lpw);
		if (lid.equals(bdao.uid) && lpw.equals(bdao.upw)) {
			JOptionPane.showMessageDialog(this, "환영합니다.");
			bl.pack();
			bl.setLocation(500, 100);
			bl.setVisible(true);
			this.setVisible(false);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "아이디나 비밀번호가 틀렸습니다.");
		}
	}

	private void btSubActionPerformed(java.awt.event.ActionEvent evt) {
		ls = new LoginSub();
		ls.pack();
		ls.setLocation(500, 100);
		ls.setVisible(true);
	}

	private void btfindActionPerformed(java.awt.event.ActionEvent evt) {
		fu = new FindUser();
		fu.pack();
		fu.setLocation(500, 100);
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

	 // Variables declaration - do not modify                     
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSub;
    private javax.swing.JButton btfind;
    private javax.swing.JCheckBox cbid;
    private javax.swing.JCheckBox cblog;
    private javax.swing.JCheckBox cbpw2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lbpw;
    private javax.swing.JLabel lbpw1;
    private javax.swing.JLabel lbpw2;
    private javax.swing.JPanel p1;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfpw;
    // End of variables declaration    
}
