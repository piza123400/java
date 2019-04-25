import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx3 extends JFrame {

	private Mypanel panel = new Mypanel();

	public GraphicsDrawImageEx3() {
		setTitle("ㅇㅣ미지  일부분을 크기 조절하여 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(300, 300);
		setVisible(true);
	}
	class Mypanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/inage0.jpg");
		private Image img = icon.getImage();
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicsDrawImageEx3();
	}

}
