package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import state.BombWay;
import test.MiniGameFrame;

public class Bomb extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private int x;
	private int y;

	private int state = 0;

	private ImageIcon bomb;
	private final int SPEED = 3;

	private boolean left;
	private BombWay bombWay;

	public Bomb(MiniGameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
	}

	public void initData() {
		bomb = new ImageIcon("img/bomb.png");

		x = 1000;
		y = 310;

	}

	public void setInitLayout() {
		setIcon(bomb);
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

					// TODO NullPointerException 오류
					// GameFrame에 Player = new 생성해야함
					 if (mContext != null && mContext.getPlayer() != null) {
						 
					int absX = Math.abs(x - mContext.getPlayer().getX() - 55);
					int absY = Math.abs(y - mContext.getPlayer().getY());
					if (absX < 25 && absY < 50) {
						if (state == 0) {
							crash();
							}
						}
					 }

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	public void crash() {
		mContext.getBomb().setState(1);
		setIcon(null);
		mContext.remove(mContext.getBomb());
		mContext.repaint();
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

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
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