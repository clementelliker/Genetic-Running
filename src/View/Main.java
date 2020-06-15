package View;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.*;
import Model.*;

public class Main {
	
	public static long maxFramerate = 144;
	
	public static void main(String[] args) {
		int wdW = 720;
		int wdH = 720;
		JFrame cadre = new JFrame("Genetic Running");
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[] map = new int[]{0,0,0,1,1,1,0,0,0,1,
				0,1,0,1,0,0,0,1,0,0,
				0,1,0,1,0,1,1,1,1,0,
				0,1,0,1,0,0,1,1,0,0,
				0,1,0,1,1,0,1,0,0,1,
				0,1,0,0,0,0,1,0,1,1,
				0,1,1,1,1,1,1,0,0,1,
				0,1,1,0,0,0,0,1,0,0,
				0,0,1,0,1,1,0,1,1,0,
				1,0,0,0,1,1,0,0,0,0};
		Map m = new Map(10,10, map, 1, 0, 0);
		Game game = new Game(m, new Player((m.startTile%10)*wdW/m.mapWidth + wdW/(m.mapWidth*2),(int)(m.startTile/10)*wdH/m.mapHeight + wdH/(m.mapHeight*2), 10, m.startAngle));
		game.player.linkGame(game);
		Window wd = new Window(144, game, wdW, wdH);
		wd.game.linkWindow(wd);
		JTextField component = new JTextField();
	    wd.addMouseListener(new MyMouseListener());
	    component.addKeyListener(new MyKeyListener(wd));
	    cadre.add(component);
		cadre.add(wd);
		cadre.setSize(wd.wdWidth+16,wd.wdHeight+39);
		cadre.setVisible(true);
		double maxFramerateCapping = 1000/maxFramerate;
		while(wd.game.checkLoose() == false && wd.game.checkWin() == false) {
			Chrono c = new Chrono(maxFramerateCapping);
			wd.game.update();
			wd.repaint();
			wd.game.player.getWallDist();
			while(!c.elapsedMaxTime()) {
				
			}
		}
	}
	/* 
	 * {0,0,0,0,0,0,0,0,0,1,
				               0,1,1,1,1,1,1,1,0,1,
				               0,0,1,0,0,0,0,0,0,1,
				               1,0,1,0,1,1,1,1,1,1,
				               1,0,1,0,1,1,0,0,0,0,
				               1,0,1,0,0,0,0,1,1,0,
				               1,0,0,1,1,1,1,1,0,0,
				               1,1,0,0,0,1,1,0,0,1,
				               1,1,1,1,0,1,1,0,1,1,
				               1,1,1,1,0,0,0,0,1,1};
	 */
}
