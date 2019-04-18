import javax.swing.*;
import java.awt.*;
import java.time.temporal.JulianFields;

public class NullContainerEX extends JFrame{
	public NullContainerEX(){
		setTitle("Null Container Samle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel la = new JLabel("hello, press buttons!");
		la.setLocation(130,50);
		la.setSize(200,20);
		c.add(la);
		
		for(int i=1;i<=9;i++){
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*15,i*15);
			b.setSize(50,20);
			c.add(b);
		}
		setSize(300,200);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new NullContainerEX();
		// TODO Auto-generated method stub

	}

}
