package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Utility;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[] [] ;
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		tile = new Tile[10];
		mapTileNum =  new int [gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
		
			setup(0,"road00",false);
			setup(1,"wall",true);
			setup(2,"water00",true);
			setup(3,"Dirt",false);
			setup(4,"grass00",false);
			setup(5,"tree",true);
		
	}

	public void setup(int index, String imageName,boolean collision){
		Utility utility = new Utility();
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			tile[index].image = utility.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collison = collision;
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void loadMap(String filePath) {
		try {
			
			InputStream  is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line  = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col ++;
					
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row ++;
					
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
		
	}
	public void draw(Graphics2D g2) {
	
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol <gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int WorldX = worldCol * gp.tileSize;
			int WorldY = worldRow * gp.tileSize;
			int screenX = WorldX - gp.player.worldX + gp.player.screenX ;
			int screenY  = WorldY - gp.player.worldY + gp.player.screenY ;

			
			if(WorldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
					WorldX - gp.tileSize < gp.player.worldX + gp.player.screenX 	&& 
					WorldY + gp.tileSize > gp.player.worldY - gp.player.screenY  &&
					WorldY - gp.tileSize <	gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image,screenX, screenY,null);
				
			}
			
			worldCol++;
			
		if(worldCol == gp.maxWorldCol) {
			worldCol = 0;
			worldRow++;
		}
		}
		
	}
}
