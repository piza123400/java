import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawRoundRectEx extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawRoundRectEx(){
		setTitle("drawRoundRect >> awawd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 170);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawRoundRect(20, 20, 120, 80, 40, 60); //1~4 = drawRect 5~6 세로 둥근 정도
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawRoundRectEx();
	}

}
