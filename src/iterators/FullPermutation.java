package iterators;

import java.util.Iterator;

import miscellaneous.Gen;

public class FullPermutation implements Iterable<int[]>{
	
	int[] cur = null;
	
	public static FullPermutation instance(int n1){
		FullPermutation fin = new FullPermutation();
		fin.cur = new int[n1];
		for (int i = 0 ; i < n1; i++){
			fin.cur[i] = i;
		}
		return fin;
	}
	
	@Override
	public Iterator<int[]> iterator() {
		return new It();
	}
	
	public class It implements Iterator<int[]> {
		public boolean hasNext = true;
		public boolean advanced = true;
		public void advance(){
			if (advanced) return;
			advanced = true;
			hasNext = Gen.nextPerm(cur);
		}
		@Override
		public boolean hasNext() {
			advance();
			return hasNext;
		}

		@Override
		public int[] next() {
			advanced = false;
			return cur;
		}

		@Override
		public void remove() {}
		
	}



	
}
