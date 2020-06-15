package Model;

import java.util.Random;

public class Neuron {

	public double[] weights;
	public double value;
	
	public static Random seed = new Random();
	
	public Neuron(int i) {
		this.weights = new double[i];
		for(int j = 0; j < i; j++) {
			this.weights[j] = (seed.nextDouble()*2) - 1;
		}
	}

	public Neuron(int length, boolean b) {
		this.weights = new double[length];
	}
	
	
	
}
