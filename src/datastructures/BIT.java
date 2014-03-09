package datastructures;
import java.util.*;
public class BIT {
	int[] vs;
	public BIT (int n){
		vs = new int[n+1];
	}
	/*
	 * Add "n1" to the index "idx".
	 */
	public void add(int idx, int n1){
		for (int i = idx + 1; i < vs.length; i += i & -i){
			vs[i] += n1;
		}
	}
	public int sum(int t){
		return sum(0, t);
	}
	/*
	 * Sum of first t index minus sum of first s index.
	 */
	public int sum(int s, int t){
		if (s > 0) return sum(0,t)-sum(0,s);
		int res = 0;
		for (int i = t; i > 0; i -= i & -i){
			res += vs[i];
		}
		return res;
	}
	@Override
	public String toString(){
		List<Integer> fin = new ArrayList();
		for (int i =0; i < vs.length-1; i++){
			fin.add(sum(0,i+1)-sum(0,i));
		}
		return fin.toString();
	}
	public String sumString(){
		List<Integer> fin = new ArrayList();
		for (int i =0; i < vs.length-1; i++){
			fin.add(sum(0,i+1));
		}
		return fin.toString();
	}
}
