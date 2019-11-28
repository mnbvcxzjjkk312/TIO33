package BoardUi;

import javax.swing.*;
import java.awt.*;

public class MainUi extends JFrame {

	JPanel p = new JPanel((new BorderLayout()));
	Login log;
	
	public MainUi() {
		super(":: 3팀 게시판 ::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.WHITE);
		
		log = new Login();
		log.pack();
		log.setLocation(500, 0);
		log.setVisible(true);

		// 모든 프로세스 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}//////////////////////////////////////

	public static void main(String[] args) {
		MainUi mu = new MainUi();
		mu.setSize(500, 500);
		mu.setVisible(false);
	}

}
