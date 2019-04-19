
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyListenerEx extends JFrame{
	private JLabel [] keyMessage;
	
	public KeyListenerEx(){
		setTitle("keyListener ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addKeyListener(new MyKeyListener()); 
		
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel(" get KeyCode() ");
		keyMessage[1] = new JLabel(" get KeyCode() ");
		keyMessage[2] = new JLabel(" get KeyCode() ");
		
		for(int i=0;i<keyMessage.length;i++){
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.YELLOW);
		}
		setSize(300,150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			char keyCher = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyCher));
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
			System.out.println("KeyPress");
		}
		public void keyReleased(KeyEvent e){
			System.out.println("KeyReleased");
		}
		public void keyPeleased(KeyEvent e){
			System.out.println("KeyTyped");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyListenerEx();
	}

}
