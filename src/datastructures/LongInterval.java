package datastructures;

class LongInterval {
	long[] sum = null;
	LongInterval (int[] l1){
		sum = new long[l1.length+1];
		long cur = 0;
		for (int i = 1; i <= l1.length ; i++){
			cur += (long)l1[i-1];
			sum[i] = cur;
		}
	}
	long get(int n1){
		return sum[n1];
	}
	long range(int left, int right){
		return get(right) - get(left);
	}
}
