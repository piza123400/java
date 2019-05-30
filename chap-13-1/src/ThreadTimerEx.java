import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread {
	private JLabel timerLable;

	public TimerThread(JLabel timerLabel) {
		this.timerLable = timerLabel;
	}

	public void run() {
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

public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLable = new JLabel();
		timerLable.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLable);

		TimerThread th = new TimerThread(timerLable);

		setSize(300, 300);
		setVisible(true);

		th.start();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTimerEx();
	}

}
