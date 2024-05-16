package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BombBackgroundService implements Runnable {

	private BufferedImage image;
	private components.Bomb bomb;
	
	// 생성자 의존 주입
	public BombBackgroundService(components.Bomb bomb) {
		this.bomb = bomb;
		try {
			image = ImageIO.read(new File("img/Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인(보정값)
			Color leftColor = new Color(image.getRGB(bomb.getX() + 10, bomb.getY() + 25));
			int playerLeftColor = image.getRGB(bomb.getX() + 10, bomb.getY() + 25);

		}
	}

}
