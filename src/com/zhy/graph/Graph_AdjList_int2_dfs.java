package com.zhy.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * In general, int graph is enough for tasks with an extra lexicon.
 * Initialize first.
 * Graph的邻接链表实现，dfs，bfs
 * 注意这都是无向图，因为addEdge这里可以改成有向或者无向
 * @author Administrator
 *
 */
public class Graph_AdjList_int2_dfs {
	private Object[] vertices;
	/*这个的作用是判断有没有访问过，如果你里面包含双向的边
	 * 或者整个图就是无向的势必会重复遍历，以前走过的根节点，导致永无止境的循环起来，
	 * 标记一下就不会走错了
	 */
	private int[] marked;
	private int[] edgeTo;
	
	public Graph_AdjList_int2_dfs(int len){
		vertices=new Object[len];
		marked=new int[len];
		edgeTo=new int[len];
		
		for(Object e:vertices){
			e=new ArrayList<Object>();
		}
		
		for(int o:marked){
			o=0;
		}
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
	
	public void dfs(int s){
		this.marked[s]=1;
//		if(this.vertices[s]!=null){
			System.out.println(s);
//		}
		for(Object v1:(List<Object>) vertices[s]){
			if(this.marked[(int) v1]==0){
				this.dfs((int)v1);
			}
		}
	}
	
	public void bfs(int s){
		ArrayDeque q=new ArrayDeque();
		this.marked[s]=1;
		/*
		 * offer+poll
		 * push+pop
		 * don't mess up
		 */
		q.offer(s);
		while(!q.isEmpty()){
			Object v=q.poll();
			System.out.println((int)v);
			for(Object v1:(List<Object>)this.vertices[(int)v]){
				if(this.marked[(int)v1]==0){
					this.edgeTo[(int)v1]=(int)v;
					this.marked[(int)v1]=1;
					q.offer(v1);
				}
			}
		}
	}
	/**
	 * 
	 * @param s 值得注意的是，你这个s必须和bfs的s一样
	 * @param t
	 * @return
	 */
	public ArrayDeque pathTo(int s,int t){
		if(this.marked[t]==0){
			System.out.println("error");
			return null;
		}
		ArrayDeque q=new ArrayDeque();
		for(int i=t;i!=s;i=this.edgeTo[i]){
			q.push(i);
		}
		q.push(s);
		return q;
	}
	
	public void showPath(ArrayDeque q){
//		for(int e:list){
//			System.out.print(e+"-");
//		}
		while(!q.isEmpty()){
			System.out.print(q.pop()+"-");
		}
	}
}
