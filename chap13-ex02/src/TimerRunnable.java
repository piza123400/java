import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunnable implements Runnable {
	private JLabel timerLable;
	
	public TimerRunnable(JLabel timerLable) {
		// TODO Auto-generated constructor stub
		this.timerLable = timerLable;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n = 0;
		while (true) {
			timerLable.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				return;
			}

		}

	}
}