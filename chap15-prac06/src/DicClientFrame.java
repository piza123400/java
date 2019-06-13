import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import javax.swing.JTextField;

public class DicClientFrame extends JFrame {
	private Socket socket = null;	
	private JTextField eng = new JTextField(10);
	private JTextField kor = new JTextField(10);
	private JButton searchBtn = new JButton("ã��");
	
	BufferedReader in = null;
	BufferedWriter out = null;
	
	public DicClientFrame() {
		super("Ŭ���̾�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("����"));
		c.add(eng);
		c.add(new JLabel("�ѱ�"));
		c.add(kor);
		c.add(searchBtn);	

		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		searchBtn.addActionListener(new MyActionListener());

		setSize(400, 120);
		setVisible(true);

	}

	private void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}

	private void setupConnection() throws IOException {
		socket = new Socket("localhost", 9998);
		System.out.println("�����");
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				out.write(eng.getText() + "\n");
				out.flush();
				String text = in.readLine();
				kor.setText(text);
			} catch (IOException e2) {
				handleError(e2.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DicClientFrame();
	}

}
