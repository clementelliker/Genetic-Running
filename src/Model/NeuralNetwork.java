package Model;

import java.util.ArrayList;

public class NeuralNetwork {
	
	public ArrayList<ArrayList<Neuron>> neurons;
	
	public NeuralNetwork(int[] constitution) {
		ArrayList<ArrayList<Neuron>> neurons = new ArrayList<ArrayList<Neuron>>();
		for(int i = 0; i < constitution.length - 1; i++) {
			neurons.add(new ArrayList<Neuron>());
			for(int j = 0; j < constitution[i]+1; j++) {
				neurons.get(i).add(new Neuron(constitution[i+1]));
			}
		}
		neurons.add(new ArrayList<Neuron>());
		for(int i = 0; i < constitution[constitution.length-1]; i++) {
			neurons.get(constitution.length-1).add(new Neuron(0));
		}
		this.neurons = neurons;
	}
	
	public void displayNetwork() {
		for(int i = 0; i < this.neurons.size(); i++) {
			for(int j = 0; j < this.neurons.get(i).size(); j++) {
				for(int k = 0; k < this.neurons.get(i).get(j).weights.length; k++) {
					System.out.print(this.neurons.get(i).get(j).weights[k] + "   ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public int getOutput(double[] inputs) {
		if(inputs.length != this.neurons.get(0).size()-1) {
			//System.out.println("Inputs not matching amout of 1st layer neurons");
			return -1;
		}else {
			this.neurons.get(0).get(0).value = 1;
			//System.out.println("Layer num: 0");
			for(int i = 1; i < this.neurons.get(0).size(); i++) {
				this.neurons.get(0).get(i).value = inputs[i-1];
				//System.out.println("Neuron num: " + (i-1) + " value: " + inputs[i-1]);
			}
			for(int i = 1; i < this.neurons.size() - 1; i++) {
				//System.out.println("Layer num: " + i);
				this.neurons.get(i).get(0).value = 1;
				for(int j = 1; j < this.neurons.get(i).size(); j++) {
					//System.out.print("Neuron num: " + (j-1) + " value: ");
					this.neurons.get(i).get(j).value = getNeuronValue(this.neurons.get(i-1), j-1);
				}
			}
			//System.out.println("Layer num: " + (this.neurons.size()-1));
			for(int i = 0; i < this.neurons.get(this.neurons.size()-1).size(); i++) {
				//System.out.print("Neuron num: " + i + " value: ");
				this.neurons.get(this.neurons.size()-1).get(i).value = getNeuronValue(this.neurons.get(this.neurons.size()-2), i);
			}
		}
		//System.out.print("output: ");
		return max(this.neurons.get(this.neurons.size()-1));
	}
	
	private int max(ArrayList<Neuron> neurons) {
		int max = 0;
		if(neurons.size() == 0) {
			return max;
		}
		for(int i = 1; i < neurons.size(); i++) {
			if(neurons.get(i).value > neurons.get(max).value) max = i;
		}
		return max;
	}

	public static double getNeuronValue(ArrayList<Neuron> neuronList, int index) {
		double ret = 0;
		for(int i = 0; i < neuronList.size(); i++) {
			ret += neuronList.get(i).value * neuronList.get(i).weights[index];
		}
		//System.out.println(sigmoidF(ret));
		return sigmoidF(ret);
	}
	
	public static double sigmoidF(double b) {
		return 1/(1 + Math.pow(Math.E, -b));
	}
}
