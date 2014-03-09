package classicproblems;
import java.util.*;
class MinCoin {
	// given infinite coins of a[1] ... a[n] values, what is the min
	// number of of coins that its sum equals to some k?
	// time complexity: O (len(a))
	int[] a = null;
	int[] temp = null;
	MinCoin (int[] l1){
		a = l1;
		Arrays.sort(a);
		temp = new int[l1.length];
		
	}
	int minNeeded(int k1){
		int fin = 0;
		Arrays.fill(temp, 0);
		for (int i = a.length - 1; i >= 0; i--){
			temp[i] = k1 / a[i];
			fin += temp[i];
			k1 = k1 % a[i];
		}
		return fin;
	}
}
