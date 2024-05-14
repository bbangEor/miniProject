package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import state.BombWay;
import test.MiniGameFrame;

public class Shield extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	private int state = 0;

	private int x;
	private int y;
	private ImageIcon shield;
	private ImageIcon shieldMotion;
	private final int SPEED = 3;

	private boolean left;
	private BombWay bombWay;

	private Player player;

	public Shield(MiniGameFrame mContext2) {
		this.mContext = mContext2;
		initData();
		setInitLayout();
		left();
	}

	public void initData() {
		shield = new ImageIcon("img/shield.png");
		shieldMotion = new ImageIcon("img/shieldMotion.png");
		x = 1000;
		y = 310;

	}

	public void setInitLayout() {
		setIcon(shield);
		setSize(50, 50);
		setLocation(x, y);
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

	public void crash() {
		mContext.getItem().setState(1);
		setIcon(null);
		mContext.remove(mContext.getItem());
		mContext.setPlayer(player, shieldMotion);
		mContext.repaint();
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

	public ImageIcon getShield() {
		return shield;
	}

	public void setShield(ImageIcon shield) {
		this.shield = shield;
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