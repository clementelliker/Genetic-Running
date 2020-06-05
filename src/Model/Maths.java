package Model;

public class Maths {
	
	public static double dist(double x1, double y1, double x2, double y2) {
		double ac = Math.abs(y2 - y1);
	    double cb = Math.abs(x2 - x1);

	    return Math.hypot(ac, cb);
	}
}
