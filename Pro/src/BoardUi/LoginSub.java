package BoardUi;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import memvo.MEMBERVO;

public class LoginSub extends javax.swing.JFrame {
    // ȸ�� ���� â
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
        tfid.setFont(new java.awt.Font("����", 1, 18)); // NOI18N

        btcancel.setBackground(new java.awt.Color(58, 62, 70));
        btcancel.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
        btcancel.setForeground(new java.awt.Color(196, 205, 216));
        btcancel.setText("���");
        btcancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btcancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btcancelActionPerformed(evt);
			}
		});
        btsign.setBackground(new java.awt.Color(58, 62, 70));
        btsign.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
        btsign.setForeground(new java.awt.Color(196, 205, 216));
        btsign.setText("ȸ������");
        btsign.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btsign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsignActionPerformed(evt);
            }
        });

        lbid.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
        lbid.setForeground(new java.awt.Color(196, 205, 216));
        lbid.setText("���� �̸�");
        lbid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        lbpw.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
        lbpw.setForeground(new java.awt.Color(196, 205, 216));
        lbpw.setText("��й�ȣ");
        lbpw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        lbicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/memo01.png"))); // NOI18N

        btid.setBackground(new java.awt.Color(58, 62, 70));
        btid.setFont(new java.awt.Font("����", 1, 15)); // NOI18N
        btid.setForeground(new java.awt.Color(196, 205, 216));
        btid.setText("�ߺ�Ȯ��");
        btid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btidActionPerformed(evt);
            }
        });

        tfmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tfmail.setFont(new java.awt.Font("����", 1, 18)); // NOI18N

        lbmail.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
        lbmail.setForeground(new java.awt.Color(196, 205, 216));
        lbmail.setText("�̸��� �ּ�");
        lbmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tfpw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tfpw.setFont(new java.awt.Font("����", 1, 18)); // NOI18N

        lbtitle.setFont(new java.awt.Font("����", 1, 36)); // NOI18N
        lbtitle.setForeground(new java.awt.Color(196, 205, 216));
        lbtitle.setText("���� ���");
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
    
    // �ߺ�Ȯ�� ��ư
    boolean canUseId=false;
	private void btidActionPerformed(java.awt.event.ActionEvent evt) {
		BoardDAO bdao = new BoardDAO();
		String idn = tfid.getText();

		if (bdao.duplicationCheck(tfid.getText())) {
			JOptionPane.showMessageDialog(this, "���̵� �����մϴ�.");
			tfid.setText("");
			return;
		} else if (idn.length() < 6) {
			JOptionPane.showMessageDialog(this, "���̵� �ʹ� ª���ϴ�.");
			tfid.setText("");
			return;
		} else {
			JOptionPane.showMessageDialog(this, "���̵� ����� �����մϴ�!");
			canUseId=true;
		}
	}
    
    // ��� ��ư. ���� ����.
    private void btcancelActionPerformed(java.awt.event.ActionEvent evt) {                                       
    	JOptionPane.showMessageDialog(this, "â �ݱ� �޼ҵ� ����..");
    	this.setVisible(false);
		this.dispose();
    }
    
    // ȸ������ ��ư
    private void btsignActionPerformed(java.awt.event.ActionEvent evt) 
    {                                       
    	BoardDAO bdao = new BoardDAO();
		String iid = tfid.getText();
		String ipw = tfpw.getText();
		String iname = tfmail.getText();
		if (bdao.duplicationCheck(iid)) {
			if (iid == null || iid.trim().isEmpty() || iid.trim().contentEquals(" ")) 
			{
				// null���� ���ڿ� üũ
				JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���");
				tfid.requestFocus();
				return;
			} 
			else if (ipw == null || ipw.trim().isEmpty() || ipw.trim().contentEquals(" ")) 
			{
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
				tfpw.requestFocus();
				return;
			} 
			else if (iname == null || iname.trim().contentEquals(" ") || iname.trim().isEmpty()) 
			{
				JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���");
				tfmail.requestFocus(); 
				return;
			}
		} 
		else 
		{
			if(!canUseId) 
			{
				JOptionPane.showMessageDialog(this, "���̵� �ߺ�üũ�� ���ּ���");
				return;
			}
		}
		MEMBERVO mvo = new MEMBERVO(0, iid, ipw, iname, 0);
		// 4) MemoDAO��ü ���� �� insertMemo()ȣ���ϱ�
		int cnt;
		try 
		{
			cnt = bdao.insertMember(mvo);
			String str = (cnt > 0) ? "ȸ������ ����" : "ȸ������ ����(�� �� ���� ����)";
			JOptionPane.showMessageDialog(this, "ȸ������ �Ϸ� " + iname + "�� ȯ���մϴ�!");
			tfid.setText("");
			tfpw.setText("");
			tfmail.setText("");
			// [�߰�] ���ԿϷ� �� â�ݱ�
			this.dispose();
		} 
		catch (java.sql.SQLIntegrityConstraintViolationException e) 
		{
			String str = "�ߺ��Ǵ� ���̵��Դϴ�. ���̵� �ߺ� üũ�� �ϼ���";
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
