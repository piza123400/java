package overwatch;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


public class DicServerFrame extends JFrame {
	private JTextField eng = new JTextField(10);
	private JTextField kor = new JTextField(10);
	private JButton saveBtn = new JButton("저장");
	private JButton searchBtn = new JButton("찾기");
	private JButton selBtn = new JButton("이미지 선택");
	private JButton sendBtn = new JButton("파일 전송");
	private String filePath = null;
	private JTextField fileNameTf = new JTextField(20);
	
	private JTextArea ta = new JTextArea(7, 25);
	private HashMap<String, String> dic = new HashMap<String, String>();
	public DicServerFrame() {
		super("Dic Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
		setSize(350, 350);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("영어"));
		c.add(eng);
		c.add(new JLabel("한글"));
		c.add(kor);
		c.add(saveBtn);
		c.add(searchBtn);		
		c.add(selBtn);
		c.add(sendBtn);
		c.add(fileNameTf);
		
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append("삽입 (" + eng.getText() + "," +kor.getText() + ")\n");
				dic.put(eng.getText(), kor.getText());
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = dic.get(eng.getText());
				if(s == null) 
					s = "없음";
				kor.setText(s);
			}
		});
		
		selBtn.addActionListener(new FileChooseActionListener());
		sendBtn.addActionListener(new MyActionListener());
		

		c.add(new JScrollPane(ta));		
		setVisible(true);
		
		startService();
	}
	
	private void startService() {
		ServerThread server = new ServerThread();
		server.start();
	}
	
	private void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class ServerThread extends Thread {
		
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;

			try {
				listener = new ServerSocket(9999);
			} catch (IOException e1) {
				handleError(e1.getMessage());
			}
			while(true) {
				try {					
					socket = listener.accept(); 
					
					ServiceThread th = new ServiceThread(socket);
					th.start();
				}
				catch(IOException e) {
					handleError(e.getMessage());
					break;
				}
			}
			try {
				listener.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	class ServiceThread extends Thread {
		private Socket socket;
		
		public ServiceThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				BufferedWriter out = new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream()));
		
				while(true) {
					String engText = in.readLine(); 
					String korText = dic.get(engText);
					if(korText == null) 
						korText = "없음";

					out.write(korText+"\n");
					out.flush();

					ta.append("검색 (" + engText + ")\n");
					int pos = ta.getText().length();
					ta.setCaretPosition(pos); 
				}
			}
			catch(IOException e) {
				return;
			}
		}
	}
	
	class FileChooseActionListener implements ActionListener {
		private JFileChooser chooser;
		
		public FileChooseActionListener() {
			chooser= new JFileChooser();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "JPG & GIF & PNG Images", 
					        "jpg", "gif", "png"); 

			chooser.setFileFilter(filter);
				
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { 
				JOptionPane.showMessageDialog(DicServerFrame.this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
				
			
			filePath = chooser.getSelectedFile().getPath(); 
			fileNameTf.setText(filePath);
		}
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(filePath == null)
				return; 
			
			FileInputStream fin = null; 
			File f = null;
			BufferedOutputStream fout = null;
			Scanner scanner  = new Scanner(System.in);
			Socket socket = null;
			try {
				socket = new Socket("localhost", 9998); 
				f = new File(filePath);
				long length = f.length();
				fin = new FileInputStream(f); 
				fout = new BufferedOutputStream(socket.getOutputStream());
				
				byte[] fname = f.getName().getBytes();
				int nameSize = fname.length;
				fout.write(Command.FILE_NAME); 
				sentInt(fout, nameSize);  
				fout.write(fname);
				fout.write(Command.FILE_SIZE);
				sentInt(fout, (int)length);
				sentInt(fout, (int)(length >>> 32));
				
				fout.write(Command.SEND_BEGIN);
				int count = 0;
				byte b[] = new byte[512];
				while (length > 0) {
					int numRead = fin.read(b,0,b.length);
					if (numRead <= 0) { 
						if (length > 0) {
							System.out.println("전송 오류가 발생했습니다. 읽은 바이트: " + count + " 남은 바이트:" + length);					
							break;
						} 
					} else {
						fout.write(b, 0, numRead);
						length -= numRead;
						fout.flush();
						count += numRead;
					}
				}
				fout.write(Command.SEND_END); 
				fout.flush();
				fin.close();
				socket.close(); 
				System.out.println("파일 전송이 완료되었습니다.");
			} catch (IOException e2) {
				System.out.println("파일 전송 중 오류가 발생했습니다.");
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DicServerFrame();
	}

	public void sentInt(BufferedOutputStream fout, int nameSize) {
		// TODO Auto-generated method stub
		
	}

}


