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
		
		Bot b = new Bot(500,325, 10, 0, new int[] {5,5,3});
		
		b.network.neurons.get(0).get(0).weights = new double[] {0.5344543991848725,   -0.26426990554190066,   0.46070738690291924,   0.5841072644927143,   -0.6284354443213449};
		b.network.neurons.get(0).get(1).weights = new double[] {0.01453184196789703,   -0.103567197545271,   0.50849435336433,   -0.3783806071745155,   0.8483303503940163};
		b.network.neurons.get(0).get(2).weights = new double[] {0.6535185801861707,   -0.604598856004757,   -0.42378413268493453,   -0.3195372211171794,   0.07745269253929976};
		b.network.neurons.get(0).get(3).weights = new double[] {-0.6396346161812858,   0.5326463603090805,   -0.41850024263786945,   0.2587898136158553,   -0.24174843291813075};
		b.network.neurons.get(0).get(4).weights = new double[] {0.4492545271746191,   0.14795849637940628,   -0.5212467680375843,   -0.9124198113248172,   -0.6418215721505032};
		b.network.neurons.get(0).get(5).weights = new double[] {-0.16219929926307608,   0.6861803339957422,   -0.5748216630772194,   0.08388176637152855,   0.23105755454241383};
		
		b.network.neurons.get(1).get(0).weights = new double[] {0.4380014721061951,   0.1773449185009044,   -0.5259227511041307};
		b.network.neurons.get(1).get(1).weights = new double[] {-0.18474785750053702,   -0.5751047071714477,   0.3263033312469217   };
		b.network.neurons.get(1).get(2).weights = new double[] {-0.4296512665674559,   -0.9308823525354255,   0.9557167770706496};
		b.network.neurons.get(1).get(3).weights = new double[] {0.8057906868703661,   0.9289832863390992,   -0.1455614096192943   };
		b.network.neurons.get(1).get(4).weights = new double[] {0.588747097822421,   -0.8427874695898598,   -0.3517742582683432};
		b.network.neurons.get(1).get(5).weights = new double[] {0.4246689774049279,   0.4747680337170732,   -0.8021306431732178};
		
		
		
		Game game = new Game(new Map(10,10, map), b);
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
}
