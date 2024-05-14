package screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import test.MiniGameFrame;

public class ResultScreen extends JFrame {

	ResultScreen mContext;

	// ImageIcon gameOver;
	private JLabel backgroundMap;
	private JButton retry;
	private JButton mainMenu;
	private JButton gameOver;
	private ImageIcon gameOverIcon;

	// 점수 표시 확인 테스트 (삭제예정)
	private int resultScore;
	
	// 생성자
	public ResultScreen() {
		initData();
		setInitLayout();
		mouseEvent();
	}

	private void initData() {
		// 배경 이미지
		backgroundMap = new JLabel(new ImageIcon("img/Background.jpg"));
		setContentPane(backgroundMap);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(815, 500);

		gameOverIcon = new ImageIcon("img/gameOver.png"); // 게임 종료 이미지
		// retry
		retry = new JButton("RETRY");
		retry.setFont(new Font("둥근모꼴", Font.PLAIN, 25));
		retry.setBorderPainted(false); // 버튼 투명
		retry.setContentAreaFilled(false); // 버튼 투명
		retry.setFocusPainted(false); // 버튼 투명
		retry.setBounds(230, 250, 150, 50);
		// mainMenu
		mainMenu = new JButton("MAIN MENU");
		mainMenu.setFont(new Font("둥근모꼴", Font.PLAIN, 25));
		mainMenu.setBorderPainted(false); // 버튼 투명
		mainMenu.setContentAreaFilled(false); // 버튼 투명
		mainMenu.setFocusPainted(false); // 버튼 투명
		mainMenu.setBounds(360, 250, 210, 50);
		// gameOver
		gameOver = new JButton(gameOverIcon);
		gameOver.setContentAreaFilled(false); // 버튼 투명
		gameOver.setBorderPainted(false); // 버튼 투명
		gameOver.setFocusPainted(false); // 버튼 투명
		gameOver.setBounds(230, 100, 350, 120);

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
		g.drawString("score:", 320, 270);
		// int 값을 -> String으로 변환
		String scoreDraw = Integer.toString(resultScore);
		g.drawString(scoreDraw, 410, 270);
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

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		}); // end of button2

		mainMenu.addMouseListener(new MouseAdapter() {

			// 메인으로 돌아가기

			@Override
			public void mouseClicked(MouseEvent e) {
				new MainScreen();
				dispose();
				// setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		}); // end of button3

	} // end of mouseEvent()

	public static void main(String[] args) {
		new ResultScreen();
	} // end of main
}