package miniProject;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PlayerBackgroundService implements Runnable {

	private BufferedImage image;
	private Player player;

	public PlayerBackgroundService(Player player) {
		this.player = player;
		System.out.println("rdfgtsdrfgs");
		try {
			image = ImageIO.read(new File("img/backService.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 부딪혔을 때 하트 - 1
	// 하트 아이템 먹었을 때 하트 + 1

	// 게임 스타트, 게임 오버 이미지 구하기

	// 이미지 넘어가는 것처럼 무한루프(이어붙이기)

	@Override
	public void run() {
		while (true) {
			Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
//			System.out.println("dipofhgposzhdfp");
			if (bottomColor.getRed() == 255 && bottomColor.getGreen() == 0 && bottomColor.getBlue() == 0) {
				player.setDown(false);
				System.out.println("땅");
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

//}
