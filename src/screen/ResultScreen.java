package screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import components.Score;
import test.MiniGameFrame;

public class ResultScreen extends JFrame {

	ImageIcon gameOver;
	private JLabel backgroundMap;
	ResultScreen mContext;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private ImageIcon img2;

	// 점수 표시 확인 테스트 (삭제예정)
	private int resultScore = 99999;
	private Score score = new Score();

	// 생성자
	public ResultScreen() {
		initData();
		setInitLayout();
		mouseEvent();
	} // end of ResultBoard()

	private void initData() {
		// 배경 이미지
		backgroundMap = new JLabel(new ImageIcon("img/Background1.jpg"));
		setContentPane(backgroundMap);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap); // add 처리
		setSize(815, 500);

		img2 = new ImageIcon("img/gameOver.png"); // 게임 종료 이미지

		button2 = new JButton("RETRY");
		button2.setFont(new Font("둥근모꼴", Font.PLAIN, 25));
		button2.setBorderPainted(false); // 버튼 투명
		button2.setContentAreaFilled(false); // 버튼 투명
		button2.setFocusPainted(false); // 버튼 투명
		button2.setBounds(230, 250, 150, 50);

		button3 = new JButton("MAIN MENU");
		button3.setFont(new Font("둥근모꼴", Font.PLAIN, 25));
		button3.setBorderPainted(false); // 버튼 투명
		button3.setContentAreaFilled(false); // 버튼 투명
		button3.setFocusPainted(false); // 버튼 투명
		button3.setBounds(360, 250, 210, 50);

		button4 = new JButton(img2);
		button4.setContentAreaFilled(false); // 버튼 투명
		button4.setBorderPainted(false); // 버튼 투명
		button4.setFocusPainted(false); // 버튼 투명
		button4.setBounds(230, 100, 350, 120);

	} // end of initData()

	private void setInitLayout() {
		setVisible(true); // frame 보이기
		setLocationRelativeTo(null); // 프레임 화면을 정중앙에 띄우기
		setResizable(false); // 프레임 고정

		add(button2); //
		add(button3); //
		add(button4); //

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

		button2.addMouseListener(new MouseAdapter() {
			// 다시 하기

			@Override
			public void mouseClicked(MouseEvent e) {
				// new Pjh_TestMain();
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

		button3.addMouseListener(new MouseAdapter() {

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