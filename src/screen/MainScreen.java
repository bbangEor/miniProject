package screen;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainScreen extends MiniGameFrame {

	// 배경화면
	private JLabel backgroundMap;
	// 배경화면 사이즈
	private final int BACK_WIDTH = 815;
	private final int BACK_HEIGHT = 500;
	// 패널 생성
	private JPanel jPanel;
	// startGame 버튼
	private JButton startGame1;
	private JButton startGame2;
	// quit 버튼
	private JButton quit1;
	private JButton quit2;
	// startGame 이미지
	private ImageIcon startGameImg1;
	private ImageIcon startGameImg2;
	// quit 이미지
	private ImageIcon quitImg1;
	private ImageIcon quitImg2;
	// 게임 방법 설명
	private JLabel comments;

	public MainScreen() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		// 배경화면 출력
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		setContentPane(backgroundMap);
		setSize(BACK_WIDTH, BACK_HEIGHT);
		// 패널 생성
		jPanel = new JPanel();
		// startGame 출력
		startGameImg1 = new ImageIcon("img/startGame.png");
		startGameImg2 = new ImageIcon("img/startGame2.png");
		startGame1 = new JButton(startGameImg1);
		startGame2 = new JButton(startGameImg2);
		// quit 출력
		quitImg1 = new ImageIcon("img/quit.png");
		quitImg2 = new ImageIcon("img/quit2.png");
		quit1 = new JButton(quitImg1);
		quit2 = new JButton(quitImg2);
		// comments 출력
		comments = new JLabel("Space = Jump");
		comments.setFont(new Font("둥근모꼴", Font.PLAIN, 23));

	}

	public void setInitLayout() {
		setResizable(false);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 가운데 배치
		// startGame 버튼 이미지 설정
		startGame1.setBounds(235, 130, 330, 60);
		startGame1.setBorderPainted(false); // 외각 투명하게
		startGame1.setContentAreaFilled(false); // 내용영역 채우기 없애기
		startGame1.setFocusPainted(false); // 선택 되었을 때 얇은 점선 테두리 없애기
		add(startGame1);
		add(startGame2);
		// quit 버튼 이미지 설정
		quit1.setBounds(325, 250, 150, 50);
		quit1.setBorderPainted(false); // 외각 투명하게
		quit1.setContentAreaFilled(false); // 내용영역 채우기 없애기
		quit1.setFocusPainted(false); // 선택 되었을 때 얇은 점선 테두리 없애기
		add(quit1);
		add(quit2);
		// comment 설정
		comments.setBounds(20, 0, 150, 100);
		add(comments);

	}

	// 이벤트 리스너
	public void addEventListener() {
		startGame1.addMouseListener(new MouseAdapter() {
			// 마우스 버튼을 누를때 발생
			@Override
			public void mousePressed(MouseEvent e) {
				// startGame 버튼을 누르면 게임 화면으로 전환
				startGame1.setVisible(false);
				new MiniGameFrame();
				setVisible(false);
			}

			// 마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
			@Override
			public void mouseExited(MouseEvent e) {
				startGame1.setVisible(true);
				startGame2.setVisible(false);
				repaint();
			}

			// 마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
			@Override
			public void mouseEntered(MouseEvent e) {
				startGame1.setVisible(false);
				startGame2.setVisible(true);
				startGame2.setBounds(235, 130, 330, 60);
				startGame2.setBorderPainted(false); // 외각 투명하게
				startGame2.setContentAreaFilled(false); // 내용영역 채우기 없애기
				startGame2.setFocusPainted(false); // 선택 되었을 때 얇은 점선 테두리 없애기
				repaint();
			}

			// 마우스가 해당 컴포넌트를 클릭했을때.
			@Override
			public void mouseClicked(MouseEvent e) {
				startGame1.setVisible(false);
				new MiniGameFrame();
				setVisible(false);
			}
		});
		// 마우스 버튼을 누를때 발생
		quit1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				quit1.setVisible(false);
				System.out.println("길게누름");
				System.exit(0);
				setVisible(false);
			}

			// 마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
			@Override
			public void mouseEntered(MouseEvent e) {
				quit1.setVisible(false);
				quit2.setVisible(true);
				quit2.setBounds(325, 250, 150, 50);
				quit2.setBorderPainted(false); // 외각 투명하게
				quit2.setContentAreaFilled(false); // 내용영역 채우기 없애기
				quit2.setFocusPainted(false); // 선택 되었을 때 얇은 점선 테두리 없애기
				System.out.println("들어감");
				repaint();
			}

			// 마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
			@Override
			public void mouseExited(MouseEvent e) {
				quit1.setVisible(true);
				quit2.setVisible(false);
				System.out.println("나옴");
				repaint();
			}

		});
	}

}
