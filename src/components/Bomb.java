package components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import state.ObjectWay;
import test.MainTest;

public class Bomb extends JLabel implements ItemMoveable {	
	
	MainTest mContext;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private int x;
	private int y;
	
	private int state = 0;

	private ImageIcon object;
	private final int SPEED = 3;
	
	private boolean left;
	private ObjectWay objectWay;
	
	public Bomb(MainTest mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
	}
	
	public void initData() {
		object = new ImageIcon("img/장애물.png");
		
		x = 1000;
		y = 535;
		
	}
	
	public void setInitLayout() {
		setIcon(object);
		setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
		objectWay = ObjectWay.LEFT;
		left = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(left) {
					x -= SPEED;
					setLocation(x,y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
	}
	
	public void crash() {
		//mContext.getObject().setState(1);
		setIcon(null);
		//mContext.remove(mContext.getObject());
		mContext.repaint();
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

	public ImageIcon getObject() {
		return object;
	}

	public void setObject(ImageIcon object) {
		this.object = object;
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