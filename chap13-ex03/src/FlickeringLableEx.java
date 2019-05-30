import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickeringLable extends JLabel implements Runnable {
	private long delay;

	public FlickeringLable(String text, long delay) {
		// TODO Auto-generated constructor stub
		super(text);
		this.delay = delay;
		setOpaque(true);
		Thread th = new Thread(this);
		th.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n = 0;
		while (true) {
			if (n == 0)
				setBackground(Color.YELLOW);
			else
				setBackground(Color.GREEN);
			if (n == 0)
				n = 1;
			else
				n = 0;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}

		}

	}

}

public class FlickeringLableEx extends JFrame {
	public FlickeringLableEx(){
		setTitle("FlickeringLableEx ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		FlickeringLable fLable = new FlickeringLable("±ô¹Ú", 500);
		 
		JLabel label = new JLabel("¾È ±ô¹Ú");
		
		FlickeringLable fLable2 = new FlickeringLable("¿©±âµµ±ô¹Ú", 500);

		c.add(fLable);
		c.add(label);
		c.add(fLable2);
		
		setSize(600,600);
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlickeringLableEx();
	}

}
