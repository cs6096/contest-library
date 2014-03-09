package miscellaneous;
import java.util.Arrays;

public class Gen {
		private static int greyCode(int n1){
			return n1 ^ (n1 >> 1);
		}
		/*
		 * Advances l1 to next lexicographical higher combination.
		 * cap is the largest value allowed for one index.
		 * return false 
		 */
		public static boolean nextComb(int[] l1, int cap){
			for (int ptr = l1.length-1;;){
				if (ptr < 0) return false;
				if (l1[ptr] == cap - 1){
					l1[ptr] = 0;
					ptr--;
				}
				else {
					l1[ptr]++;
					break;
				}
			}
			return true;
		}
		/*
		 * Advances l1 to next lexicographical higher permutation.
		 * 1
		 * Find the highest index i such that s[i] < s[i+1].
		 * If no such index exists, the permutation is the last permutation.
		 * 2
		 * Find the highest index j > i such that s[j] > s[i].
		 * Such a j must exist, since i+1 is such an index.
		 * 3
		 * Swap s[i] with s[j].
		 * 4
		 * Reverse all the order of all of the elements after index i
		 */
		public static void swap(int[] l1, int a, int b){
			int k1 = l1[a];l1[a]=l1[b];l1[b]=k1;
		}
		public static void rev(int[] l1, int a, int b){
			for (int i = 0; i < (b-a+1)/2;i++) swap(l1,a+i,b-i);
		}
		public static boolean nextPerm(int[] l1) {
			for (int i = l1.length- 2; i >=0; i--) {
				if (l1[i] < l1[i + 1]){
					for (int k = l1.length - 1; k>=0;k--){
						if (l1[k]>=l1[i]){
							swap(l1,i,k);
							rev(l1,i+1,l1.length-1);
							return true;
						}
					}
				}
			}
			rev(l1,0,l1.length-1);
			return false;
		}

		public static int[] permInv(int[] l1){
			int[] fin = new int[l1.length];
			for (int i = 0; i< l1.length;i++){
				fin[l1[i]]=i;
			}
			return fin;
		}
		
	}