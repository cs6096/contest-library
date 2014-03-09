package graphs;

import datastructures.IntL;

// no loops, no multiedges, no direction, no weight
public class UndirectedGraph {
	public IntL[] adjacencyList;
	int nodeNo;
	int edgeNo = 0;
	public UndirectedGraph(int nodeNo){
		this.nodeNo = nodeNo;
		adjacencyList = new IntL[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new IntL();
		}
	}
	
	public void addEdge(int from, int to){
		adjacencyList[from].add(to);
		adjacencyList[to].add(from);
	}
	
}
