package graphs;

import java.util.Arrays;
import java.util.Iterator;

import _main.Main;

public class ForwardStar {
	// number of edges of vertices
	int[] cnt =null;
	// start index of vertex's edge in 'int[] out'
	int[] idx = null;
	// array storing the edge id
	int[] id = null;
	int eno = 0;
	int vno = 0;
	public ForwardStar(int n1, int[] l1, int[] l2) {
		vno = n1;
		eno = l1.length;
		cnt = new int[vno];
		
		for (int i =0; i < eno; i++) {
			cnt[l1[i]]++;
		}
		idx = new int[vno];
		for (int i = 1; i < vno; i++) {
			idx[i] = idx[i-1] + cnt[i - 1];
		}
		id = new int[eno];
		int[] ptr = idx.clone();
		for (int i =0; i < eno; i++) {
			int id1 = ptr[l1[i]]++;
			id[id1] = l2[i];
		}
		Main.px(idx);
		Main.px(id);
		if (true) for (int i =0; i < vno; i++){
			Arrays.sort(id,idx[i], idx[i] + cnt[i]);
		}
	}
	public void print(){
		for (int i =0; i < cnt.length; i++){
			System.out.print(i+": ");
			for (int j =0; j < cnt[i]; j++){
				System.out.print(id[j+idx[i]]+" ");
			}
			System.out.println();
		}
	}
	public boolean contains(int from , int to){
		return Arrays.binarySearch(id, idx[from], idx[from]+cnt[from], to) >= 0;
	}
	public VertexEdges edgedOf(int v1){
		return new VertexEdges(v1);
	}
	public class VertexEdges implements Iterable<Integer> {
		int v1 = 0;
		public VertexEdges(int n1) {
			v1 = n1;
		}
		@Override
		public Iterator<Integer> iterator() {
			return new EdgesIterator(v1);
		}
		public class EdgesIterator implements Iterator<Integer>{
			int v1 = 0;
			int ptr = -1;
			public EdgesIterator(int n1) {
				v1 = n1;
				ptr = idx[v1];
			}
			
			@Override
			public boolean hasNext() {
				if (ptr - idx[v1] >= cnt[v1])
				return false;
				return true;
			}

			@Override
			public Integer next() {
				return id[ptr++];
			}

			@Override
			public void remove() {}
			
		}
		
	}
}
