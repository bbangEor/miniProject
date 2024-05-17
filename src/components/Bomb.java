package components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import screen.ResultScreen;
import state.BombWay;
import test.MiniGameFrame;

public class Bomb extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	// 폭탄 이미지
	private ImageIcon bomb;
	// 폭탄 좌표
	private int bombX;
	private int bombY;
	// 폭탄 상태
	private int state = 0;
	// 폭탄 속도
	private final int SPEED = 3;
	// 폭탄 방향
	private boolean left;
	private BombWay bombWay;

	// 폭탄 리스트 생성
	public static List<Bomb> bombs = new ArrayList<>();

	public Bomb(MiniGameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
		bombs.add(this);
	}

	public void initData() {
		bomb = new ImageIcon("img/bomb.png");
		bombX = 1000;
		bombY = 310;

	}

	public void setInitLayout() {
		setIcon(bomb);
		setSize(50, 50);
		setLocation(bombX, bombY);
	}

	@Override
	public void left() {
		bombWay = BombWay.LEFT;
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					bombX -= SPEED;
					setLocation(bombX, bombY);
					// 폭탄이 닿았을 때 좌표 계산
					if (mContext != null && mContext.getPlayer() != null) {
						int absX = Math.abs(bombX - mContext.getPlayer().getX() - 55);
						int absY = Math.abs(bombY - mContext.getPlayer().getY());
						if (absX < 25 && absY < 50) {
							if (state == 0) {
								if (mContext.getPlayer().isShielded() == true) {
									System.out.println("test");
//									mContext.getPlayer().setShielded(false);
//									mContext.getPlayer().setIcon(mContext.getPlayer().getPlayer());
									shieldCrash();
								} else {
									crash();
									left = false;
								}
							}
						}
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				left = false;
			}
		}).start();

	}

	// 폭탄이 닿았을 때
	public void crash() {
		state = 1;
		for (int i = 0; i < bombs.size(); i++) {
			Bomb bomb = bombs.get(i);
			if (bomb.mContext != null) {
				System.out.println("폭탄닿음+" + i);
				bomb.setIcon(null);
				bomb.mContext.remove(bomb);
				mContext.setVisible(false);
				mContext.setFlag(false);

				bomb.left = false;
			}
		}
		bombs.clear(); // 리스트 비우기
		this.left = false;
		new ResultScreen(mContext);
	}

	public void shieldCrash() {
		state = 1;
		mContext.getPlayer().setCollide(true);
		for (int i = 0; i < 1; i++) {
			Bomb bomb = bombs.get(i);
			if (bomb.mContext != null) {
				mContext.remove(this);
				mContext.repaint();
			}
		}
		try {
			System.out.println("collide");
			Thread.sleep(3000);
			if (mContext.getPlayer().isCollide()) {
				mContext.getPlayer().setShielded(false);
				mContext.getPlayer().setIcon(mContext.getPlayer().getPlayer());
			}
			mContext.getPlayer().setCollide(false);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getBombX() {
		return bombX;
	}

	public void setBombX(int bombX) {
		this.bombX = bombX;
	}

	public int getBombY() {
		return bombY;
	}

	public void setBombY(int bombY) {
		this.bombY = bombY;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
