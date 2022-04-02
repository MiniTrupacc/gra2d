package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Ob_Door extends SuperObject {

	GamePanel gp;

	
	public Ob_Door(GamePanel gp) {
		name = "Door";
		this.gp =gp;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			utility.scaleImage(image,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
