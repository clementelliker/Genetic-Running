package View;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.MyKeyListener;
import Controller.MyMouseListener;
import Model.*;

public class MainIA {
	
public static long maxFramerate = 144;
	
	public static void main(String[] args) {
		int[] map = new int[] {0,0,0,0,0,0,0,0,0,1,
				   0,1,1,1,1,1,1,1,0,1,
				   0,0,1,0,0,0,0,0,0,1,
				   1,0,1,0,1,1,1,1,1,1,
				   1,0,1,0,1,1,0,0,0,0,
				   1,0,1,0,0,0,0,1,1,0,
				   1,0,0,1,1,1,1,1,0,0,
				   1,1,0,0,0,1,1,0,0,1,
				   1,1,1,1,0,1,1,0,1,1,
				   1,1,1,1,0,0,0,0,1,1};
		Simulation sim = new Simulation(new Map(10,10, map), 1000);
		Window wd = new Window(144, sim, 720, 720);
		wd.game.linkWindow(wd);
		sim.initBots(500, 325, 10, 0);
		while(true) {
			sim.runGen();
		}
		
	}
	
	
	/*
	public static void main(String[] args) {
		JFrame cadre = new JFrame("Genetic Running");
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[] map = new int[] {0,0,0,0,0,0,0,0,0,1,
							   0,1,1,1,1,1,1,1,0,1,
							   0,0,1,0,0,0,0,0,0,1,
							   1,0,1,0,1,1,1,1,1,1,
							   1,0,1,0,1,1,0,0,0,0,
							   1,0,1,0,0,0,0,1,1,0,
							   1,0,0,1,1,1,1,1,0,0,
							   1,1,0,0,0,1,1,0,0,1,
							   1,1,1,1,0,1,1,0,1,1,
							   1,1,1,1,0,0,0,0,1,1};
		Game game = new Game(new Map(10,10, map), new Bot(500,325, 10, 0, new int[] {5,5,3}));
		game.player.linkGame(game);
		Window wd = new Window(144, game, 720, 720);
		wd.game.linkWindow(wd);
		JTextField component = new JTextField();
	    wd.addMouseListener(new MyMouseListener());
	    component.addKeyListener(new MyKeyListener(wd));
	    cadre.add(component);
		cadre.add(wd);
		cadre.setSize(wd.wdWidth+16,wd.wdHeight+39);
		cadre.setVisible(true);
		double maxFramerateCapping = 1000/maxFramerate;
		while(wd.game.checkLoose() == false) {
			Chrono c = new Chrono(maxFramerateCapping);
			wd.game.update();
			wd.repaint();
			wd.game.player.getWallDist();
			wd.game.player.getInput();
			while(!c.elapsedMaxTime()) {
				
			}
		}
	}
	*/
}
