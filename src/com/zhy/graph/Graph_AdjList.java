package com.zhy.graph;

import java.util.ArrayList;
import java.util.List;
/**
 * deal with kinds of types
 * @author Administrator
 *
 */
public class Graph_AdjList {
	private Vertex[] vertices;
	private int nVertices;
	
	public Graph_AdjList(int len){
		vertices=new Vertex[len];
		this.nVertices=0;
	}
	
	public void addEdge(Object v1,Object v2){
		push(getVertex(v1).adjL,v2);
		push(getVertex(v2).adjL,v1);
	}
	
	public void push(List<Object> vs,Object v1){
		vs.add(v1);
	}
	
	public Vertex getVertex(Object v){
		for(Vertex e:vertices){
			if(e==null) continue;
			if(e.label.equals(v))
				return e;
		}
		vertices[nVertices++]=new Vertex(v);
		return vertices[nVertices-1];
	}
	
	/*
	public Object getVertex(Object v){
		Find f= vertex->{
			for(Vertex e:vertices){
				if(e.label.equals(vertex))
					return e;
			}
//			return null;
			vertices[nVertices++]=new Vertex(vertex);
			return vertices[nVertices-1];
			
		};
		return (Object) f;
	}
	*/
	
	
	public void dispaly(){
		for(Vertex e:vertices){
			if(e==null) continue;
			System.out.print(e.label+"->");
			for(Object e1:e.adjL)
				System.out.print(e1+",");
			System.out.println("");
		}
	}
}

interface Find{
	Vertex find(Vertex v);
}

//interface Vertex{
//	
//}
class Vertex{
	public Object label;
	public List<Object> adjL;
	public Vertex(Object label){
		this.label=label;
		this.adjL=new ArrayList<Object>();
	}
}
