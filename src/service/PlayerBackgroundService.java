package service;

import java.awt.image.BufferedImage;

import components.Player;

public class PlayerBackgroundService implements Runnable {

	private BufferedImage image;
	private Player player;

	public PlayerBackgroundService(Player player) {
		this.player = player;
	}

	image = imageIO.read(new File("img/background.png"));

	@Override
		public void run() {
			while(true) {
				int bottomColorLeft = image.getRGB(player.getX(), player.getY());
				int bottomColorRight = image.getRGB(player.getX(), player.getY());
			
			if(bottomColorLeft + bottomColorRight != -2) {
				player.setDown(false)
			} else {
				if(!player.isup() && !player.isDown()) {
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
