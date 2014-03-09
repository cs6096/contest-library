package miscellaneous;
import java.util.*;
class Geo3 {
	static double eps = 1e-8;
	static int comp(double a){
		if (a < eps) return -1;
		if (a > eps) return 1;
		return 0;
	}
	static double sqr(double a){
		return a *a;
	}
	static double sqrt(double a){
		return a <= 0 ? 0 : Math.sqrt(a);
	}
	static P3 add(P3 a, P3 b){
		return new P3(a.x+b.x,a.y+b.y,a.z+b.z);
	}
	static P3 sub(P3 a, P3 b){
		return new P3(a.x-b.x,a.y-b.y,a.z-b.z);
	}
	static P3 mult(P3 a, double b){
		return new P3(a.x*b,a.y*b,a.z*b);
	}
	static P3 div(P3 a, double b){
		return new P3(a.x/b,a.y/b,a.z/b);
	}
	static P3 det(P3 a, P3 b){
		return new P3(a.y*b.z - a.z*b.y,
				a.z*b.x - a.x*b.z,
				a.x*b.y - a.y*b.x
				);
	}
	static double dot(P3 a, P3 b){
		return a.x*b.x+a.y*b.y+a.z*b.z;
	}
	// returns the mix/ triple product. Return value / 6 is the volume of the
	// tetrahedral defined by the three vectors.
	static double mix(P3 a, P3 b, P3 c){
		return dot(a,det(b,c));
	}
	static double dist(P3 a, P3 b){
		return sqrt(sqr(a.x-b.x) + sqr(a.y-b.y)+sqr(a.z-b.z));
	}
	static boolean eq(P3 a, P3 b){
		return comp(a.x-b.x) == 0
				&& comp(a.y-b.y) == 0
				&& comp(a.z-b.z) == 0;
	}
	static class P3 {
		public double x = 0, y = 0, z = 0;
		P3(){}
		P3(double a, double b, double c){x=a;y=b;z=c;}
		double length(){
			return sqrt(x*x+y*y+z*z);
		}
	}
	static class L3 {
		P3 a, b;
		L3(){}
		L3(P3 k1, P3 k2){a= k1;b=k2;}
	}
	static boolean zero(double n1){
		return 0 == comp(n1);
	}
	// return whether 3 point are on the same line
	static boolean dotsInline(P3 p1, P3 p2, P3 p3){
		return det(sub(p1,p2),sub(p2,p3)).length() < eps;
	}
	// return whether "p" is on the segment "l"
	static boolean dotOnlineIn(P3 p, L3 l){
		return zero(det(sub(p,l.a), sub(p,l.b) ).length() )
				&& (l.a.x-p.x)*(l.b.x-p.x) < eps
				&& (l.a.y-p.y)*(l.b.y-p.y) < eps
				&& (l.a.y-p.y)*(l.b.y-p.y) < eps;
	}
	// return whether "p" is on the segment "l", excluding the 2 endpoints	
	static boolean dotOnlineEx(P3 p, L3 l){
		return dotOnlineIn(p,l)
				&& !eq(p,l.a)
				&& !eq(p,l.b)
				;
	}
	
	static class Plane {
		P3 a = null, b = null, c = null;
		Plane(){}
		Plane(P3 k1, P3 k2, P3 k3){a=k1;a=k2;a=k3;}
		P3 pvec(){
			return det((sub(a,b) ), sub(b, c) );
		}
	}
	// returns the normal vector of the plane formed by the 3 point
	static P3 pvec(P3 s1, P3 s2, P3 s3){
		return det((sub(s1,s2) ), sub(s2, s3) );
	}
	// returns whether d is on the plane formed by a,b,c
	static boolean dotsOnplane(P3 a, P3 b, P3 c, P3 d){
		return zero(dot(pvec(a,b,c), sub(d,a) ) );
	}
	// return whether a point is included in a triangle (inclusive)
	static boolean dotInplaneIn(P3 p, Plane s){
		return zero(det(sub(s.a,s.b), sub(s.a,s.c) ).length()
				- det(sub(p,s.a), sub(p,s.b) ).length()
				- det(sub(p,s.b), sub(p,s.c) ).length()
				- det(sub(p,s.c), sub(p,s.a) ).length()
				);
	}
	//
	static boolean sameSide(P3 p1, P3 p2, Plane s){
		return dot(s.pvec(), sub(p1,s.a)) * dot(s.pvec(), sub(p2,s.a)) > eps;
	}
	
	
}
