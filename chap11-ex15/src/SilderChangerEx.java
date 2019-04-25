import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SilderChangerEx extends JFrame{
	
	private JLabel colorLabel;
	private JSlider [] sl = new JSlider[3];
	
	public void SliderChangeEx() {
		setTitle("�����̴��� changeEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		colorLabel = new JLabel("     SLIDER EXAMPLE     ");
		
		for(int i=0;i<sl.length;i++){
			sl[i] =  new JSlider(JSlider.HORIZONTAL,0,255,128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			
			sl[i].addChangeListener(new MyChangeListener());
			c.add(sl[i]);
		}
		sl[0].setForeground(Color.RED);
		sl[0].setForeground(Color.GREEN);
		sl[0].setForeground(Color.BLUE);
		
		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(r,g,b));
		
		c.add(colorLabel);
		setSize(300,200);
		setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e){
			
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabel.setBackground(new Color(r,g,b));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SilderChangerEx();
	}

}