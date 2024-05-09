package components;

<<<<<<< HEAD
import java.util.Random;

import javax.swing.ImageIcon;
=======
	import javax.swing.ImageIcon;
>>>>>>> 32eeadc0280427e3e35916d0045cc33c3cca8780
import javax.swing.JLabel;

import interfaces.Moveable;
import state.ObjectWay;
<<<<<<< HEAD
import test.MainTest;

public class Object extends JLabel implements Moveable {

	private int x; // 장애물 x 좌표
	private int y; // 장애물 y 좌표
	private ImageIcon object; // 장애물 이미지 아이콘 변수
	private final int SPEED = 3; // 정수값, int 속도 3 지정
	Random rd = new Random(50);
	int rdInt;
	MainTest maintest; // 포함관계

	private boolean right; //
	private ObjectWay objectWay;
	
	boolean flag = true;

	public Object() {
	//	this.maintest = maintest;
		initData();
		setInitLayout();
		objectCreate();
//		right();
	} // Object 생성자

	public void initData() {
		object = new ImageIcon("src/img/장애물.png");
		flag = true;
		x = 900;
		y = 500;
		setIcon(object);
		setSize(50, 50);
		setLocation(x, y);
	} // end of initData()

	public void setInitLayout() {}

	@Override
	public  void right() {
		objectWay = ObjectWay.LEFT;
		right = true;

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					x -= SPEED;
					System.out.println("오ㅣㄴ쭉 가는주 ㅇ");
//					flag = false;
					setLocation(x, y);
					rdInt = rd.nextInt(1000);
					if (rdInt == 0) {
					try {
						Thread.sleep(1000);
						System.out.println("움직임");
					} catch (InterruptedException e) {
						e.printStackTrace();
						}
					}
					try {
						Thread.sleep(70);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} // end of while()
			} // end of run()

//			objectCreate();
		}).start();
	} // end of right()

//	 장애물 이미지 무한 생성
	public synchronized void objectCreate() {
		System.out.println("sfdaasdf");
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (flag) {
					rdInt =  rd.nextInt(50);
					System.out.println(rdInt);
					if (rdInt >0) {
						try {
							Thread.sleep(1000);
							System.out.println(rdInt);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						add(new Object());
						repaint();
					}
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					right();
				} // ene of while()
			}
		}).start();

	}

} // end of class()
=======

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
>>>>>>> 32eeadc0280427e3e35916d0045cc33c3cca8780
