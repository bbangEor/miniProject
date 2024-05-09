package test;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import components.Object;

public class MainTest extends JFrame {

	private components.Object object;
 
	public MainTest() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 640);
		object = new Object();
	}

	public void setInitLayout() {
		setLayout(new FlowLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(object);
	}
	
	


	public static void main(String[] args) {
		new MainTest();
	}

}