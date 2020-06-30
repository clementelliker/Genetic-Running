package Model;

public class Maths {
	
	public static double dist(double x1, double y1, double x2, double y2) {
		double ac = Math.abs(y2 - y1);
	    double cb = Math.abs(x2 - x1);

	    return Math.hypot(ac, cb);
	}
	
	public static double pow(double x, int po) {
		if(po == 0) return 1;
		if(po < 0) return 0;
		double ret = 1;
		for(int i = 0; i < po; i++) {
			ret *= x;
		}
		return ret;
	}
	
	public static double sin(double x) {
		return x - pow(x,3)/6 + pow(x,5)/120 - pow(x,7)/5040; 
	}
	
	public static double cos(double x) {
		return 1 - pow(x,2)/2 + pow(x,4)/24 - pow(x,6)/720; 
	}
}
