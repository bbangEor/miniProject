package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BombBackgroundService implements Runnable {

	private BufferedImage image;
	// private Object object;

	public BombBackgroundService(Object object) {
		//this.object = object;
		try {
			image = ImageIO.read(new File("img/Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
//			Color leftColor = new Color(image.getRGB(object.getX() + 10, object.getY() + 25));
//
//			int playerLeftColor = image.getRGB(object.getX() + 10, object.getY() + 25);

		}
		
	}

}