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
		addEventListener();

	}

	public void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/Background1.jpg"));
		player = new Player(player);
		setContentPane(backgroundMap);
		setSize(815, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setInitLayout() {

		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		add(player);

	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					player.up();
					break;
				default:
					break;
				}
			}

//			@Override
//			public void keyReleased(KeyEvent e) {
//
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_SPACE:
////					player.down();
//					break;
//				default:
//					break;
//				}
//			}

		});
	}

	public static void main(String[] args) {
		new MainTest();
	}

}
