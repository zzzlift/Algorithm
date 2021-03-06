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
	
	@Test
	public void testdfs(){
		Graph_AdjList_int2_dfs g=new Graph_AdjList_int2_dfs(8);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		g.addEdge(3, 7);
		g.dfs(1);
	}
	
	@Test
	public void testbfs(){
		Graph_AdjList_int2_dfs g=new Graph_AdjList_int2_dfs(8);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		g.addEdge(3, 7);
		g.bfs(1);
	}
	
	@Test
	public void testpath(){
		Graph_AdjList_int2_dfs g=new Graph_AdjList_int2_dfs(6);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(5, 4);
		int s=2,t=5;
		g.bfs(s);
		g.showPath(g.pathTo(s, t));
		
	}
}
