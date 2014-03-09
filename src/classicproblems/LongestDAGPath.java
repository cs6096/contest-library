package classicproblems;
import java.util.*;
class LongestDAGPath {
	public static void main(String[] args){
		int n1 = 5;
		ArrayList<Integer>[] al = new ArrayList[n1];
		for (int i = 0 ; i < al.length; al[i++] = new ArrayList());
		boolean[] notStart = new boolean[n1];
		for (int i = 0; i < n1; i++){
			for (int e: al[i]){
				notStart[e] = true;
			}
		}
		boolean[] ex = new boolean[n1];
		int[] max = new int[n1];
		int[] from = new int[n1];
		int max1 = Integer.MIN_VALUE;
		int id1 = -1;
		for (int i = 0 ; i < n1; i++){
			if (!notStart[i]){
				int curmax = dfs(al,ex,max,from,i);
				if (curmax > max1){
					max1 = curmax;
					id1 = i;
				}
			}
		}
		System.out.println(max1);
		ArrayList<Integer> fin = new ArrayList();
		for (;;){
			if (id1 == -1) break;
			fin.add(id1+1);
			id1 = from[id1];
		}
		Collections.reverse(fin);
		for (int i = 0 ; i < fin.size(); i++){
			if (i != 0 ){
				System.out.print(" ");
			}
			System.out.print(fin.get(i));
		}
		System.out.println();
	}
	static int dfs(ArrayList<Integer>[] al, boolean[] ex, int[] max, int[] from, int start){
		if (ex[start]) return max[start];
		int max1 = 1;
		int id = -1;
		for (int e : al[start]){
			int curmax = dfs(al,ex,max,from,e)+1;
			if (curmax > max1){
				max1 = curmax;
				id = e;
			}
		}
		ex[start] = true;
		max[start] = max1;
		from[start] = id;
		return max1;
	}
}
