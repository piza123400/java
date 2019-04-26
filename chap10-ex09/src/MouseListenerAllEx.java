import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerAllEx extends JFrame {

	private JLabel la = new JLabel("No Mouse Event");

	public MouseListenerAllEx() {
		setTitle("MouseListener¿Í MouseMotionListener¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);


		c.add(la);
		setSize(300, 200);
		setVisible(true);

	}

	class MyMouseListener implements MouseListener, MouseMotionListener {

		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed (" + e.getX() + "," + e.getY() + ")");
		}

		public void mouseReleased(MouseEvent e) {
			la.setText("mouseRelaeased (" + e.getX() + "," + e.getY() + ")");
		}

		

		public void mouseEntered(MouseEvent e) {
			Component c = (Component) e.getSource();
			c.setBackground(Color.CYAN);
		}

		public void mouseExited(MouseEvent e){
			Component c = (Component)e.getSource();
			c.setBackground(Color.YELLOW);

		}
		public void mouseDragged(MouseEvent e) {
			la.setText("mouseDragged (" + e.getX() + "," + e.getY() + ")");
		}

		public void mouseMoved(MouseEvent e) {
			la.setText("mouseMoved (" + e.getX() + "," + e.getY() + ")");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}

	public void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseListenerAllEx();
	}

}
