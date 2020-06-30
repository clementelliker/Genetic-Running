package Model;

public class Chrono {
	
	/*Reference point for capping framerate:
	 * 1000 ms = 1 sec
	 * 60Hz: 17ms
	 * 144Hz: 7ms
	 * 
	 * 
	 * 
	 */
	
	public long time;
	public double maxElapsingtime;
	
	
	public Chrono(double maxElapsingtime) {
		this.maxElapsingtime = maxElapsingtime;
		this.time = System.currentTimeMillis();
	}
	
	public Chrono() {
		this.time = System.currentTimeMillis();
	}
	
	public double stop() {
		return System.currentTimeMillis() - this.time;
	}
	
	public boolean elapsedMaxTime() {
		return System.currentTimeMillis() - this.time >= this.maxElapsingtime;
	}
}
