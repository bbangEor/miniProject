package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import service.PlayerBackgroundService;

public class Player extends JLabel {

	Player mContext;

	// 플레이어 이미지
	private ImageIcon player;
	private ImageIcon shieldMotion;
	// 플레이어 좌표
	private int playerX;
	private int playerY;
	// 움직임 상태
	private boolean up;
	private boolean down;
	// 방어
	private boolean isShielded;
	// 플레이어 속도 상태
	private final int JUMPSPEED = 2;

	public Player(Player mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		new Thread(new PlayerBackgroundService(this)).start();

	}

	private void initData() {
		player = new ImageIcon("img/Player.png");
		shieldMotion = new ImageIcon("img/shieldMotion.png");
		playerX = 100;
		playerY = 260;
		up = false;
		down = false;
	}

	private void setInitLayout() {

		setIcon(player);
		setSize(130, 100);
		setLocation(playerX, playerY);
	}

	public void up() {
		System.out.println("점프");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 120 / JUMPSPEED; i++) {
					playerY = playerY - JUMPSPEED;
					setLocation(playerX, playerY);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				up = false;
				down();
			}

		}).start();

	}

	public void down() {
		System.out.println("다운");
		down = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (down) {
					playerY = playerY + JUMPSPEED;
					setLocation(playerX, playerY);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();
	}

	public ImageIcon getPlayer() {
		return player;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public ImageIcon getShieldMotion() {
		return shieldMotion;
	}

	public boolean isShielded() {
		return isShielded;
	}

	public void setShielded(boolean isShielded) {
		this.isShielded = isShielded;
	}

}