package Model;

public class Bot extends Player{
	
	public NeuralNetwork network;
	public int survivalTime;
	public boolean lapFinished;
	
	public Bot(int x, int y, int hBR, int angle, int[] networkConsti) {
		super(x,y,hBR,angle);
		this.survivalTime = 0;
		this.network = new NeuralNetwork(networkConsti);
	}
	
	public Bot(int x, int y, int hBR, int angle, Bot b) {
		super(x,y,hBR,angle);
		this.survivalTime = 0;
		this.network = b.network.copy();
		this.lapFinished = false;
	}
	
	public void getInput() {
		double[] dists = new double[5];
		for(int i = 0; i < 5; i++) {
			dists[i] = this.wallDists[i][0];
		}
		int input = this.network.getOutput(dists);
		if(input == 0) {
			this.qPressed();
		}else if(input == 2) {
			this.dPressed();
		}
	}
}
