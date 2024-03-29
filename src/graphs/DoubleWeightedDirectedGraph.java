package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

import datastructures.DoubleL;
import datastructures.IntL;
import datastructures.LongL;

public class DoubleWeightedDirectedGraph {
	public IntL[] adjacencyList;
	public IntL fromList = new IntL();
	public IntL toList = new IntL();
	public DoubleL weightList = new DoubleL();
	int nodeNo;
	int edgeNo = 0;

	public DoubleWeightedDirectedGraph(int nodeNo) {
		this.nodeNo = nodeNo;
		adjacencyList = new IntL[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new IntL();
		}
	}

	public void addEdge(int from, int to, double weight) {
		int edgeId = edgeNo;
		fromList.add(from);
		toList.add(to);
		weightList.add(weight);
		adjacencyList[from].add(edgeId);
		edgeNo++;
	}

	public double[] dijkstra(int source) {
		final double[] fin = new double[nodeNo];
		boolean[] poped = new boolean[nodeNo];
		Arrays.fill(fin, Long.MAX_VALUE);
		TreeSet<Integer> q1 = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				double diff1 = fin[n1] - fin[n2];
				if (diff1 > 0) return 1;
				if (diff1 < 0) return -1;
				return n1 - n2;
			}
		});
		q1.add(source);
		fin[source] = 0;
		for (;;) {
			if (q1.size() <= 0) break;
			int cur = q1.pollFirst();
			poped[cur] = true;
			double baseDist = fin[cur];
			for (int edgeId : adjacencyList[cur]) {
				int to = toList.get(edgeId);
				if (poped[to]) continue;
				double newDist = baseDist + weightList.get(edgeId);
				if (newDist < fin[to]) {
					if (q1.contains(to)) {
						q1.remove(to);
					}
					fin[to] = newDist;
					q1.add(to);
				}
			}
		}
		return fin;
	}
}
