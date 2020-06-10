package Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Simulation extends Game{
	
	ArrayList<Bot> bots;
	int nbBots;

	public Simulation(Map m, int nbbots) {
		this.map = m;
		this.nbBots = nbbots;
		this.bots = new ArrayList<Bot>(); 
	}
	
	public void initBots(int x, int y, int hBR, int angle) {
		for(int i = 0; i < this.nbBots; i++) {
			this.bots.add(new Bot(x,y,hBR,angle, new int[] {5,5,3}));
			this.bots.get(i).linkGame(this);
		}
	}
	
	public void runGen() {
		for(int i = 0; i < nbBots; i++) {
			this.bots.get(i).survivalTime = 0;
			this.bots.get(i).network.displayNetwork();
			while(this.bots.get(i).hittingWall() == false) {
				this.bots.get(i).getWallDist();
				this.bots.get(i).getInput();
				this.bots.get(i).udpatePlayer();
				this.bots.get(i).survivalTime++;
			}
			System.out.println(i + ": " + this.bots.get(i).survivalTime);
			for(int j = 0; j < 1; j++) {
				System.out.println();
			}
		}
	}
	
	public void mutateBots() {
		
	}
	
	
}
