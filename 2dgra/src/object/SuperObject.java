package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.Utility;

public class SuperObject {
public BufferedImage image;
public String name;
public boolean collision = false;
public int worldX, WorldY;
public Rectangle solidArea = new Rectangle(0,0,48,48);
public int solidAreaDeafaultX = 0;
public int solidAreaDeafaultY = 0;
Utility utility = new Utility();

public void draw(Graphics2D g2, GamePanel gp) {
	
	int screenX = worldX - gp.player.worldX + gp.player.screenX ;
	int screenY  = WorldY - gp.player.worldY + gp.player.screenY ;

	
	if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX 	&& 
			WorldY + gp.tileSize > gp.player.worldY - gp.player.screenY  &&
			WorldY - gp.tileSize <	gp.player.worldY + gp.player.screenY) {
		
		g2.drawImage(image,screenX, screenY, gp.tileSize,gp.tileSize,null);
		
	
}
}
}
