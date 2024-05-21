package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import screen.MiniGameFrame;
import screen.ResultScreen;
import state.BombWay;

public class Bomb extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	// 폭탄 이미지
	private ImageIcon bomb;
	// 폭탄 좌표
	private int bombX;
	private int bombY;
	// 폭탄 상태
	private int state;
	private final int DEFAULT = 0;
	private final int CRASH = 1;
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
		// 랜덤 확률로 폭탄 생성
		int random = new Random().nextInt(10);
		if (random < 5) { // 50%
			bombX = 1000;
			bombY = 310;
		} else { // 50%
			bombX = 1000;
			bombY = 210;
		}

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
					// 폭탄 이동 속도(점수에 비례해 빨라지게)
					// 스코어 호출 후 스피드에 더해 계산
					bombX -= (SPEED + (mContext.getScores() / 10));
					setLocation(bombX, bombY);
					// 폭탄이 닿았을 때 좌표 계산
					if (mContext != null && mContext.getPlayer() != null) {
						int absX = Math.abs(bombX - mContext.getPlayer().getX() - 55);
						int absY = Math.abs(bombY - mContext.getPlayer().getY());
						if (absX < 25 && absY < 45) {
							if (state == DEFAULT) {
								// 플레이어가 쉴드가 있을 때
								if (mContext.getPlayer().isShielded() == true) {
									System.out.println("shield");
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
		state = CRASH;
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

	// 실드
	public void shieldCrash() {
		state = CRASH;
		for (int i = 0; i < 1; i++) {
			Bomb bomb = bombs.get(i);
			if (bomb.mContext != null) {
				mContext.remove(this);
				mContext.repaint();
			}
		}
	}

}

