package View;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.MyKeyListener;
import Controller.MyMouseListener;
import Model.Bot;
import Model.Chrono;
import Model.Game;
import Model.Map;

public class SimuBot {
	
	public static long maxFramerate = 144;
	static int wdW = 720;
	static int wdH = 720;
	
	public static void main(String[] args) {
		JFrame cadre = new JFrame("Genetic Running");
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PUT ANY MAP AND MAKE SURE TO WRITE THE RIGHT INITIAL POSITION/ANGLE/FINISH POS
		
	     int[] map = new int[] {1,0,0,0,0,0,0,0,0,1,
		 	       0,0,1,1,1,1,1,1,0,1,
	 	   	       0,1,0,0,0,0,0,0,0,1,
			       0,1,0,1,1,1,1,1,1,1,
	 		       0,1,0,0,1,0,0,0,1,1,
	 	               0,0,1,0,0,0,1,0,1,1,
	 	  	       1,0,0,1,1,1,1,0,1,1,
			       1,1,0,0,1,0,0,0,1,1,
		 	       1,1,1,0,0,0,1,1,1,1,
		 	       1,1,1,1,1,1,1,1,1,1};

	Map m = new Map(10, 10, map, 4, 5, (int)(Math.PI));
		Game game = new Game(m);
		Bot b = new Bot((m.startTile%10)*wdW/m.mapWidth + wdW/(m.mapWidth*2),(int)(m.startTile/10)*wdH/m.mapHeight + wdH/(m.mapHeight*2), 10, 0, new int[] {5,5,3});//MAKE SURE TO HAVE TO RIGHT NETWORK SIZES HERE
		game.addP(b);
		game.player.linkGame(game);
		Window wd = new Window(144, game, wdW, wdH);
		wd.game.linkWindow(wd);
		
		//PUT HERE THE NETWORK DISPLAYED BY THE CONSOLE
		
		b.network.neurons.get(0).get(0).weights = new double[] {-0.35844466527633095,1.0301218149643185,0.26249354336181807,-0.7003311027195186,0.04871558310674284};
		b.network.neurons.get(0).get(1).weights = new double[] {0.9242056381612286,0.5129426075407255,0.7347520768425918,-0.47802921188016473,1.0463052365580696};
		b.network.neurons.get(0).get(2).weights = new double[] {0.8510657381001439,-0.2945317776798212,-0.8593887779797771,1.1537896337896512,0.1323914663909556};
		b.network.neurons.get(0).get(3).weights = new double[] {1.3750318242218988,-0.12709306419326824,0.09475003417855374,0.7732966089409494,0.9834264886088787};
		b.network.neurons.get(0).get(4).weights = new double[] {0.2689046699174944,0.5128931627618624,0.9312675895372702,-0.4207881739966555,-0.03649423181353095};
		b.network.neurons.get(0).get(5).weights = new double[] {0.7074485661597345,0.4978237651742419,0.0013114664641095675,1.2790487068939518,-0.6151360854066494};

		b.network.neurons.get(1).get(0).weights = new double[] {0.38879495960334987,-0.12229096252832924,0.223698557483579};
		b.network.neurons.get(1).get(1).weights = new double[] {0.0027617486577813117,-0.233055109691839,-0.17567248493524118};
		b.network.neurons.get(1).get(2).weights = new double[] {0.14035720497877172,0.8201903123974381,1.0126758334046997};
		b.network.neurons.get(1).get(3).weights = new double[] {-0.022468434893751554,0.1578994693951531,0.11948824316631809};
		b.network.neurons.get(1).get(4).weights = new double[] {0.23979857311249841,-0.2951346167827349,-0.08035915747718293};
		b.network.neurons.get(1).get(5).weights = new double[] {0.7214745249119449,-0.20002701501332948,0.37096334347166987};

		
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
}




