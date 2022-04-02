package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.Utility;

public class Player extends Entity {
GamePanel gp;
KeyHandler keyH;

 public final int  screenX;
 public final int screenY;



public Player(GamePanel gp,KeyHandler keyH) {
	this.gp = gp;
	this.keyH = keyH;
	
	screenX = gp.screenWidth/2  - (gp.tileSize/2);
	screenY = gp.screenHeight/2 - (gp.tileSize/2);
	
	
	solidArea = new Rectangle();
	solidArea.x = 13;
	solidArea.y = 8;
	solidAreaDeafaultX = solidArea.x;
	solidAreaDeafaultY = solidArea.y;
	solidArea.width = 23;
	solidArea.height = 23;
	
	setDefaultValues();
	getPlayerImage();
	
	
	
}
 public void setDefaultValues() {
	  worldX = gp.tileSize * 23;
	  worldY = gp.tileSize * 21;
	 speed = 4;
	 direction = "down";
	 
 }
		public void getPlayerImage() {
			
			up1 =setup("playerLeft1");
			up2 =setup("playerLeft2");
			up3 =setup("playerLeft1");
			down1 =setup("playerDown1");
			down2 =setup("playerDown2");
			left1 =setup("playerLeft1");
			left2 =setup("playerLeft2");
			right1 =setup("playerLeft1");
			right2 =setup("playerLeft2");
			
		}
	 
		public  BufferedImage setup(String imageName) {
			
			Utility utility = new Utility();
			BufferedImage image = null;
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName +".png"));
				image = utility.scaleImage(image, gp.tileSize, gp.tileSize);
			}catch(IOException e) {
				e.printStackTrace();
			}
			return image;
		}
		
  public void update() {
	  
	  if(keyH.upPressed == true || keyH.downPressed == true ||
			  keyH.leftPressed == true || keyH.rightPressed == true) {

		  	if(keyH.upPressed == true) {
		
				direction ="up";
			}
			else if(keyH.downPressed == true) {
			
				direction ="down";
			}else if(keyH.leftPressed == true) {
			
				direction ="left";
			}else if (keyH.rightPressed == true){
				
				direction ="right";
			}
		  	collisionOn = false;
		  	gp.cCheck.checkTile(this);
		  	
		//  	int objIndex = gp.cCheck.CheckObject(this, true);
		
		  	
		  	if(collisionOn == false) {
		  		
		  		switch(direction) {
		  		
		  		case "up":
		  			worldY -= speed;
		  			break;
		  		case "down":
		  			worldY += speed;
		  			break;
		  		case "left":
		  			worldX -= speed;
		  			break;
		  		case "right":
		  			worldX += speed;
		  			break;
		  		}
		  	}
		  	
		  	
		  spriteCounter ++;
		  if(spriteCounter >14) {
			  if(spriteNum == 1) {
				  spriteNum = 2;
			  }else if(spriteNum == 2) {
				  spriteNum = 1;
			  }
			  spriteCounter = 0;
		  }
		  
	  }
  }
  public void pickUpObject(int i) {
	  if(i != 999) {
		 
  }
  public void draw(Graphics2D g2) {
		
	  
	  BufferedImage image = null;
	  switch(direction) {
	  case "up":
		  if(spriteNum == 1) {
			  image = up1;
		  }
		  if(spriteNum == 2) {
			  image = up2;
			  
		  }
		  if(spriteNum == 3) {
			  image = up3;
		  }
		  break;
	  case "down":
		  if(spriteNum == 1) {
			  image = down1;
		  }
		  if(spriteNum == 2) {
			  image = down2;
		  }
			  break;
	  case "left":
		  if(spriteNum == 1) {
			  image = left1;
		  }
		  if(spriteNum == 2) {
			  image = left2;
		  }
	  break;
	  case "right":
		  if(spriteNum == 1) {
			  image = right1;
		  }
		  if(spriteNum == 2) {
			  image = right2;
		  }
		  break;
	  }
	  
	  g2.drawImage(image, screenX, screenY,null);
  }
}
