package com.zhy.graph;

import org.junit.Test;

public class TestGraph {
	@Test
	public void testGraph(){
		Graph_AdjList g=new Graph_AdjList(6);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.dispaly();
	}
	@Test
	public void testGraphStr(){
		Graph_AdjList g=new Graph_AdjList(6);
		g.addEdge("jack", "zack");
		g.addEdge("jack", "john");
		g.addEdge("zack", "john");
		g.addEdge("peter", "jack");
		g.dispaly();
	}
	
	@Test 
	public void testGraph_int2(){
		Graph_AdjList_int2 g=new Graph_AdjList_int2(6);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.dispaly();
	}
	
	@Test 
	public void testGraph_mat(){
		Graph_AdjMat g=new Graph_AdjMat(6);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.dispaly();
	}
}
