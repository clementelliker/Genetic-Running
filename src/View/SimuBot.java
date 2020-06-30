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
		
		b.network.neurons.get(0).get(0).weights = new double[] {0.06750682307972466,0.2741357153502623,-0.6529221316196303,0.18722323191241322,0.8487461171190277};
		b.network.neurons.get(0).get(1).weights = new double[] {0.8638733712765649,0.2759564972130681,0.4493441852380873,0.8536367528527252,-0.15417628673067493};
		b.network.neurons.get(0).get(2).weights = new double[] {-0.24249433096211725,-0.5810094989214639,0.5893129803048562,-0.09093362718949609,0.9294504886335314};
		b.network.neurons.get(0).get(3).weights = new double[] {-0.09545106330919413,0.0588908789738178,0.9821227831731203,-0.5860373307314671,0.08124439571392025};
		b.network.neurons.get(0).get(4).weights = new double[] {-0.9371996553703219,0.33616809800136327,0.1372833898148777,-0.15129641112753447,-0.175888756617982};
		b.network.neurons.get(0).get(5).weights = new double[] {1.0609729526731235,0.7771339220130302,-0.08693598465394009,0.52143500574995,-0.18305002948399074};

		b.network.neurons.get(1).get(0).weights = new double[] {0.5022156490894779,-0.36457464286137287,0.16420809321501664};
		b.network.neurons.get(1).get(1).weights = new double[] {0.21831016666953384,0.12581619839361433,-0.5395623941597419};
		b.network.neurons.get(1).get(2).weights = new double[] {-0.224310704448797,0.4170729552678856,1.0941639471325852};
		b.network.neurons.get(1).get(3).weights = new double[] {0.24286846715772273,-0.026686269456477507,1.0795588274721486};
		b.network.neurons.get(1).get(4).weights = new double[] {0.9302414186825685,0.42475684041263195,0.4068680027982307};
		b.network.neurons.get(1).get(5).weights = new double[] {0.5371626395659695,0.6374641873631459,-0.733525572319646};

		
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




