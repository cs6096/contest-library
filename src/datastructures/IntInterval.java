package datastructures;

class IntInterval {
	int[] sum = null;
	IntInterval (int[] l1){
		sum = new int[l1.length+1];
		int cur = 0;
		for (int i = 1; i <= l1.length ; i++){
			cur += l1[i-1];
			sum[i] = cur;
		}
	}
	int get(int n1){
		return sum[n1];
	}
	int range(int left, int right){
		return get(right) - get(left);
	}
}
