package com.zhy.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * In general, int graph is enough for tasks with an extra lexicon.
 * @author Administrator
 *
 */
public class Graph_AdjList_int {
	private Object[] vertices;
	public Graph_AdjList_int(int len){
		vertices=new Object[len];
	}
	
	public void push(int v1,int v2){
		if(vertices[v1]==null)
			vertices[v1]=new ArrayList<Object>();
		((List<Object>) vertices[v1]).add(v2);
	}
	public void addEdge(int v1,int v2){
		push(v1,v2);
		push(v2,v1);
	}
	
	public void dispaly(){
		for(int i=0;i<vertices.length;i++){
			if(vertices[i]==null) continue;
			System.out.print(i+"->");
			for(Object e:(List<Object>) vertices[i])
				System.out.print(e+",");
			
			System.out.println("");
		}
	}
}
