package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import components.Player;

public class PlayerBackgroundService implements Runnable {

	private BufferedImage image;
	private Player player;

	// 생성자 의존 주입
	public PlayerBackgroundService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("img/backService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인(보정값)
			Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
			if (bottomColor.getRed() == 255 && bottomColor.getGreen() == 0 && bottomColor.getBlue() == 0) {
				player.setDown(false);
			} else {
				if (!player.isUp() && !player.isDown()) {
					player.down();
				}

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
}
