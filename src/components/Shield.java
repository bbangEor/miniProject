package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import test.MiniGameFrame;

public class Shield extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	// 쉴드 상태
	private int state = 0;
	// 쉴드 좌표
	private int x;
	private int y;
	// 쉴드 이미지
	private ImageIcon shield;
	// 플레이어 쉴드 이미지
	private Player player;
	private ImageIcon shieldMotion;
	private ImageIcon shieldMotion2;
	// 쉴드 속도
	private final int SPEED = 3;
	// 쉴드 방향
	private boolean left;
	Bomb bomb;

	public Shield(MiniGameFrame mContext2) {
		this.mContext = mContext2;
		this.player = mContext2.getPlayer();
		this.bomb = mContext2.getBomb();
		initData();
		setInitLayout();
		left();
	}

	public void initData() {
		shield = new ImageIcon("img/shield.png");
		shieldMotion = new ImageIcon("img/shieldMotion.png");
		shieldMotion2 = new ImageIcon("img/Player.png");
		x = 1000;
		y = 310;
	}

	public void setInitLayout() {
		setIcon(shield);
		setSize(100, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
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
					// 충돌 계산
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

	// 쉴드 충돌시
	public void crash() {
		// 이미지 삭제 처리
		state = 1;
		setIcon(null);
		mContext.remove(this);
		mContext.repaint();

		// 플레이어 쉴드 상태 true, 이미지 바꾸기
		if (state == 1) {
			player.setIcon(player.getShieldMotion());
			player.setShielded(true);
			System.out.println("쉴드 모션");

			// 3초 대기
			for (int i = 0; i < 30; i++) {
				try {
					Thread.sleep(100);
					System.out.println(i);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
				if (mContext.getPlayer().isShielded() == false) {
					break;
				}
			} // 쉴드 상태 해제, 이미지 바꾸기
			System.out.println("쉴드 모션 해제");
			player.setIcon(player.getPlayer());
			player.setShielded(false);
		}

	}

}
