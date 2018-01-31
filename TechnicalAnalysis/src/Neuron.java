
public class Neuron {
	private Neuron[] prev;
	private double[] synapses;
	private ActivationFunction af;
	private double sum;
	private double value;
	public Neuron(Neuron[] prev, double[] synapses, ActivationFunction af) {
		this.prev = prev;
		this.synapses = synapses;
		this.af = af;
	}
	public double[] getSynapses() {
		return synapses;
	}
	public void setSynapses(double[] synapses) {
		this.synapses = synapses;
	}
	public Neuron[] getPrev() {
		return prev;
	}
	public void setPrev(Neuron[] prev) {
		this.prev = prev;
	}
	public double getValue() {
		return value;
	}
	public double getSum() {
		return sum;
	}
	public void sumUp() {
		sum = 0.0;
		for(int i = 0; i < prev.length; i++) {
			sum += prev[i].getValue()*synapses[i];
		}
		value = af.activate(sum);
	}
}
