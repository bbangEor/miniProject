package miniProject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Item extends JLabel implements ItemMoveable {
	
	MainTest mContext;
	
	private int state = 0;

	private int x;
	private int y;
	private ImageIcon item;
	private final int SPEED = 3;

	private boolean left;
	private ObjectWay objectWay;

	public Item(MainTest mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
	}

	public void initData() {
		item = new ImageIcon("img/도토리.png");
		x = 1000;
		y = 310;

	}

	public void setInitLayout() {
		setIcon(item);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	public void crash() {
		mContext.getItem().setState(1);
		setIcon(null);
		mContext.remove(mContext.getItem());
		mContext.repaint();
	}

	@Override
	public void left() {
		objectWay = ObjectWay.LEFT;
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
				}

			}
		}).start();

	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public ImageIcon getItem() {
		return item;
	}

	public void setItem(ImageIcon item) {
		this.item = item;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public ObjectWay getObjectWay() {
		return objectWay;
	}

	public void setObjectWay(ObjectWay objectWay) {
		this.objectWay = objectWay;
	}

	public int getSPEED() {
		return SPEED;
	}

}
