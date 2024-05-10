package miniProject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

	Player mContext;

	private int x;
	private int y;
	private ImageIcon player;
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

	public ImageIcon getPlayer() {
		return player;
	}

	public void setPlayer(ImageIcon player) {
		this.player = player;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	private void initData() {
		player = new ImageIcon("img/Player.png");

		x = 100;
		y = 0;

		up = false;
		down = false;

		setIcon(player);
		setSize(100, 100);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	public void up() {
		System.out.println("점프");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// 객체의 상태값을 잘 조절해야 한다.
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
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
				System.out.println("멈춤준비");
			}
		}).start();
	}
}
