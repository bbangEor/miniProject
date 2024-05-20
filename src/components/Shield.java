package components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import screen.MiniGameFrame;

public class Shield extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;
	// 쉴드 이미지
	private ImageIcon shield;
	// 플레이어 쉴드 이미지
	private Player player;
	private ImageIcon shieldMotion;
	private ImageIcon shieldMotion2;
	// 쉴드 좌표
	private int shieldX;
	private int shieldY;
	// 쉴드 상태
	private int state = 0;
	private final int DEFAULT = 0;
	private final int CRASH = 1;
	// 쉴드 속도
	private final int SPEED = 3;
	// 쉴드 방향
	private boolean left;

	private Bomb bomb;

	public Shield(MiniGameFrame mContext) {
		this.mContext = mContext;
		this.player = mContext.getPlayer();
		this.bomb = mContext.getBomb();
		initData();
		setInitLayout();
		left();
	}

	public void initData() {
		shield = new ImageIcon("img/shield.png");
		shieldMotion = new ImageIcon("img/shieldMotion.png");
		shieldMotion2 = new ImageIcon("img/Player.png");
		// 랜덤 확률로 쉴드 생성
		int random = new Random().nextInt(10);
		if (random < 5) { // 50%
			shieldX = 1000;
			shieldY = 310;
		} else { // 50%
			shieldX = 1000;
			shieldY = 210;
		}
	}

	public void setInitLayout() {
		setIcon(shield);
		setSize(100, 50);
		setLocation(shieldX, shieldY);
	}

	@Override
	public void left() {
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					// 쉴드 이동 속도(점수에 비례해 빨라지게)
					// 스코어 호출 후 스피드에 더해 계산
					shieldX -= (SPEED + (mContext.getScores() / 10));
					setLocation(shieldX, shieldY);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// 플레이어와 충돌 좌표 계산
					int absX = Math.abs(shieldX - mContext.getPlayer().getX() - 55);
					int absY = Math.abs(shieldY - mContext.getPlayer().getY());
					if (absX < 25 && absY < 50) {
						if (state == DEFAULT) {
							crash();
						}
					}
				}
			}
		}).start();
	}

	public void crash() {
		state = CRASH;
		// 이미지 삭제 처리
		setIcon(null);
		mContext.remove(this);
		mContext.repaint();

		if (state == CRASH) {
			// 이미지 바꾸기
			player.setIcon(player.getShieldMotion());
			player.setShielded(true);
			System.out.println("쉴드 모션");
			// 3초 동안 유지
			for (int i = 0; i < 30; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
				if (mContext.getPlayer().isShielded() == false) {
					break;
				}
			}
			// 쉴드 상태 해제
			System.out.println("쉴드 모션 해제");
			player.setIcon(player.getPlayer());
			player.setShielded(false);
		}

	}

}