package _main;
import iterators.FullPermutation;
import iterators.Order;

import java.math.BigInteger;
import java.util.Arrays;

import classicproblems.*;
import miscellaneous.*;
import numbertheory.NT;
import datastructures.*;
import experimental.SuffixArray;
import graphs.*;
import strings.PolynomialHash;
import util.Modz;
import util.Multiplyz;
public class _Test {
	public static void main(String[] args) throws Exception {
		int n1 = 20;
		SegmentTree t1 = new SegmentTree(n1) {
			
			@Override
			public void refreshNodeValue(int nodeIndex) {
				nodeValue[nodeIndex] = mergedProductValue(nodeValue[(nodeIndex << 1) + 1], nodeValue[(nodeIndex << 1) + 2]);
			}
			
			@Override
			public long mergedProductValue(long value1, long value2) {
				return value1 + value2;
			}
		};
		
		for (int i = 0 ; i < n1; i++){
			t1.setArrayValueAtIndex(i, i + 1);
		}
		System.out.println(t1);
		System.out.println(t1.prefixProductString());
		
	}
	static void suffixArray(){
		String qq = "qasdfasdfwerwerfwefsdf";
		StringBuilder fin = new StringBuilder();
		int n1 = 20;
		for (int i = 0; i < n1; i++) {
			int k1 = (int) (Math.random() * 7);
			char c1 = (char) ('a' + k1);
			fin.append(c1);
		}
		qq = fin.toString();
		long start = System.currentTimeMillis();
		SuffixArray s1 = new SuffixArray(qq);
		System.out.println((System.currentTimeMillis() - start) * 0.001);
		boolean allok = true;
		for (int i = 0; i < s1.rank.length; i++) {
			String q1 = qq.substring(s1.rank[i]);
//			 System.out.println(q1);
			if (i + 1 < s1.rank.length) {
				// System.out.println(s1.rank[i]);
				// System.out.println(s1.rank[i+1]);
				String q2 = qq.substring(s1.rank[i + 1]);
				if (q1.compareTo(q2) > 0) {
					System.out.println("BAD");
					allok = false;
				}
			}
		}
		System.out.println("All ok: " + allok);
		System.out.println("done");
		if (true) return;
	}
	static void px(Object ... objects){
		System.out.println(Arrays.deepToString(objects));
	}
}





