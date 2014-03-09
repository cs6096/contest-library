package graphs;

import datastructures.IntL;

public class DirectedGraph {
	public IntL[] adjacencyList;
	int nodeNo;
	int edgeNo = 0;
	public DirectedGraph(int nodeNo){
		this.nodeNo = nodeNo;
		adjacencyList = new IntL[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new IntL();
		}
	}
	
	public void addEdge(int from, int to){
		adjacencyList[from].add(to);
	}
	
	public void addBidirectedEdge(int from, int to){
		adjacencyList[from].add(to);
		adjacencyList[to].add(from);
	}
}
