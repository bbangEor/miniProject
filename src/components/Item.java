package components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import state.BombWay;
import test.MiniGameFrame;

public class Item extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	// 아이템 이미지
	private ImageIcon item;
	// 아이템 좌표
	private int itemX;
	private int itemY;
	// 아이템 상태
	private int state = 0;

	private Shield shield;
	// 아이템 속도
	private final int SPEED = 3;
	// 아이템 방향
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
		itemX = 1000;
		itemY = 310;
	}

	public void setInitLayout() {
		setIcon(item);
		setSize(50, 50);
		setLocation(itemX, itemY);
	}

	@Override
	public void left() {
		bombWay = BombWay.LEFT;
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					itemX -= SPEED;
					setLocation(itemX, itemY);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 아이템이 닿았을 때 좌표 계산
					int absX = Math.abs(itemX - mContext.getPlayer().getX() - 55);
					int absY = Math.abs(itemY - mContext.getPlayer().getY());
					if (absX < 25 && absY < 50) {
						if (state == 0) {
							crash();
						}
					}
				}

			}
		}).start();

	}
	// 아이템이 닿았을 때
	public void crash() {
		state = 1;
		setIcon(null);
		mContext.remove(this);
		mContext.repaint();
		mContext.scoreSet();
	}

	public ImageIcon getItem() {
		return item;
	}

	public void setItem(ImageIcon item) {
		this.item = item;
	}

	public int getItemX() {
		return itemX;
	}

	public void setItemX(int itemX) {
		this.itemX = itemX;
	}

	public int getItemY() {
		return itemY;
	}

	public void setItemY(int itemY) {
		this.itemY = itemY;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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