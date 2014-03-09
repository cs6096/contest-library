package util;
import java.util.Arrays;

import datastructures.IntL;

public class Arrayz {
		public static int[] sortUnique(int[] l1) {
			int[] copy = l1.clone();
			Arrays.sort(copy);
			int size = 0;
			for (int i = 0; i < copy.length; i++) {
				if (i == 0 || copy[i] != copy[i - 1]) {
					copy[size++] = copy[i];
				}
			}
			return Arrays.copyOf(copy, size);
		}
		public static long[] sortUnique(long[] l1) {
			long[] copy = l1.clone();
			Arrays.sort(copy);
			int size = 0;
			for (int i = 0; i < copy.length; i++) {
				if (i == 0 || copy[i] != copy[i - 1]) {
					copy[size++] = copy[i];
				}
			}
			return Arrays.copyOf(copy, size);
		}
		public static int[][] sortUniqueCount(int[] l1) {
			int[] copy = l1.clone();
			Arrays.sort(copy);
			int[] count = new int[l1.length];
			int size = 0;
			for (int i = 0; i < copy.length; i++) {
				if (i == 0 || copy[i] != copy[i - 1]) {
					copy[size] = copy[i];
					count[size] = 1;
					size++;
				}
				else {
					count[size - 1]++;
				}
			}
			return new int[][]{Arrays.copyOf(copy, size),Arrays.copyOf(count, size)};
		}
		public static int max(int[] l1){
			int fin = Integer.MIN_VALUE;
			for (int e: l1) if (e > fin) fin = e;
			return fin;
		}
		public static long max(long[] l1){
			long fin = Integer.MIN_VALUE;
			for (long e: l1) if (e > fin) fin = e;
			return fin;
		}
		public static double max(double[] l1){
			double fin = l1[0];
			for (double e: l1) if (e > fin) fin = e;
			return fin;
		}
		public static int min(int[] l1){
			int fin = Integer.MAX_VALUE;
			for (int e: l1) if (e < fin) fin = e;
			return fin;
		}
		public static long min(long[] l1){
			long fin = Integer.MAX_VALUE;
			for (long e: l1) if (e < fin) fin = e;
			return fin;
		}
		public static double min(double[] l1){
			double fin = l1[0];
			for (double e: l1) if (e < fin) fin = e;
			return fin;
		}
		public static int[] prefixSum(int[] l1){
			int[] fin = new int[l1.length + 1];
			for (int i = 1;i < l1.length + 1; i++){
				fin[i] += fin[i - 1] + l1[i - 1];
			}
			return fin;
		}
		public static long[] prefixSum(long[] l1){
			long[] fin = new long[l1.length + 1];
			for (int i = 1;i < l1.length + 1; i++){
				fin[i] += fin[i - 1] + l1[i - 1];
			}
			return fin;
		}
		public static double[] prefixSum(double[] l1){
			double[] fin = new double[l1.length + 1];
			for (int i = 1;i < l1.length + 1; i++){
				fin[i] += fin[i - 1] + l1[i - 1];
			}
			return fin;
		}
		
		public static int lowerCount(int[] l1, int n1){
			if (n1 <= l1[0]) return 0;
			if (l1[l1.length - 1] < n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] >= n1) high = mid;
				else if (l1[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public static int lowerCount(long[] l1, long n1){
			if (n1 <= l1[0]) return 0;
			if (l1[l1.length - 1] < n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] >= n1) high = mid;
				else if (l1[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public static int lowerCount(double[] l1, double n1){
			if (n1 <= l1[0]) return 0;
			if (l1[l1.length - 1] < n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] >= n1) high = mid;
				else if (l1[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public static int higherCount(int[] l1, int n1){
			if (n1 >= l1[l1.length - 1]) return 0;
			if (l1[0] > n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] > n1) high = mid;
				else if (l1[mid] <= n1) low = mid;
			}
			return l1.length - high;
		}
		public static int higherCount(long[] l1, long n1){
			if (n1 >= l1[l1.length - 1]) return 0;
			if (l1[0] > n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] > n1) high = mid;
				else if (l1[mid] <= n1) low = mid;
			}
			return l1.length - high;
		}
		public static int higherCount(double[] l1, double n1){
			if (n1 >= l1[l1.length - 1]) return 0;
			if (l1[0] > n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] > n1) high = mid;
				else if (l1[mid] <= n1) low = mid;
			}
			return l1.length - high;
		}
		public int equalCount(int[] l1, int n1){
			return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
		}
		public int equalCount(long[] l1, long n1){
			return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
		}
		public int equalCount(double[] l1, double n1){
			return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
		}
		public Integer[] objectOrder(int n1){
			Integer[] fin = new Integer[n1];
			for (int i =  0;  i < n1; i++){
				fin[i] = i;
			}
			return fin;
		}
		public int[] intOrder(int n1){
			int[] fin = new int[n1];
			for (int i =  0;  i < n1; i++){
				fin[i] = i;
			}
			return fin;
		}
	}