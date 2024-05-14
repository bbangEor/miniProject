package screen;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import test.MiniGameFrame;

public class MainScreen extends MiniGameFrame {

	private JLabel mainmenuMap;
	private JPanel jPanel1;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private ImageIcon img1;
	private ImageIcon img2;
	private ImageIcon img3;
	private ImageIcon img4;
	private JLabel comments;

	public MainScreen() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		mainmenuMap = new JLabel(new ImageIcon("img/Background.jpg"));
		setContentPane(mainmenuMap);// 배경화면 출력
		setSize(815, 500);
		jPanel1 = new JPanel();
		img1 = new ImageIcon("img/startGame.png");
		img2 = new ImageIcon("img/quit.png");
		img3 = new ImageIcon("img/startGame2.png");
		img4 = new ImageIcon("img/quit2.png");
		button1 = new JButton(img1);
		button2 = new JButton(img2);
		button3 = new JButton(img3);
		button4 = new JButton(img4);

		comments = new JLabel("MINI GAME");
		comments.setFont(new Font("둥근모꼴", Font.PLAIN, 20));
//		jPanel1.add(comments);

	}

	public void setInitLayout() {
		setResizable(false);
		setLayout(null);
		button1.setBounds(210, 130, 350, 100);
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button2.setBounds(210, 250, 350, 100);
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button2.setFocusPainted(false);
		comments.setBounds(20, 0, 150, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		add(jPanel1);
		add(comments);
		add(button1);
		add(button2);
		add(button3);
		add(button4);

	}

	public void addEventListener() {

		button1.addMouseListener(new MouseAdapter() {
			// 마우스 버튼을 누를때 발생
			@Override
			public void mousePressed(MouseEvent e) {
				button1.setVisible(false);
				System.out.println("길게누름");
				new MiniGameFrame();
				setVisible(false);
			}

			// 마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
			@Override
			public void mouseExited(MouseEvent e) {
				button1.setVisible(true);
				button3.setVisible(false);

				System.out.println("나옴");
				repaint();
			}

			// 마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setVisible(false);
				button3.setVisible(true);
				button3.setBounds(210, 130, 350, 100);
				button3.setBorderPainted(false);
				button3.setContentAreaFilled(false);
				button3.setFocusPainted(false);
				System.out.println("들어감");
				repaint();
			}

			// 마우스가 해당 컴포넌트를 클릭했을때.
			@Override
			public void mouseClicked(MouseEvent e) {
				button1.setVisible(false);

				new MiniGameFrame();
				setVisible(false);
			}
		});
		// 마우스 버튼을 누를때 발생
		button2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				button2.setVisible(false);
				System.out.println("길게누름");
				System.exit(0);
				setVisible(false);
			}

			// 마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
			@Override
			public void mouseEntered(MouseEvent e) {
				button2.setVisible(false);
				button4.setVisible(true);
				button4.setBounds(210, 250, 350, 100);
				button4.setBorderPainted(false);
				button4.setContentAreaFilled(false);
				button4.setFocusPainted(false);
				System.out.println("들어감");
				repaint();
			}

			// 마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
			@Override
			public void mouseExited(MouseEvent e) {
				button2.setVisible(true);
				button4.setVisible(false);
				System.out.println("나옴");
				repaint();
			}

		});
	}

	public static void main(String[] args) {
		new MainScreen();
	}
}
