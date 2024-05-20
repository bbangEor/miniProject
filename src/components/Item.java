package components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import screen.MiniGameFrame;
import state.BombWay;

public class Item extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	// 아이템 이미지
	private ImageIcon item;
	// 아이템 좌표
	private int itemX;
	private int itemY;
	// 아이템 상태
	private int state;
	private final int DEFAULT = 0;
	private final int CRASH = 1;
	// 아이템 속도
	private final int SPEED = 3;
	// 아이템 방향
	private boolean left;
	private BombWay bombWay;

	private Shield shield;

	public Item(MiniGameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
	}

	public void initData() {
		item = new ImageIcon("img/dotori.png");
		// 랜덤 확률로 아이템 생성
		int random = new Random().nextInt(10);
		if (random < 6) { // 60%
			itemX = 1000;
			itemY = 310;
		} else { // 40%
			itemX = 1000;
			itemY = 210;
		}

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
					// 아이템 이동 속도(점수에 비례해 빨라지게)
					// 스코어 호출 후 스피드에 더해 계산
					itemX -= (SPEED + (mContext.getScores() / 10));
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
						if (state == DEFAULT) {
							crash();
						}
					}
				}

			}
		}).start();

	}

	// 아이템이 닿았을 때
	public void crash() {
		// 아이템 삭제 처리
		state = CRASH;
		setIcon(null);
		mContext.remove(this);
		mContext.repaint();
		// 스코어 점수 올리기
		mContext.scoreSet();
	}

}