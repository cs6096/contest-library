package geometry2d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import miscellaneous.Vec;

class Geo2X {
		public static double eps = 1e-8;
		// Return the corrected sign.
		public static int sign(double n1) {
			if (Math.abs(n1) <= eps) return 0;
			if (n1 > 0) return 1;
			return -1;
		}
		// Return the corrected comparison.
		public static int comp(double n1, double n2) {
			return sign(n1 - n2);
		}
		// Return the sum of square of the arrays elements.
		public static double norm(double[] l1){
			double fin = 0;
			for (double e: l1){
				fin += e*e;
			}
			return Math.sqrt(fin);
		}
		// Return the dist between p1 and p2. 
		public static double dist(double[] p1, double[] p2){
			double kx = p1[0] - p2[0];
			double ky = p1[1] - p2[1];
			return Math.sqrt(kx*kx+ky*ky);
		}
		
		public static double dist(double x1, double y1, double x2, double y2){
			double kx = x1 - x2;
			double ky = y1 - y2;
			return Math.sqrt(kx*kx+ky*ky);
		}
		
		public static double ang(double[] p1){
			double k1 = Math.atan2(p1[1], p1[0]);
			k1 += Math.PI*2;
			k1 = k1 % (Math.PI*2);
			return k1;
		}
		
		public static double ang(double[] p1, double[] p2){
			double kx = p2[0]-p1[0];
			double ky = p2[1]-p1[1];
			double k1 = Math.atan2(ky, kx);
			k1 += Math.PI*2;
			k1 = k1 % (Math.PI*2);
			return k1;
		}
		
		public static double ang(double[] a1, double[] b1, double[] b2){
			double[] vec1 = {b1[0]-a1[0],b1[1]-a1[1]};
			double[] vec2 = {b2[0]-a1[0],b2[1]-a1[1]};
			double fin = ang(vec1)-ang(vec2);
			if(fin <0) fin *= -1;
			if (sign(fin-Math.PI)>0) fin = 2*Math.PI - fin;
			return fin;
		}
		
		public static double canonDiffAng(double[] a1, double[] a2, double[] b1, double[] b2){
			double ang1 = ang(a1,a2);
			double ang2 = ang(b1,b2);
			double f1 = (ang2 - ang1+Math.PI*2)%Math.PI;
			if (f1 > Math.PI/2){
				f1 = Math.PI - f1;
			}
			
			return f1;
		}
		
		public static double[] midPoint(double[] p1, double[] p2){
			double[] fin = {p1[0]+p2[0],p1[1]+p2[1]};
			fin[0]*=0.5;
			fin[1]*=0.5;
			return fin;
		}
		
		public static double[] projPoint(double[] k1, double[] k2, double[] point){
			double[] lineVec = Vec.diff(k1, k2);
			double[] pointVec = Vec.diff(point, k2);
			double[] lineUnit = unit(lineVec);
			double pointLength = norm(pointVec);
			double minusLength = Math.cos(canonDiffAng(k1,k2,point,k2))*pointLength;
			double[] fin = {k2[0] + lineUnit[0]*minusLength,k2[1] + lineUnit[1]*minusLength};
			return fin;
		}
		
		public static double[] projPoint2(double[] k1, double[] k2, double[] point){
			double[] lineVec = Vec.diff(k2, k1);
			double[] pointVec = Vec.diff(k2, point);
			double[] lineUnit = unit(lineVec);
			double pointLength = norm(pointVec);
			double cosine = (lineVec[0]*pointVec[0]+lineVec[1]*pointVec[1])/(norm(lineVec)*norm(pointVec) );
			double minusLength = cosine*pointLength;
			double[] fin = {k2[0] - lineUnit[0]*minusLength,k2[1] - lineUnit[1]*minusLength};
			return fin;
		}
		
		public static double[] unit(double[] p1){
			double norm = Math.sqrt(p1[0]*p1[0]+p1[1]*p1[1]);
			double[] fin = {p1[0]/norm, p1[1]/norm};
			return fin;
		}
		
		public static double[] lineRep(double[] p1, double[] p2){
			double a = p1[0]- p2[0];
			double b = p1[1]- p2[1];
			return new double[]{b, -a, b*p1[0]-a*p1[1]};
		}
		
		public static double[] perpendicular(double[] l1, double[] p2){
			return new double[]{-l1[1],l1[0],-l1[1]*p2[0]+l1[0]*p2[1]};
		}
		
		public static double[] sectPoint(double[] l1, double[] l2){
			double det = l1[0]*l2[1]-l1[1]*l2[0];
			double xtop = l1[2]*l2[1]-l2[2]*l1[1];
			double ytop = l1[2]*l2[0]-l2[2]*l1[0];
			return new double[]{xtop/det, -ytop/det};
		}
		public static double[] sectPoint(double[] p1, double[] p2, double[] p3, double[] p4){
			double[] l1 = lineRep(p1, p2);
			double[] l2 = lineRep(p3, p4);
			double det = l1[0]*l2[1]-l1[1]*l2[0];
			double xtop = l1[2]*l2[1]-l2[2]*l1[1];
			double ytop = l1[2]*l2[0]-l2[2]*l1[0];
			return new double[]{xtop/det, -ytop/det};
		}

		public static boolean par(double[] p1, double[] p2, double[] p3, double[] p4){
			double kx1 = p1[0] - p2[0];
			double ky1 = p1[1] - p2[1];
			double kx2 = p3[0] - p4[0];
			double ky2 = p3[1] - p4[1];
			if (Geo2X.sign(kx1*ky2 - kx2*ky1) == 0){
				return true;
			}
			return false;
		}
		public static double sarea(double a, double b, double coseta){
			return 0.5*a*b*Math.sin(coseta);
		}
		
		public static double lcos(double a, double b, double coseta){
			double k1 = a*a+b*b-2*a*b*Math.cos(coseta);
			return Math.sqrt(k1);
		}
		
		public static int ccw(double[] p1, double[] p2, double[] p3){
			return sign((p2[0]-p1[0])*(p3[1]-p1[1])-(p2[1]-p1[1])*(p3[0]-p1[0]));
		}
		
		public static ArrayList<double[]> convexHull(double[][] points){
			Arrays.sort(points, new SortX());
			ArrayList<double[]> top = new ArrayList();
			top.add(points[0]);
			top.add(points[1]);
			for (int i = 2; i < points.length; i++){
				double[] cur = points[i];
				for (;;){
					if (top.size()<2) break;
					if (ccw(top.get(top.size()-2),top.get(top.size()-1),cur) <= 0){
						top.remove(top.size()-1);
					}
					else break;
				}
				top.add(cur);
			}
			ArrayList<double[]> bot = new ArrayList();
			bot.add(points[points.length-1]);
			bot.add(points[points.length-2]);
			for (int i = points.length-3; i >= 0; i--){
				double[] cur = points[i];
				for (;;){
					if (bot.size()<2) break;
					if (ccw(bot.get(bot.size()-2),bot.get(bot.size()-1),cur) <= 0){
						bot.remove(bot.size()-1);
					}
					else break;
				}
				bot.add(cur);
			}
			ArrayList<double[]> fin = new ArrayList();
			for (int i = 0; i< top.size()-1; i++){
				fin.add(top.get(i));
			}
			for (int i = 0; i< bot.size()-1; i++){
				fin.add(bot.get(i));
			}
			return fin;
		}
		
		public static class SortX implements Comparator<double[]>{
			@Override
			public int compare(double[] l1, double[] l2) {
				if (l1[0] > l2[0]) return 1;
				if (l1[0] < l2[0]) return -1;
				if (l1[1] > l2[1]) return 1;
				if (l1[1] < l2[1]) return -1;
				return 0;
			}
		}
	}