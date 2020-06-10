package Model;

import java.awt.Window;
import java.awt.event.KeyEvent;

public class Game {
	
	public View.Window window;
	public Map map;
	public Player player;
	public boolean[] keys;
	
	public Game(Map m, Player p) {
		this.map = m;
		this.player = p;
		this.keys = new boolean[1000];
	}
	
	public Game() {
		
	}
	
	public void linkWindow(View.Window w) {
		this.window = w;
	}
	
	public void keyPressed(KeyEvent e) {
		this.keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		this.keys[e.getKeyCode()] = false;
	}
	
	public void update() {
		this.player.udpatePlayer();
		 if(this.keys[KeyEvent.VK_Q]){
		     this.player.qPressed();
		 }

		 if(this.keys[KeyEvent.VK_D]){
			 this.player.dPressed();
		 }
	}

	public boolean checkLoose() {
		return this.player.hittingWall();
	}
}
