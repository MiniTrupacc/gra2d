package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Ob_Key extends SuperObject {
	
	GamePanel gp;
	
	public Ob_Key(GamePanel gp) {
		name = "Key";
		this.gp =gp;
		try {
			image =ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			utility.scaleImage(image,gp.tileSize,gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
