import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListChangeEx extends JFrame{
	
	private JTextField tf = new JTextField(10);
	private Vector<String> v=new Vector<String>();
	private JList<String>nameList = new JList<String>(v);
	
	public ListChangeEx(){
		setTitle("����Ʈ ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�̸� �Է��� enter Ű �Է�"));
		c.add(tf);
		
		v.add("Ȳ����");
		v.add("�����");
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellHeight(100);
		c.add(new JScrollPane(nameList));
		
		setSize(300,300);
		setVisible(true);
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText());
				t.setText("");
				nameList.setListData(v);
			}
		});
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListChangeEx();
	}

}
