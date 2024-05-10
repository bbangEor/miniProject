package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import components.Item;

public class ItemBackgroundService {

	private BufferedImage image;
	private Item item;

	public ItemBackgroundService(Item item) {
		this.item = item;
		try {
			image = ImageIO.read(new File("img/Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean leftPlayer() {
		Color leftColor = new Color(image.getRGB(item.getX() + 10, item.getY() + 25));
		if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			return true;
		}
		return false;
	}

}