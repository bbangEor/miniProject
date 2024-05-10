package miniProject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainTest extends JFrame {

	MainTest mContext = this;

	private JLabel backgroundMap;
	private Object object;
	private Item item;
	private Player player;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public MainTest() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/Background1.jpg"));
		setContentPane(backgroundMap);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(815, 500);
		object = new Object(mContext);
		item = new Item(mContext);
		player = new Player(player);
	}

	public void setInitLayout() {
		setLayout(null);
		 setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		add(player);
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					int a = (new Random()).nextInt(10);
					if (a < 7) {
						add(new Item(mContext));
						repaint();						
					} else {
						add(new Object(mContext));
						repaint();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}

	public void addEventListener() {
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
		});
	}

	public static void main(String[] args) {
		new MainTest();
	}

}
