package BoardUi;

import javax.swing.JOptionPane;

public class FindUser extends javax.swing.JFrame {
// 아이디 비밀번호 찾기
	public FindUser() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jLabel5 = new javax.swing.JLabel();
		p1 = new javax.swing.JPanel();
		btpw_find = new javax.swing.JButton();
		btid_find = new javax.swing.JButton();
		lbicon = new javax.swing.JLabel();
		tfmail = new javax.swing.JTextField();
		lbmail = new javax.swing.JLabel();
		lbtitle = new javax.swing.JLabel();
		lbid = new javax.swing.JLabel();
		tfid_find = new javax.swing.JTextField();
		lbmail2 = new javax.swing.JLabel();
		tfmail2 = new javax.swing.JTextField();

		jLabel5.setText("jLabel5");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		p1.setBackground(new java.awt.Color(41, 45, 51));

		btpw_find.setBackground(new java.awt.Color(58, 62, 70));
		btpw_find.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
		btpw_find.setForeground(new java.awt.Color(196, 205, 216));
		btpw_find.setText("비밀번호 찾기");
		btpw_find.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		btpw_find.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btpw_findActionPerformed(evt);
			}
		});

		btid_find.setBackground(new java.awt.Color(58, 62, 70));
		btid_find.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
		btid_find.setForeground(new java.awt.Color(196, 205, 216));
		btid_find.setText("아이디 찾기");
		btid_find.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		btid_find.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btid_findActionPerformed(evt);
			}
		});

		lbicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/memo01.png"))); // NOI18N

		tfmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

		lbmail.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
		lbmail.setForeground(new java.awt.Color(196, 205, 216));
		lbmail.setText("이메일 주소");
		lbmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

		lbtitle.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
		lbtitle.setForeground(new java.awt.Color(196, 205, 216));
		lbtitle.setText("계정 찾기");
		lbtitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

		lbid.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
		lbid.setForeground(new java.awt.Color(196, 205, 216));
		lbid.setText("계정 이름");
		lbid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

		tfid_find.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

		lbmail2.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
		lbmail2.setForeground(new java.awt.Color(196, 205, 216));
		lbmail2.setText("이메일 주소");
		lbmail2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

		tfmail2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

		javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
		p1.setLayout(p1Layout);
		p1Layout.setHorizontalGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p1Layout.createSequentialGroup()
						.addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(p1Layout.createSequentialGroup().addGap(68, 68, 68)
										.addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 252,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(44, 44, 44).addComponent(lbtitle,
												javax.swing.GroupLayout.PREFERRED_SIZE, 171,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(p1Layout.createSequentialGroup().addGap(78, 78, 78).addGroup(p1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(btid_find, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(p1Layout.createSequentialGroup()
												.addComponent(lbmail, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(73, 73, 73)
												.addComponent(tfmail, javax.swing.GroupLayout.PREFERRED_SIZE, 303,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(p1Layout.createSequentialGroup().addGap(79, 79, 79).addGroup(p1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(
												btpw_find, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(p1Layout.createSequentialGroup().addGroup(p1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbid, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														lbmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(p1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(p1Layout.createSequentialGroup().addGap(62, 62, 62)
																.addComponent(
																		tfid_find,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 302,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout
																.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(tfmail2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 303,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))))))
						.addContainerGap(66, Short.MAX_VALUE)));

		p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { btid_find, btpw_find });

		p1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { tfid_find, tfmail2 });

		p1Layout.setVerticalGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(p1Layout.createSequentialGroup().addGap(18, 18, 18)
						.addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbicon, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(tfmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(6, 6, 6)
						.addComponent(btid_find, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(29, 29, 29)
						.addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(tfid_find, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbid))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(tfmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(btpw_find, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(42, Short.MAX_VALUE)));

		p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btid_find, btpw_find });

		p1Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { lbid, lbmail2, tfid_find, tfmail2 });

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(p1,
				javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(p1,
				javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>

	private void btpw_findActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "비밀번호는 : [ 1234 ] 입니다.");
	}

	private void btid_findActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "아이디는 : [ tiger ] 입니다.");
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
			java.util.logging.Logger.getLogger(FindUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FindUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FindUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FindUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FindUser().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btid_find;
	private javax.swing.JButton btpw_find;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel lbicon;
	private javax.swing.JLabel lbid;
	private javax.swing.JLabel lbmail;
	private javax.swing.JLabel lbmail2;
	private javax.swing.JLabel lbtitle;
	private javax.swing.JPanel p1;
	private javax.swing.JTextField tfid_find;
	private javax.swing.JTextField tfmail;
	private javax.swing.JTextField tfmail2;
	// End of variables declaration
}
