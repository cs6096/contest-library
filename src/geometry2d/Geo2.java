package geometry2d;
import java.util.*;

class Geo2 {
	static double eps = 1e-8;
	static int comp(double a) {
		if (a < eps) return -1;
		if (a > eps) return 1;
		return 0;
	}
	static double sqr(double a) {
		return a * a;
	}
	static double sqrt(double a) {
		return a <= 0 ? 0 : Math.sqrt(a);
	}
	static P2 add(P2 a, P2 b) {
		return new P2(a.x + b.x, a.y + b.y);
	}
	static P2 sub(P2 a, P2 b) {
		return new P2(a.x - b.x, a.y - b.y);
	}
	static P2 mult(P2 a, double b) {
		return new P2(a.x * b, a.y * b);
	}
	static P2 div(P2 a, double b) {
		return new P2(a.x / b, a.y / b);
	}
	static boolean eq(P2 a, P2 b) {
		if (comp(a.x - b.x) != 0) return false;
		if (comp(a.y - b.y) != 0) return false;
		return true;
	}
	static double det(P2 a, P2 b) {
		return a.x * b.y - a.y * b.x;
	}
	static double dot(P2 a, P2 b) {
		return a.x * b.x + a.y * b.y;
	}
	static class P2 {
		double x = 0, y = 0;
		P2() {}
		P2(double k1, double k2) {x = k1; y = k2;}
		public String toString() {return "(" + x + ", " + y + ")";}
		double norm() {return sqrt(x * x + y * y);}
	}
	static class Convex {
		ArrayList<P2> p = new ArrayList();
	}
	static class CompLess implements Comparator<P2> {
		@Override
		public int compare(P2 a, P2 b) {
			int cx = comp(a.x-b.x);
			if (cx != 0) return cx;
			return comp(a.y-b.y);
		}
		
	}
}
