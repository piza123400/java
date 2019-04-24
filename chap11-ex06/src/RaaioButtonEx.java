import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class RaaioButtonEx extends JFrame {
	public RaaioButtonEx() {
		setTitle("라디오버튼 예쩨");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");

		ButtonGroup g = new ButtonGroup();

		JRadioButton apple = new JRadioButton("사과",true);
		JRadioButton pear = new JRadioButton("배", true);
		JRadioButton cherry = new JRadioButton("체리", cherryIcon);

		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);

		g.add(apple);
		g.add(pear);
		g.add(cherry);

		c.add(apple);
		c.add(pear);
		c.add(cherry);

		setSize(250, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RaaioButtonEx();
	}

}
