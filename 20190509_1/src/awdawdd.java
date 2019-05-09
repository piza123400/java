import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class awdawdd extends JFrame{
	public awdawdd(){
		super("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new SouthPanel(),BorderLayout.SOUTH);
		c.add(new CenterPanel(),BorderLayout.CENTER);
		c.add(new NorthPanel(),BorderLayout.NORTH);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new awdawdd();
	}

}
class SouthPanel extends JPanel{
	public SouthPanel(){
		setBackground(Color.WHITE);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new JLabel("계산결과"));
		add(new JTextField(15));

	}
}
class CenterPanel extends JPanel{
	JButton b [] = {new JButton(" + "),new JButton(" - "),new JButton(" * "),new JButton(" / ")};
	public CenterPanel(){
		setBackground(Color.white);
		setLayout(new GridLayout(4, 4,5,5));
		for(int i=0;i<10;i++){
			JButton b = new JButton(Integer.toString(i));
			add(b);
		//	JButton b.addItemListener(new MyItemListener()); 
			
		}
		add(new JButton("CE"));
		add(new JButton("계산"));
		
		for(int i=0;i<b.length;i++){
			b[i].setBackground(Color.white);
			add(b[i]);
		}
	}
	
}
	
class NorthPanel extends JPanel{
	public NorthPanel(){
		setBackground(Color.CYAN);
		setOpaque(true);
		setLayout(new FlowLayout());
		add(new JLabel("수식입력"));
		add(new JTextField(16));
		
	}
}