package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import state.BombWay;
import test.MiniGameFrame;

public class Item extends JLabel implements ItemMoveable {
	
	MiniGameFrame mContext;
	
	private int state = 0;
	private int score = 0;

	private int x;
	private int y;
	private ImageIcon item;
	private final int SPEED = 3;

	private boolean left;
	private BombWay bombWay;

	public Item(MiniGameFrame mContext2) {
		this.mContext = mContext2;
		initData();
		setInitLayout();
		left();
	}

	public void initData() {
		item = new ImageIcon("img/dotori.png");
		x = 1000;
		y = 310;

	}

	public void setInitLayout() {
		setIcon(item);
		setSize(50, 50);
		setLocation(x, y);
	}
	public void crash() {
		mContext.getItem().setState(1);
		setIcon(null);
		mContext.remove(mContext.getItem());
		mContext.repaint();
	}

	@Override
	public void left() {
		bombWay = BombWay.LEFT;
		left = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					int absX = Math.abs(x - mContext.getPlayer().getX() - 55);
					int absY = Math.abs(y - mContext.getPlayer().getY());
					if (absX < 25 && absY < 50) {
						if (state == 0) {
							crash();
						}
					}
				}

			}
		}).start();

	}

	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getItem() {
		return item;
	}

	public void setItem(ImageIcon item) {
		this.item = item;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public BombWay getBombWay() {
		return bombWay;
	}

	public void setBombWay(BombWay bombWay) {
		this.bombWay = bombWay;
	}

	public int getSPEED() {
		return SPEED;
	}
	


}