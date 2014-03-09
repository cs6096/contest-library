package experimental;

import java.util.*;

public class SuffixArray {
	public String str1 = null;
	public int[] rank = null;
	public SuffixArray(String s1) {
		str1 = s1;
		int len = 1;
		rank = new int[str1.length()];
		for (int i = 0; i < str1.length(); i++) {
			rank[i] = i;
		}
		long[] id = new long[str1.length()];
		for (int i = 0; i < str1.length(); i++) {
			id[i] = str1.charAt(i) - 'a' + 1;
		}
		long[] copy = new long[id.length];
		for (;;) {
			
			for (int i = 0; i < id.length; i++) {
				copy[i] = id[i];
			}
			Arrays.sort(copy);
			// System.out.println(Arrays.toString(copy));
			int unisize = 0;
			for (int i = 0; i < copy.length; i++) {
				if (i == 0 || copy[i] != copy[i - 1]) {
					copy[unisize++] = copy[i];
				}
			}
			// System.out.println("id: "+Arrays.toString(id));
			// System.out.println("unique: "+Arrays.toString(Arrays.copyOf(copy,
			// unisize)));
			for (int i = 0; i < id.length; i++) {
				id[i] = Arrays.binarySearch(copy, 0, unisize, id[i]) + 1l;
			}
			// System.out.println("id sorted: "+Arrays.toString(id));
			// System.out.println();
			len *= 2;
			
			int half = len / 2;
			if (0 + half >= str1.length()) break;
			for (int i = 0; i < id.length; i++) {
				id[i] = id[i] << 31;
				if (i + half < id.length) id[i] += id[i + half];
			}
		}
		// System.out.println("id fin: "+Arrays.toString(id));
		for (int i = 0; i < id.length; i++) {
			rank[(int) (id[i] - 1)] = i;
		}
	}
	
	
	public void printSuffix() {
		for (int e : rank) {
			System.out.println(str1.substring(e));
		}
		System.out.println();
	}
}
