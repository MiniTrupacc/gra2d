package main;
import java.awt.Color;
import tile.TileManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;

public class GamePanel extends JPanel implements Runnable {
	
	final int orginalTileSize = 16;	//16x16 pixeli
	final int orginalPlayerSize = 13;
	final int orginalPlayerSize1 = 8;
	final int scale = 3;
	
	public final int tileSize =  orginalTileSize * scale;		//48x48 pixeli
	public final int playerSize = orginalPlayerSize * scale;
	public final int playerSize1 = orginalPlayerSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;		//768 pixeli
	public final int screenHeight = tileSize * maxScreenRow;		//576 pixeli
	
	
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	int FPS=60;
	
	TileManager tileM = new TileManager (this);
	KeyHandler keyH = new KeyHandler(this);
	Sound soundEffect = new Sound();
	Sound music = new Sound();
	public UI ui = new UI(this);

	public CollisionCheck cCheck = new CollisionCheck(this);
	public AssetSetter aSetter = new AssetSetter(this);
	Thread gameThread;
	
	// gracz obiekty
	public Player player = new Player(this,keyH); 
	public SuperObject obj[] = new SuperObject[10];
	
	//stan gry pauza
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
	}
	public void setupGame() {
		aSetter.setObject();
		playMusic(0);
		stopMusic();
		gameState = playState;
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
	 double drawInterval = 1000000000/FPS;
	 double delta = 0;
	 long lastTime = System.nanoTime();
	 long currentTime;
		while(gameThread != null) {
		
			currentTime =  System.nanoTime();
			delta += (currentTime - lastTime)/ drawInterval;
			lastTime= currentTime;
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
				
		
	
		}}
	
		public void update() {
			
			if(gameState == playState) {
				player.update();
			}
			if(gameState == pauseState) {
				
			}
			
		
			
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D)g;
			
			
			//tile
			tileM.draw(g2);
			//obiekty
			for(int i = 0; i <obj.length; i++) {
				if(obj[i] != null) {
					obj[i].draw(g2, this);
				}
			}
			//gracz
			player.draw(g2);
			
			//UI
			ui.draw(g2);
			
			g2.dispose();
		}
		public void playMusic(int i ) {
			music.setFile(i);
			music.play();
			music.loop();
		}
		public void stopMusic() {
		
			//music.stop();
		}
		public void playSoundEffect(int i) {
			soundEffect.setFile(i);
			soundEffect.play();
		}
	}
