package tischats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

/*
 * JTextPane : 폰트, 굵기, 기울임, 정렬 등과 같은 다양한 서식을 사용할 수 있다.
 * 
 * 사용 절차
 * 1. SimpleAttributeSet 객체를 생성.
 * 2. Styleconstants 클래스의 static 메서드를 통해 1번 객체에 속성을 설정.
 * 3. 이들 속성을 문서에 적용할 경우 StyledDocument(텍스트페인의 문서모델)의
 * 		setCharacterAttribute(attr, false) 또는 setParagraphAttributes() 등의 메서드를 통해
 * 		원하는 영역에 젹용시킨다.
 */

public class JTextPaneDemo extends JFrame
{
	JPanel p = new JPanel(new BorderLayout());
	JTextPane tp;
	StyledDocument sd;	// 문서모델

	public JTextPaneDemo()
	{
		super("::JTextPaneDemo::");
		Container cp = this.getContentPane();
		cp.add(p, "Center");
		p.setBackground(Color.white);
		
		tp = new JTextPane();
		p.add(new JScrollPane(tp), "Center");
		tp.setText("미-중 1단계 무역합의가 타결되었지만 중국의 농산물 구매 규모 등 세부사항이 모호하자 “스몰딜”에 불과하다는 평가 속에 미 증시는 13일  등락을 거듭한 뒤 가까스로 강보합에 마감했다.");
		
		// 1. 문서 모델 얻기.
		sd = tp.getStyledDocument();
		// 2. 속성을 지정할 객체를 만들고 여러가지 속성을 부여하자.
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr, "궁서체");
		StyleConstants.setFontSize(attr, 20);
		// 3. 문서 모델에 attr을 적용.
		sd.setCharacterAttributes(0, 10, attr, true);
//		(offset: 시작위치, length : 적용할 길이, s : attribute, replace : 대체 여부)
		
		attr = new SimpleAttributeSet();
		StyleConstants.setUnderline(attr, true);
		StyleConstants.setItalic(attr, true);
		StyleConstants.setForeground(attr, Color.red);
		StyleConstants.setBackground(attr, Color.yellow);
		sd.setCharacterAttributes(11, 40, attr, true);
		
		// 중앙 정렬 특성을 가지는 문단 특성을 적용해 보자.
		attr = new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_CENTER);
		sd.setParagraphAttributes(0, tp.getText().length(), attr, true);
		
		// 문서 끝에 문자열 추가.
		try
		{
			int caretPos1 = sd.getEndPosition().getOffset() - 1;		// 커서 위치 잡기.
			sd.insertString(caretPos1, "\nBye Bye~~\n", attr);
		} 
		catch (BadLocationException e)
		{
			e.printStackTrace();
		}
		
		JLabel lb = new JLabel(new ImageIcon("src/tischats/images/notepaddd.jpg"));
		lb.setOpaque(true);	// 레이블에 배경색이 적용되도록 하려면 투명하게 설정해 주어야 함.
		lb.setPreferredSize(new Dimension(400, 50));	// width, height.
		lb.setForeground(Color.blue);
		lb.setBackground(Color.lightGray);
		
		attr = new SimpleAttributeSet();
		StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
		
		// insertComponent()		
		int caretPos = sd.getEndPosition().getOffset() - 1;		// 커서 위치 잡기.
		tp.setCaretPosition(caretPos);		// tp에서 커서의 위치 설정.
		tp.insertComponent(lb);
		tp.setParagraphAttributes(attr, true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		JTextPaneDemo jtp = new JTextPaneDemo();
		jtp.setSize(500, 500);
		jtp.setVisible(true);
	}
}