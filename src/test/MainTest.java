package test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import components.Player;
import components.Score;

public class MainTest extends JFrame {

	MainTest mContext = this;

	private Player player;
	private Score score;
	private JLabel backgroundMap;

	public MainTest() {
		initData();
		setInitLayout();

	}

	public void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		
		setContentPane(backgroundMap);
		setResizable(false);
		setSize(587, 360);
		setLocationRelativeTo(null);
		player = new Player(player);
	}

	public void setInitLayout() {
		setLayout(null);
		setVisible(true);

		add(player);

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
