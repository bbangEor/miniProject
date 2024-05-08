package test;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import components.Player;
import components.Score;

public class MainTest extends JFrame {
	private Player player;
	private Score score;
	private JLabel backgroundMap;

	public MainTest() {
		initData();
		setInitLayout();

	}

	public void initData() {
		backgroundMap = new JLabel(new ImageIcon("img.jpg"));
		player = new Player();
	}

	public void setInitLayout() {
		setLayout(null);
		setVisible(true);

	}

	public void addEventListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

	public static void main(String[] args) {
		new MainTest();
	}

}
