package overwatch;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class DicClientFrame extends JFrame {
	private Socket socket = null;
	private JTextField eng1 = new JTextField(10);
	private JTextField kor1 = new JTextField(10);
	private JButton searchBtn = new JButton("ã��");
	private JTextArea log = new JTextArea(5,25);
	private JLabel imageLable = new JLabel();

	BufferedReader in = null;
	BufferedWriter out = null;

	public DicClientFrame() {
		super("Ŭ���̾�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("����"));
		c.add(eng1);
		c.add(new JLabel("�ѱ�"));
		c.add(kor1);
		c.add(searchBtn);
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		c.add(imageLable, BorderLayout.NORTH);

		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		searchBtn.addActionListener(new MyActionListener1());

		setSize(400, 500);
		setVisible(true);
		startService();

	}

	private void startService() {
		ServerThread server = new ServerThread();
		server.start();
	}
	
	
	private void drawImage(String file) {
		ImageIcon icon = new ImageIcon(file);
		imageLable.setIcon(icon);
		this.pack();
	}
	
	private class ServerThread extends Thread {
		
		@Override
		public void run() {
			BufferedInputStream fin = null;
			BufferedOutputStream fout = null;
			ServerSocket listener = null;
			Socket socket = null;
			String saveFileName = null;
			try {
				listener = new ServerSocket(9998);
			} catch (IOException e1) {
				e1.printStackTrace();
			} // ���� ���� ����
			 
		while(true) {
				try {	
					socket = listener.accept(); // waiting client connection
					log.setText("�����\n");
					fin = new BufferedInputStream(socket.getInputStream()); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��
					int cmd;
					String fileName = null;
					long length=0;
					
					cmd = fin.read();
					if (cmd == Command.FILE_NAME) { // FILE_NAME ��� ����
						int nameSize = receiveInt(fin); // ���� �̸� ũ��
						log.append("���۹��� ���� �̸� ���� :" + nameSize + "\n");
						byte fname[] = new byte[nameSize];
						fin.read(fname); 
						fileName = new String(fname);
						log.append("���۹��� ���� �̸�:" + fileName + "\n");
						saveFileName = "copy_" + fileName;
						log.append("������ ���� �̸�:" + saveFileName + "\n");
						fout = new BufferedOutputStream(new FileOutputStream(saveFileName));
					} else {
						log.append("��� ���� ����" + cmd + "\n");
						socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�
						listener.close(); // ���� ���� �ݱ�
						return;
					}
					cmd = fin.read();
					if (cmd == Command.FILE_SIZE) { // FILE_SIZE ��� ����
						int lenghLow = receiveInt(fin); // ���� ũ���� ���� 4����Ʈ
						int lenghHigh = receiveInt(fin); // ���� ũ���� ���� 4����Ʈ
						length = lenghHigh;
				     	length <<= 32; // ���� ����Ʈ�� ����� ���� 32��Ʈ ����Ʈ
						length += lenghLow; // ���� 4 ����Ʈ ���ϱ�
						log.append("���۹��� ���� ũ��:" + length + "\n");
					} else {
						log.append("��� ���� ����" + cmd + "\n");
						if (fout != null)
							fout.close();
						socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�
						listener.close(); // ���� ���� �ݱ�
						return;
					}
					cmd = fin.read();
					if (cmd == Command.SEND_BEGIN) {
						int numberToRead;
						while (length >0) {
							byte b[] = new byte[2048];
							if (length < b.length) 
								numberToRead = (int)length;
							else
								numberToRead = b.length;
							int numRead = fin.read(b, 0, numberToRead);
							if (numRead <= 0) { 
								if (length > 0) { // �� �̻� ���� ���� ���µ� ���� ���� ũ�⸸ŭ �� ���� ���
									log.append("���� ������ �߻��߽��ϴ�. ���� ����Ʈ: " + numRead + " ���� ����Ʈ:" + length + "\n");
									break;
								}
							} else {
								log.append("."); // ���� ���� ǥ�� 
								fout.write(b, 0, numRead);
								length -= numRead;
							}
						}
						cmd = fin.read();
						if (cmd == Command.SEND_END) { // SEND_END ���
							log.append("\n���� ���� ����. ���� ������ ����Ǿ����ϴ�.\n");
						} else {
							log.append("\n��� ���� ����" + cmd + "\n");
						}
						if (fout != null)
							fout.close();
						socket.close(); // Ŭ���̾�Ʈ�� ��ſ� ���� �ݱ�					
						drawImage(saveFileName);
					}
				} catch (IOException e) {
					e.printStackTrace();
					log.append("���� ���� �� ������ �߻��߽��ϴ�.\n");
				}
			} // end of while
		}

	}

	private int receiveInt(BufferedInputStream fin) throws IOException {
		int value;
		value = fin.read();
		value |= fin.read() << 8;
		value |= fin.read() << 16;
		value |= fin.read() << 24;
		return value;
	}

	private void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}

	private void setupConnection() throws IOException {
		socket = new Socket("localhost", 9999);
		System.out.println("�����");
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	class MyActionListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				out.write(eng1.getText() + "\n");
				out.flush();
				String text = in.readLine();
				kor1.setText(text);
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