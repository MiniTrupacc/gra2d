package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Ob_Chest extends SuperObject {
	
	GamePanel gp;

	
	public Ob_Chest(GamePanel gp) {
		name = "Chest";
		this.gp =gp;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
			utility.scaleImage(image,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
