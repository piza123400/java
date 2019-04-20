package hhh;

import javax.swing.*;
import javax.xml.soap.Text;

import java.awt.*;

public class awd extends JFrame {

	public awd() {

		setTitle("메모장");

		createMenu();

		Area();

		Text();

		this.setSize(700, 1000);

		setVisible(true);

		setBackground(Color.WHITE);

	}

	private void createMenu() {

		Container mb = new JMenuBar();

		mb.setBackground(Color.white);

		mb.add(new JMenu("파일(F)"));

		mb.add(new JMenu("편집(E)"));

		mb.add(new JMenu("서식(O)"));

		mb.add(new JMenu("보기(H)"));

		mb.add(new JMenu("도움말(H)"));

		this.setJMenuBar((JMenuBar) mb);

	}

	private void Area() {
		TextArea mb = new TextArea();
		mb.setBackground(Color.white);
	}

	private void Text() {
		Container overflow = getContentPane();
		overflow.add(new JTextArea());
	}

	public static void main(String[] args) {

		new awd();

	}

}