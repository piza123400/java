import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame {
	public LabelEx() {
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel textLable = new JLabel("����մϴ�");

		ImageIcon beauty = new ImageIcon("image/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty);

		ImageIcon normaIIcon = new ImageIcon("images/normalIcon.gif");
		JLabel labe1 = new JLabel("��������� ��ȭ�ϼ���", normaIIcon, SwingConstants.CENTER);

		c.add(textLable);

		c.add(imageLabel);

		c.add(labe1);

		setSize(400,600);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LabelEx();
	}

}
