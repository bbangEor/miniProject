package components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.ItemMoveable;
import screen.MainScreen;
import screen.ResultScreen;
import state.BombWay;
import test.MiniGameFrame;

public class Bomb extends JLabel implements ItemMoveable {

	MiniGameFrame mContext;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	private int x;
	private int y;
	private int i=0;
	private int state = 0;

	private ImageIcon bomb;
	private final int SPEED = 3;

	private boolean left;
	private BombWay bombWay;
	
	// 추가 코드
	public static List<Bomb> bombs =new ArrayList<>();

	public Bomb(MiniGameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
		bombs.add(this);
	}

	public void initData() {
		bomb = new ImageIcon("img/bomb.png");

		x = 1000;
		y = 310;

	}

	public void setInitLayout() {
		setIcon(bomb);
		setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
		bombWay = BombWay.LEFT;
		left = true;
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					x -= SPEED;
					setLocation(x, y);

					// TODO NullPointerException 오류
					// GameFrame에 Player = new 생성해야함
					 if (mContext != null && mContext.getPlayer() != null) {
						 
					int absX = Math.abs(x - mContext.getPlayer().getX() -5);
					int absY = Math.abs(y - mContext.getPlayer().getY());
					if (absX < 25 && absY < 50) {
						if (state == 0) {
							crash();
							left=false;
							i++;
							System.out.println("가동중"+i);
							}
						}
					 }

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				left=false;
			}
		}).start();

	}

	//추가중인 코드
	public void crash() {
		for (int i=0;i<bombs.size();i++) {
			Bomb bomb = bombs.get(i);
			if(bomb.mContext!=null) {
				System.out.println("폭탄닿음+"+i);
		        bomb.setIcon(null);
		        bomb.mContext.remove(bomb);
		        mContext.setVisible(false);
		        mContext.setFlag(false);
		        
		        bomb.left = false;
			}
		}
	    bombs.clear(); // 리스트 비우기
	    this.left=false;
	    new ResultScreen();
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

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public BombWay getBombWay() {
		return bombWay;
	}

	public void setBombWay(BombWay bombWay) {
		this.bombWay = bombWay;
	}

	public int getSPEED() {
		return SPEED;
	}

}