import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class paintJPanelEx extends JFrame{

	private Container panel = new MyPanel();
	
	public paintJPanelEx(){
		setTitle("JPanel ÀÇ paintComponent()¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(550,550);
		setVisible(true);
		
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10,10,50,50); 
			g.drawRect(50,50,50,50);
			
		
			g.setColor(Color.MAGENTA);
			g.drawRect(90,90,50,50);
			g.drawRect(90,90,50,50);
			g.drawRect(90,90,50,50);
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new paintJPanelEx();
	}

}
