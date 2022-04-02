package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

	GamePanel gp;
	Graphics2D g2;
	Font arial_20;
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_20 = new Font("Arial",Font.PLAIN,20);
	}
	public void draw(Graphics2D g2) {
		
	this.g2 = g2;
	
	g2.setFont(arial_20);
	g2.setColor(Color.white);
	if(gp.gameState == gp.playState) {
		
	}
	if(gp.gameState == gp.pauseState) {
		drawPauseScreen();
	}
	}
	public void drawPauseScreen() {
		
		String text = "PAUZA";
		int x = getXforCenterText(text);
	
		int y = gp.screenHeight/2 ;
		g2.drawString(text, x, y);
	}
	public int getXforCenterText(String text) {
		int lenght = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
		int x = gp.screenWidth/2  - lenght/2;
		return x;
	}
}
