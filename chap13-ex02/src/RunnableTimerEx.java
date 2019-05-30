import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class RunnableTimerEx extends JFrame {
	public RunnableTimerEx() {
		setTitle("Runnalbe 을 구현한 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel timerLable = new JLabel();
		timerLable.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLable);
		
		TimerRunnable runnable = new TimerRunnable(timerLable);
		Thread th = new Thread(runnable);

		setSize(500, 500);
		setVisible(true);

		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RunnableTimerEx();
	}

}
