package test;

<<<<<<< HEAD
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
=======
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import components.Player;
import components.Score;

<<<<<<< HEAD
public class MainTest extends JFrame {
=======
public class MainTest extends JFrame  {
	
	MainTest mContext = this;
	
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
	private Player player;
	private Score score;
	private JLabel backgroundMap;

	public MainTest() {
		initData();
		setInitLayout();

	}

	public void initData() {
<<<<<<< HEAD
		backgroundMap = new JLabel(new ImageIcon("img.jpg"));
		player = new Player();
=======
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		player = new Player(player);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1000,1000);
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
	}

	public void setInitLayout() {
		setLayout(null);
		setVisible(true);
<<<<<<< HEAD
=======
		
		add(player);
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6

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
