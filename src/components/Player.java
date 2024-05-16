package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import service.PlayerBackgroundService;

public class Player extends JLabel {

	Player mContext;

	// 플레이어 이미지
	private ImageIcon player;
	// 플레이어 좌표
	private int playerX;
	private int playerY;
	private ImageIcon shieldMotion;
	// 움직임 상태
	private boolean up;
	private boolean down;
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
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					playerY = playerY - JUMPSPEED;
					setLocation(playerX, playerY);
					try {
						Thread.sleep(5);
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

	public void setPlayer(ImageIcon player) {
		this.player = player;
	}

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	public ImageIcon getShieldMotion() {
		return shieldMotion;
	}

}
