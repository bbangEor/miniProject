package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import test.MainTest;

public class Player extends JLabel {

	MainTest mContext;

	private int x;
	private int y;
	private ImageIcon player;
	// 움직임 상태
	private boolean up;

	// 플레이어 속도 상태
	private final int JUMPSPEED = 2;

	public Player(MainTest mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();

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

	private void initData() {
		player = new ImageIcon("img/Player.png");

		x = 280;
		y = 140;

		up = false;

		setIcon(player);
		setSize(120, 117);
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
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// 객체의 상태값을 잘 조절해야 한다.
				up = false;

			}

		}).start();

	}
}
