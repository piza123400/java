import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawArcEx extends JFrame{
	
	private MyPanel panel = new MyPanel();
			
	public GraphicsDrawArcEx(){
		setTitle("drawArc >> aawd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(200, 300);
		setVisible(true);
		
	}

	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawArc(20,100,80,80,90,270); //1~4 원 5 부채꼴을 시작하는 각도 , 6 표현하는 각도
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawArcEx();
	}

}
