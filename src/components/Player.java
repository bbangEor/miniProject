package components;

import javax.swing.ImageIcon;
<<<<<<< HEAD


public class Player {

=======
import javax.swing.JLabel;

public class Player extends JLabel {

	Player mContext;

>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
	private int x;
	private int y;
	private ImageIcon player;
	// 움직임 상태
	private boolean up;
<<<<<<< HEAD
=======
	private boolean down;
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6

	// 플레이어 속도 상태
	private final int JUMPSPEED = 2;

<<<<<<< HEAD
	public Player() {

=======
	public Player(Player mContext) {
		this.mContext = mContext;
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
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

<<<<<<< HEAD
=======
	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
	private void initData() {
		player = new ImageIcon("img/Player.png");

		x = 450;
		y = 535;

		up = false;
<<<<<<< HEAD
=======
		down = false;
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6

	}

	private void setInitLayout() {
<<<<<<< HEAD

=======
		setIcon(player);
		setSize(50, 50);
		setLocation(x, y);
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
	}

	public void up() {
		System.out.println("점프");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
<<<<<<< HEAD
=======
					setLocation(x, y);
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
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
<<<<<<< HEAD
=======

	public void down() {
		System.out.println("다운");
		down = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (down) {
					setLocation(x, y);
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
>>>>>>> bb9a01dc0bd80fcd612cd899c3f00ca8f99671f6
}
