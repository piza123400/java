import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyCodeEx extends JFrame {
	private JLabel la = new JLabel();

	public KeyCodeEx() {
		setTitle("Key code 예제 : f1:초록색 f2;노란색 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.addKeyListener(new MyKeyListener());
		c.add(la);
		setSize(300,150);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			Container container = (Container) e.getSource();

			la.setText(KeyEvent.getKeyText(e.getKeyCode()) + "키가 입력됨");

			if (e.getKeyChar() == '%')
				getContentPane().setBackground(Color.YELLOW);
			else if (e.getKeyCode() == KeyEvent.VK_F1)
				getContentPane().setBackground(Color.GREEN);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyCodeEx();
	}

}
