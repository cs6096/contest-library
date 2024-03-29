package miscellaneous;
import java.util.*;
/*
 * For random distributed data:
 * Radix sort is the fastest.
 * Quick sort is the second.
 * Counting sort is the third.
 * Merge sort is the fourth.
 */
public class Sort {

	static Random rnd = new Random();

	public static void qSort(int[] a, int low, int high) {
		if (low > high) return;
		int x = a[low + rnd.nextInt(high - low + 1)];
		int i = low;
		int j = high;
		while (true) {
			while (a[i] < x)
				++i;
			while (x < a[j])
				--j;
			if (i > j) break;
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			++i;
			--j;
			if (i > j) break;
		}
		qSort(a, low, j);
		qSort(a, i, high);
	}

	public static void qSort2(int[] a, int low, int high) {
		if (high - low > 1) {
			int p = randomizedPartition(a, low, high);
			qSort2(a, low, p);
			qSort2(a, p, high);
		}
	}

	static int randomizedPartition(int[] a, int low, int high) {
		swap(a, low + rnd.nextInt(high - low), high - 1);
		int x = a[high - 1];
		int i = low - 1;
		for (int j = low; j < high; j++)
			if (a[j] <= x) swap(a, ++i, j);
		return i;
	}

	static void swap(int[] a, int i, int j) {
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}

	public static void mergeSort(int[] a, int low, int high) {
		if (low + 1 < high) {
			int mid = (low + high) >>> 1;
			mergeSort(a, low, mid);
			mergeSort(a, mid, high);

			int size = high - low;
			int[] b = new int[size];
			int i = low;
			int j = mid;
			for (int k = 0; k < size; k++) {
				if (j >= high || i < mid && a[i] < a[j]) {
					b[k] = a[i++];
				}
				else {
					b[k] = a[j++];
				}
			}
			System.arraycopy(b, 0, a, low, size);
		}
	}

	public static void bubbleSort(int[] a) {
		for (int i = 0; i + 1 < a.length; i++) {
			for (int j = 0; j + 1 < a.length; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	public static void selectionSort(int[] a) {
		int n = a.length;
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = i;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[p[i]] > a[p[j]]) {
					swap(p, i, j);
				}
			}
		}
		int[] b = a.clone();
		for (int i = 0; i < n; i++)
			a[i] = b[p[i]];
	}

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
				}
			}
		}
	}

	public static void countingSort(int[] a) {
		int max = 0;
		for (int x : a) {
			max = Math.max(max, x);
		}
		int[] cnt = new int[max + 1];
		for (int x : a) {
			++cnt[x];
		}
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i - 1];
		}
		int n = a.length;
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[--cnt[a[i]]] = a[i];
		}
		System.arraycopy(b, 0, a, 0, n);
	}

	public static void radixSort(int[] a) {
		final int d = 8;
		final int w = 32;
		int[] t = new int[a.length];
		for (int p = 0; p < w / d; p++) {
			int[] cnt = new int[1 << d];
			// the next three for loops implement counting-sort
			for (int i = 0; i < a.length; i++)
				++cnt[((a[i] ^ Integer.MIN_VALUE) >>> d * p) & ((1 << d) - 1)];
			for (int i = 1; i < 1 << d; i++)
				cnt[i] += cnt[i - 1];
			for (int i = a.length - 1; i >= 0; i--)
				t[--cnt[((a[i] ^ Integer.MIN_VALUE) >>> d * p) & ((1 << d) - 1)]] = a[i];
			System.arraycopy(t, 0, a, 0, a.length);
		}
	}

	// random test
	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 1000; step++) {
			int n = rnd.nextInt(100) + 1;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = rnd.nextInt(1000);
			}
			int[] s = a.clone();
			Arrays.sort(s);

			int[] b = a.clone();
			bubbleSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();

			b = a.clone();
			selectionSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();

			b = a.clone();
			insertionSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();

			b = a.clone();
			countingSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
		}

		for (int step = 0; step < 10; step++) {
			int n = rnd.nextInt(50000) + 100000;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = rnd.nextInt();
			}
			int[] s = a.clone();
			Arrays.sort(s);

			int[] b = a.clone();
			qSort(b, 0, b.length - 1);
			if (!Arrays.equals(s, b)) throw new RuntimeException();

			b = a.clone();
			qSort2(b, 0, b.length);
			if (!Arrays.equals(s, b)) throw new RuntimeException();

			b = a.clone();
			mergeSort(b, 0, b.length);
			if (!Arrays.equals(s, b)) throw new RuntimeException();

			b = a.clone();
			radixSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
		}
	}
}