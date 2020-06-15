package Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Simulation extends Game{
	
	static Random seed = new Random();
	public ArrayList<Bot> bots;
	int nbBots;

	public Simulation(Map m, int nbbots) {
		this.map = m;
		this.nbBots = nbbots;
		this.bots = new ArrayList<Bot>(); 
	}
	
	public void initBots(int x, int y, int hBR, int angle, int[] consti) {
		for(int i = 0; i < this.nbBots; i++) {
			this.bots.add(new Bot(x,y,hBR,angle, consti));		
			this.bots.get(i).linkGame(this);
		}
	}
	
	public void runGen() {
		for(int i = 0; i < nbBots; i++) {
			this.bots.get(i).survivalTime = 0;
			while(this.bots.get(i).hittingWall() == false && this.bots.get(i).lapDone() == false) {
				this.bots.get(i).getWallDist();
				this.bots.get(i).getInput();
				this.bots.get(i).udpatePlayer();
				this.bots.get(i).survivalTime++;
			}
			this.bots.get(i).lapFinished = this.bots.get(i).lapDone();
			for(int j = 0; j < 0; j++) {
				System.out.println();
			}
		}
	}
	
	public void mutateBots(int nbSelectedBots) {
		ArrayList<Bot>  bestBots = this.getBestBots(nbSelectedBots);
		bestBots.get(0).network.displayNetwork(); //showing weights of the best bot of the gen to copy it and watch it on SimuBot
		showArray(bestBots);
		ArrayList<Bot> newGenBots = new ArrayList<Bot>(); 
		for(int i = 0; i < bestBots.size(); i++) {
			for(int j = 0; j < (this.nbBots/nbSelectedBots); j++) {
				newGenBots.add(mutatedBot(bestBots.get(i), seed.nextDouble()/3, seed.nextDouble()/3));
			}
		}
		if(newGenBots.size() != this.nbBots) {
			while(newGenBots.size() != this.nbBots) {
				newGenBots.add(mutatedBot(bestBots.get(0), seed.nextDouble()/3, seed.nextDouble()/3));
			}
		}
		this.bots = newGenBots;
	}

	public Bot mutatedBot(Bot bot, double mutationRate, double mutationSize) {
		Bot ret = new Bot((this.map.startTile%10)*this.window.wdWidth/this.map.mapWidth + this.window.wdHeight/(this.map.mapWidth*2), 
				(int)(this.map.startTile/10)*this.window.wdHeight/this.map.mapHeight + this.window.wdHeight/(this.map.mapHeight*2),
						bot.hitBoxRay, this.map.startAngle, bot);
		ret.linkGame(this);
		for(int i = 0; i < ret.network.neurons.size(); i++) {
			for(int j = 0; j < ret.network.neurons.get(i).size(); j++) {
				for(int k = 0; k < ret.network.neurons.get(i).get(j).weights.length; k++) {
					if(seed.nextDouble() < mutationRate) {
						ret.network.neurons.get(i).get(j).weights[k] += mutationSize*seed.nextDouble();
					}
				}
			}
		}
		return ret;
	}

	public ArrayList<Bot> getBestBots(int nbRetBots) {
		ArrayList<Bot> ret = new ArrayList<Bot>(); 
		for(int i = 0; i < this.nbBots; i++) {
			int j = 0;
			boolean added = false;
			while(j < ret.size() && added == false) {
				if((this.bots.get(i).lapFinished == true && ret.get(j).lapFinished == false) ||
						(this.bots.get(i).lapFinished == true && ret.get(j).lapFinished == true	&& this.bots.get(i).survivalTime < ret.get(j).survivalTime) ||
						(this.bots.get(i).lapFinished == false && ret.get(j).lapFinished == false && this.bots.get(i).survivalTime > ret.get(j).survivalTime)) {
					added = true;
					if(ret.size() < nbRetBots) {
						ret.add(ret.get(ret.size() - 1));
						for(int k = ret.size()-2; k > j; k--) {
							ret.set(k, ret.get(k-1));
						}
						ret.set(j, this.bots.get(i));
					}else {
						for(int k = ret.size()-2; k > j; k--) {
							ret.set(k, ret.get(k-1));
						}
						ret.set(j, this.bots.get(i));
					}
				}
				j++;
			}
			if(ret.size() < nbRetBots && added == false) {
				ret.add(this.bots.get(i));
			}
		}
		return ret;
	}
	
	public static void showArray(ArrayList<Bot> bestBots) {
		for(int i = 0; i < bestBots.size(); i++){
			System.out.println("pos: " + i + " time: " + bestBots.get(i).survivalTime + " lap: " + bestBots.get(i).lapFinished);
		}
		System.out.println();
	}

	public void updBotsPos() {
		for(int i = 0; i < this.nbBots; i++) {
			this.bots.get(i).xpos = (this.map.startTile%10)*this.window.wdWidth/this.map.mapWidth + this.window.wdHeight/(this.map.mapWidth*2);
			this.bots.get(i).ypos = (int)(this.map.startTile/10)*this.window.wdHeight/this.map.mapHeight + this.window.wdHeight/(this.map.mapHeight*2);
			this.bots.get(i).angle = this.map.startAngle;
		}
		
	}
	
	
}
