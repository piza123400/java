import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawPolyginEx extends JFrame {

	private MyPanel panel = new MyPanel();

	public GraphicsDrawPolyginEx() {

		setTitle("drawPolygin >> awdawd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(200, 300);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			int[] x = { 80, 40, 80, 120 };
			int[] y = { 40, 120, 200, 120 };
			g.drawPolygon(x,y,4); // 3번째는 좌표의 개수
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawPolyginEx();
	}

}
