import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawStringEx extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawStringEx(){
		setTitle("drawString ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(250, 200);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("�ڹٴ� ����ִ�",30,30);
			g.drawString("�󸶳�? �ϴø�ŭ ����ŭ",60,60);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawStringEx();
	}	

}
