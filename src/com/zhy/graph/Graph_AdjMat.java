package com.zhy.graph;
/**
 * Graph的邻接矩阵实现
 * @author Administrator
 *
 */
public class Graph_AdjMat {
//	private int[] vertics;
	private int[][] adjMat;
	
	public Graph_AdjMat(int len){
//		vertics=new int[len];
		adjMat=new int[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				adjMat[i][j]=0;
			}
		}
	}
	
	public void addEdge(int v1,int v2){
		adjMat[v1][v2]=1;
		adjMat[v2][v1]=1;
	}
	
	public void dispaly(){
		for(int i=0;i<adjMat.length;i++){
			System.out.print(i+"->");
			for(int j=0;j<adjMat.length;j++){
				if(adjMat[i][j]==1){
					System.out.print(j+",");
				}
			}
			System.out.println();
		}
	}
}
