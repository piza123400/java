import java.awt.Color;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JLabel;

class RandomThread extends Thread {
	private Container contantPane;
	private boolean flag = false;

	public RandomThread(Container contentPane) {
		this.contantPane = contentPane;
	}

	void finsh() {
		flag = true;
	}

	@Override
	public void run() {
		while(true) {
			int x = ((int) (Math.random() * contantPane.getWidth()));
			int y = ((int) (Math.random() * contantPane.getHeight()));
			JLabel label = new JLabel("java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			contantPane.add(label);
			contantPane.repaint();
			try {
				Thread.sleep(300);
				if (flag == true) {
					contantPane.removeAll();
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.RED);
					contantPane.add(label);
					contantPane.repaint();
					return;
				}
			  }
				catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}

		}

	}

}

public class ThreadFinishFlagEx extends JFrame {
	private RandomThread th;

	public ThreadFinishFlagEx() {
		setTitle("ThreadFinshFlagEx ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				th.finsh();
			}
		});
		setSize(300,200);
		setVisible(true);
		
		th = new RandomThread(c);
		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadFinishFlagEx();
	}

}
