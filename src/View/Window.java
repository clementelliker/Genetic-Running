package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.*;

import Model.*;

public class Window extends JPanel{
	
	public int framerate;
	public Game game;
	public int wdHeight;
	public int wdWidth;
	
	public Window(int framerate, Game g, int wdHeight, int wdWidth) {
		this.framerate = framerate;
		this.game = g;
		this.wdHeight = wdHeight;
		this.wdWidth = wdWidth;
	}
	
	public void paintComponent(Graphics graphics) {
		Graphics2D g = (Graphics2D)graphics;
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paintComponent(g);
		this.drawMap(g);
		this.drawPlayer(g);
		this.drawWallDists(g);
		
	}
	
	public void drawMap(Graphics2D g) {
		for(int i = 0; i < this.game.map.mapHeight; i++) {
			for(int j = 0; j < this.game.map.mapWidth; j++) {
				if(this.game.map.tiles[i*this.game.map.mapWidth + j] == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(j*this.wdWidth/this.game.map.mapWidth, i*this.wdHeight/this.game.map.mapHeight, this.wdWidth/this.game.map.mapWidth, this.wdHeight/this.game.map.mapHeight);
				}
			}
		}
	}
	
	public void drawPlayer(Graphics2D g) {
		g.setColor(new Color(255,0,0));
		g.fill(new Ellipse2D.Double(this.game.player.xpos - this.game.player.hitBoxRay, this.game.player.ypos - this.game.player.hitBoxRay, this.game.player.hitBoxRay*2, this.game.player.hitBoxRay*2));
	}
	
	public void drawWallDists(Graphics2D g) {
		for(int i = 0; i < this.game.player.wallDists.length; i++) {
			g.setColor(new Color(0,255,255));
			g.draw(new Line2D.Double(this.game.player.xpos, this.game.player.ypos, this.game.player.wallDists[i][1], this.game.player.wallDists[i][2]));
		}
	}
	
	
	
}
