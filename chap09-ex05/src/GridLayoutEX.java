import javax.swing.*;
import java.awt.*;
//import java.time.temporal.JulianFields;

public class GridLayoutEX extends JFrame {
	public GridLayoutEX() {
		setTitle("GridLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(4, 2);
		grid.setVgap(5);

		Container c = getContentPane();
		c.add(new JLabel(" �̸�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �й�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �а�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" ����"));
		c.add(new JTextField(""));
		setSize(300,200);
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayoutEX();

	}

}
