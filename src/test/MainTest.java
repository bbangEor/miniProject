package test;

<<<<<<< HEAD
import java.awt.FlowLayout;

import javax.swing.JFrame;
=======
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
>>>>>>> 32eeadc0280427e3e35916d0045cc33c3cca8780

import components.Object;

public class MainTest extends JFrame {

	private components.Object object;
 
	public MainTest() {
		initData();
		setInitLayout();
	}

	public void initData() {
<<<<<<< HEAD
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
	
	

=======
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
>>>>>>> 32eeadc0280427e3e35916d0045cc33c3cca8780

	public static void main(String[] args) {
		new MainTest();
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 32eeadc0280427e3e35916d0045cc33c3cca8780
