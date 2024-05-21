package screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultScreen extends JFrame {

	// 배경 이미지
	private JLabel backgroundMap;
	private final int BACK_WIDTH = 815;
	private final int BACK_HEIGHT = 500;
	// 재시작
	private JButton retry;
	// 메인메뉴
	private JButton mainMenu;
	// 게임 오버
	private JButton gameOver;
	private ImageIcon gameOverIcon;

	MiniGameFrame mContext;

	// 점수 표시 확인
	private int resultScore;

	// 생성자 의존 DI 주입
	public ResultScreen(MiniGameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		mouseEvent();
	}

	private void initData() {
		// 배경 이미지
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		setContentPane(backgroundMap);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(BACK_WIDTH, BACK_HEIGHT);

		// retry
		retry = new JButton("RETRY");
		retry.setFont(new Font("둥근모꼴", Font.PLAIN, 25));
		retry.setBorderPainted(false); // 외각 투명하게
		retry.setContentAreaFilled(false); // 내용 영역 채우기 없애기
		retry.setFocusPainted(false); // 선택 되었을 때 얇은 점선 테두리 없애기
		retry.setBounds(230, 250, 150, 50);
		// mainMenu
		mainMenu = new JButton("MAIN MENU");
		mainMenu.setFont(new Font("둥근모꼴", Font.PLAIN, 25));
		mainMenu.setBorderPainted(false); // 외각 투명하게
		mainMenu.setContentAreaFilled(false); // 내용 영역 채우기 없애기
		mainMenu.setFocusPainted(false); // 선택 되었을 때 얇은 점선 테두리 없애기
		mainMenu.setBounds(360, 250, 210, 50);
		// gameOver
		gameOverIcon = new ImageIcon("img/gameOver.png"); // 게임 종료 이미지
		gameOver = new JButton(gameOverIcon);
		gameOver.setBorderPainted(false); // 외각 투명하게
		gameOver.setContentAreaFilled(false); // 내용 영역 채우기 없애기
		gameOver.setFocusPainted(false); // 선택 되었을 때 얇은 점선 테두리 없애기
		gameOver.setBounds(230, 85, 350, 120);

	} // end of initData()

	private void setInitLayout() {
		setVisible(true); // frame 보이기
		setLocationRelativeTo(null); // 프레임 화면을 정중앙에 띄우기
		setResizable(false); // 프레임 고정

		add(retry);
		add(mainMenu);
		add(gameOver);

	} // end of setInitLayout()

	// 가운데 점수 표시 하기
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Font f = new Font("둥근모꼴", Font.PLAIN, 30);
		g.setFont(f);
		// 점수 : 폰트 출력
		String scoreDraw = "score : " + Integer.toString(mContext.getScores());
		g.drawString(scoreDraw, 325, 270);
	} // end of paint()

	// 마우스 이벤트 리스너
	public void mouseEvent() {

		retry.addMouseListener(new MouseAdapter() {
			// 다시 하기

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MiniGameFrame();
			}
		});

		mainMenu.addMouseListener(new MouseAdapter() {
			// 메인으로 돌아가기

			@Override
			public void mouseClicked(MouseEvent e) {
				new MainScreen();
				dispose();
			}
		});

	} // end of mouseEvent()

}
