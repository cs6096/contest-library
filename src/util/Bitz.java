
package util;

import java.util.*;


public class Bitz {
//	public static void main(String[] args){
//		for (long e: front){
//			System.out.println(binString64(e));
//		}
//		System.out.println();
//		for (long e: back){
//			System.out.println(binString64(e));
//		}
//	}
	// front means logical front, aka the lowest portion,
	// not the visual front(thats actually back)
	public static long[] front = new long[65];
	public static long[] back = new long[65];
	public static long empty = 0;
	static {
		long cur = 0;
		for (int i =0; i < back.length; i++){
			back[back.length - i - 1] = ~cur;
			front[i] = cur;
			cur |= 1l << i;
		}
	}
	public static long addBitAt(long set, int idx){
		return set | (1l << idx);
	}
	public static long removeBitAt(long set, int idx){
		return set & ~(1l << idx);
	}
	public static boolean hasBitAt(long set, int idx){
		return (set & (1 << idx)) != 0;
	}
	public static int size(long set){
		return Long.bitCount(set);
	}
	public static String binString64(long n1){
		return String.format("%64s", Long.toBinaryString(n1)).replace(' ', '0');
	}
}
