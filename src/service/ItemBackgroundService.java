package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import components.Item;

public class ItemBackgroundService{
	
	private BufferedImage image;
	private Item item;
	
	// 생성자 의존 주입
	public ItemBackgroundService(Item item) {
		this.item = item;
		try {
			image = ImageIO.read(new File("img/Background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 왼쪽에 있는 플레이어에게 닿을 시
	public boolean leftPlayer() {
		// 색상 확인(보정값)
		Color leftColor = new Color(image.getRGB(item.getX() + 10, item.getY() + 25));
		if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			return true;
		}
		return false;
	}


}
