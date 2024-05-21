package screen;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import components.Bomb;
import components.Item;
import components.Player;
import components.Shield;

public class MiniGameFrame extends JFrame {

	MiniGameFrame mContext = this;

	// 배경 화면
	private JLabel backgroundMap;
	private final int BACK_WIDTH = 815;
	private final int BACK_HEIGHT = 500;
	// 폭탄
	private Bomb bomb;
	// 아이템
	private Item item;
	// 플레이어
	private Player player;
	// 스코어
	private JLabel score;
	private int scores;
	// 하트
	private JLabel heart;
	private ImageIcon heartIcon;

	boolean flag = true;

	public MiniGameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		// 배경 화면 생성
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		setContentPane(backgroundMap);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(BACK_WIDTH, BACK_HEIGHT);
		// 플레이어 생성
		player = new Player(player);
	}

	public void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		// 사이즈 변경 불가
		setResizable(false);
		// 모니터 가운데 자동 배치
		setLocationRelativeTo(null);
		// 화면에 보이게 설정
		setVisible(true);

		add(player);

		heartIcon = new ImageIcon("img/heart.png");
		heart = new JLabel(heartIcon);
		heart.setBounds(20, 0, 150, 100);
		add(heart);

		score = new JLabel(Integer.toString(scores));
		score.setFont(new Font("둥근모꼴", Font.PLAIN, 35));
		score.setBounds(720, 0, 150, 100);
		add(score);

		// 아이템 랜덤 생성
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (flag) {
					// a = 랜덤생성
					int a = (new Random()).nextInt(10);
					if (a < 7) {
						// b = 도토리
						int b = (new Random()).nextInt(10);
						if (b < 6) {
							add(new Item(mContext));
							repaint();
						} else if (a < 7) {
							// c = 폭탄
							int c = (new Random()).nextInt(10);
							if (c < 4) {
								add(new Bomb(mContext));
								repaint();
								// d = 쉴드
							} else if (a < 7) {
								int d = (new Random()).nextInt(10);
								if (d < 1) {
									add(new Shield(mContext));
									repaint();
								}
							}

						}
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}).start();

	}

	// 스코어
	public void scoreSet() {
		scores++;
		score.setText(Integer.toString(scores));
	}

	// 이벤트 리스너
	public void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					player.up();
					break;
				default:
					break;
				}
			}
		});
	}

	public Bomb getBomb() {
		return bomb;
	}

	public Player getPlayer() {
		return player;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getScores() {
		return scores;
	}

}