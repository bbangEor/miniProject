package test;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import components.Item;
import components.Player;

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

	public MainTest getmContext() {
		return mContext;
	}

	public void setmContext(MainTest mContext) {
		this.mContext = mContext;
	}

	public JLabel getBackgroundMap() {
		return backgroundMap;
	}

	public void setBackgroundMap(JLabel backgroundMap) {
		this.backgroundMap = backgroundMap;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Object> getObjectlist() {
		return objectlist;
	}

	public void setObjectlist(ArrayList<Object> objectlist) {
		this.objectlist = objectlist;
	}

	ArrayList<Object> objectlist = new ArrayList<>();

	public MainTest() {
		initData();
		setInitLayout();

	}

	public void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		setContentPane(backgroundMap);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 640);
		object = new Object();
		item = new Item(mContext);
		player = new Player(player);
		addEventListener();
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
						add(new Object());
						repaint();
					}
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while (true) {
//					add(new Object(mContext));
//					repaint();
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//			}
//		}).start();
	}

	protected void add(Object object2) {
		// TODO Auto-generated method stub

	}

	public void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					player.up();
					break;
				case KeyEvent.VK_DOWN:
					player.down();
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