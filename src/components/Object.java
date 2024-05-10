package components;

	import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.Moveable;
import state.ObjectWay;

	public class Object extends JLabel implements Moveable {
	private int x;
	private int y;
	private ImageIcon object;
	private final int SPEED = 3;

	private boolean left;
	private ObjectWay objectWay;

	public Object() {
	initData();
	setInitLayout();
	left();
	}

	public void initData() {
	object = new ImageIcon("src/enemyL.png");

	x = 900;
	y = 535;
	setIcon(object);
	setSize(50, 50);
	setLocation(x, y);

	}

	public void setInitLayout() {

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

	}
