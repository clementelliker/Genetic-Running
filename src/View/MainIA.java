package View;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.MyKeyListener;
import Controller.MyMouseListener;
import Model.*;

public class MainIA {
	
	public static long maxFramerate = 144;
	static int wdH = 720;
	static int wdW = 720;
	
	public static void main(String[] args) {
		int[] m = new int[] {0,0,0,1,0,0,0,1,1,1,
		 	     0,1,0,0,0,1,0,1,1,1,
	 	 	     0,1,1,1,1,1,0,0,0,1,
			     0,0,1,0,0,0,1,1,0,0,
	 		     1,0,1,0,1,0,0,0,1,0,
	 	             1,0,1,0,1,1,1,0,0,0,
	 		     1,0,1,0,0,1,1,1,1,1,
			     1,0,1,1,0,0,0,0,1,1,
		 	     1,0,0,0,1,1,1,0,1,1,
		 	     1,1,1,0,0,0,0,0,1,1};

	Map m1 = new Map(10, 10, m, 0, 10, 0); 

	      m = new int[] {1,0,0,0,0,0,0,0,1,1,
		 	     1,0,1,1,1,1,1,0,0,0,
	 	 	     1,0,0,0,0,0,1,1,1,0,
			     1,1,1,1,1,0,1,0,0,0,
	 		     1,0,0,0,0,0,1,0,1,1,
	 	             0,0,1,1,1,1,1,0,0,1,
	 		     0,1,1,1,0,0,0,1,0,1,
			     0,1,0,0,0,1,0,1,0,0,
		 	     0,0,0,1,1,1,0,1,1,0,
		 	     1,1,1,1,1,1,0,0,0,0};

	Map m2 = new Map(10, 10, m, 99, 89, (int)Math.PI);

	      m = new int[] {1,0,0,0,0,0,0,0,0,1,
		 	       0,0,1,1,1,1,1,1,0,1,
	 	   	       0,1,0,0,0,0,0,0,0,1,
			       0,1,0,1,1,1,1,1,1,1,
	 		       0,1,0,0,1,0,0,0,1,1,
	 	               0,0,1,0,0,0,1,0,1,1,
	 	  	       1,0,0,1,1,1,1,0,1,1,
			       1,1,0,0,1,0,0,0,1,1,
		 	       1,1,1,0,0,0,1,1,1,1,
		 	       1,1,1,1,1,1,1,1,1,1};

	Map m3 = new Map(10, 10, m, 4, 5, (int)(Math.PI));

	      m = new int[] {1,1,1,1,1,1,0,0,0,1,
		 	       1,1,1,1,1,0,0,1,0,1,
	 	 	       1,1,1,1,1,0,1,1,0,0,
			       1,0,0,0,1,0,1,1,1,0,
	 		       0,0,1,0,0,0,1,0,0,0,
	 	               0,1,1,1,1,1,1,0,1,1,
	 		       0,1,1,0,0,0,1,0,0,1,
			       0,1,0,0,1,0,1,1,0,1,
		 	       0,0,0,1,1,0,0,0,0,1,
		 	       1,1,1,1,1,1,1,1,1,1};

	Map m4 = new Map(10, 10, m, 31, 41, 0);

	      m = new int[] {0,0,0,0,1,0,0,0,1,1,
		 	     0,1,1,0,0,0,1,0,1,1,
	 	 	     0,0,0,1,1,1,1,0,0,1,
			     1,1,0,1,1,1,1,1,0,1,
	 		     0,0,0,1,1,1,1,0,0,1,
	 	             0,1,1,1,1,1,0,0,1,1,
	 		     0,0,0,1,1,0,0,1,1,1,
			     1,1,0,0,1,0,1,1,1,1,
		 	     1,1,1,0,0,0,1,1,1,1,
		 	     1,1,1,1,1,1,1,1,1,1};

	Map m5 = new Map(10, 10, m, 0, 10, 0);

	      m = new int[] {1,0,0,0,0,0,1,1,1,1,
		 	     1,0,1,1,1,0,0,1,1,1,
	 	 	     1,0,0,0,1,1,0,0,1,1,
			     1,1,1,0,0,0,1,0,0,1,
	 		     1,1,1,1,1,0,1,1,0,1,
	 	             1,1,1,1,0,0,1,1,0,0,
	 		     0,0,0,0,0,1,1,1,1,0,
			     0,1,1,1,1,1,1,1,1,0,
		 	     0,0,1,1,0,0,0,1,0,0,
		 	     1,0,0,0,0,1,0,0,0,1};

	Map m6 = new Map(10, 10, m, 5, 15, (int)Math.PI);

	      m = new int[] {0,0,0,0,1,0,0,0,1,1,
		             0,1,1,0,0,0,1,0,1,1,
	 	 	     0,1,1,1,1,1,1,0,0,1,
			     0,1,0,0,0,1,1,1,0,1,
	 		     0,1,0,1,0,0,0,0,0,1,
	 	             0,1,0,1,1,1,1,1,1,1,
	 		     0,1,0,0,0,0,1,1,1,1,
			     0,1,1,1,1,0,0,0,1,1,
		 	     0,1,0,0,0,1,1,0,1,1,
		 	     0,0,0,1,0,0,0,0,1,1};

	Map m7 = new Map(10, 10, m, 1, 0, 0);


	      m = new int[] {1,1,0,0,0,1,1,1,1,1,
		             1,1,0,1,0,1,1,1,1,1,
	 	 	     1,1,0,1,0,0,1,1,1,1,
			     0,0,0,1,1,0,0,1,1,1,
	 		     0,1,1,1,1,1,0,0,0,0,
	 	             0,0,1,1,1,1,1,1,1,0,
	 		     1,0,1,1,1,1,1,1,0,0,
			     1,0,0,1,1,1,1,0,0,1,
		 	     1,1,0,0,1,0,0,0,1,1,
		 	     1,1,1,0,0,0,1,1,1,1};

	Map m8 = new Map(10, 10, m, 49, 59, (int)Math.PI);



	      m = new int[] {0,0,0,0,1,1,0,0,0,1,
		             0,1,1,0,1,0,0,1,0,0,
	 	 	     0,0,1,0,0,0,1,1,1,0,
			     1,0,1,1,1,1,1,0,0,0,
	 		     1,0,1,1,0,0,0,0,1,1,
	 	             0,0,1,1,0,1,1,1,1,1,
	 		     0,1,1,1,0,1,1,0,0,0,
			     0,0,0,1,0,0,0,0,1,0,
		 	     1,1,0,0,1,1,1,1,0,0,
		 	     1,1,1,0,0,0,0,0,0,1};

	Map m9 = new Map(10, 10, m, 1, 0, 0);



	      m = new int[] {1,1,1,0,0,0,0,0,0,1,
		             1,1,0,0,1,1,1,1,0,0,
	 	 	     1,0,0,1,1,1,1,1,1,0,
			     0,0,1,0,0,0,0,0,1,0,
	 		     0,1,1,0,1,1,1,0,1,0,
	 	             0,0,1,0,0,1,1,0,1,0,
	 		     1,0,1,1,0,0,1,0,1,0,
			     1,0,0,1,1,0,1,0,1,0,
		 	     1,1,0,0,1,0,1,0,0,0,
		 	     1,1,1,0,0,0,1,1,1,1};

	Map m10 = new Map(10, 10, m, 7, 8, (int)Math.PI);
	
	
	ArrayList<Map> maps = new ArrayList<Map>();
	maps.add(m1);
	maps.add(m2);
	maps.add(m3);
	maps.add(m4);
	maps.add(m5);
	maps.add(m6);
	maps.add(m7);
	maps.add(m8);
	maps.add(m9);
	maps.add(m10);
	
		//GLOBAL VARIABLES
	
		int[] networkConsti = {5,5,3}; //each number is the amount of neurons of the layer, keep 5 for the 1st and 3 for the last, put anything between
		int nbBots = 1000; //number of bots for each gen
		int nbGen = 100; //number of gens
		int nbSelectedBots = 100; //number of bots selected each gen
	
		Simulation sim = new Simulation(m1, nbBots);
		Window wd = new Window(144, sim, wdW, wdH);
		wd.game.linkWindow(wd);
		sim.linkWindow(wd);
		sim.initBots((m1.startTile%10)*wdW/m1.mapWidth + wdW/(m1.mapWidth*2),(int)(m1.startTile/10)*wdH/m1.mapHeight + wdH/(m1.mapHeight*2), 10, m1.startAngle, networkConsti);
		for(int i = 0; i < nbGen; i++) {
			System.out.println("Generation: " + i + "\n");
			sim.runGen(maps);
			sim.mutateBots(nbSelectedBots);
		}
		
	}
}
