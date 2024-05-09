package test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainTest extends JFrame {
	MainTest mContext = this;
	private JLabel backgroundMap;

	private components.Player player;

	public MainTest() {
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(587, 360);

		player = new components.Player(mContext);

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
				switch(e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					player.up();
					break;
				default:
					break;	
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
//					player.~~~;
					break;
				default:
					break;
				} 
			}

		});
	}

	public static void main(String[] args) {
		new MainTest();
	}

}
