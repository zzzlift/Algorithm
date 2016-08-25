package com.zhy.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSubsequence {
	public static void lcs_length(String[] x,String[] y){
		int m=x.length;
		int n=y.length;
		/*
		 * b is a trace back matrix 1 for top left corner, 2 for up, 3 for left
		 */
		int[][] b=new int[m][n];
//		fill(b,0);
		int[][] c=new int[m][n];
//		fill(c, 0);
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				
				/*
				 * we need to add one null element at the head of x and y
				 * so that we could use x[i],y[j], or we need to use x[i-1], y[j-1]
				 */
				if(x[i].equals(y[j])){
					c[i][j]=c[i-1][j-1]+1;
					b[i][j]=1;
				}else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					b[i][j]=2;
				}else{
					c[i][j]=c[i][j-1];
					b[i][j]=3;
				}
			}
		}
		System.out.println("a is:");
		printMatrix(c);
		System.out.println("\n\nb is:");
		printMatrix(b);
		backTracking(b,y);
	}
	
	public static void printMatrix(int[][] m){
		int col=m[0].length;
		int row=m.length;
		for(int i=0;i<row;i++){
			System.out.println();
				for(int j=0;j<col;j++){
				System.out.print(m[i][j]+"\t");		
			}
		}
	}
	
	public static  void fill(int[][] b,int k){
		int col=b[0].length;
		int row=b.length;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				b[i][j]=k;
			}
		}
	}
	
	public static Deque<String> backTracking(int[][] b,String[] y){
		int col=b[0].length;
		int row=b.length;
		Deque<String> res=new ArrayDeque<String>();
		System.out.println("\n\nfrom:");
		for(String e:y){
			System.out.print(e+"\t");
		}
		System.out.println("\n\n");
		int i=row-1;
		int j=col-1;
		while(i>0){
			while(j>0){
				int be=b[i][j];
//				System.out.println("i "+i+" j "+j);
				switch(be){
					case 1:
						/*
						 * offer is queue, push is stack
						 */
						res.push(y[j]);
						i=i-1;
						j=j-1;
						break;
					case 2:
						i=i-1;
						break;
					case 3:
						j=j-1;
						break;
					default:
						break;
				}
				
			}
		}
		System.out.println("the result:");
		Iterator it=res.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		return res;
	}
	
	public static void main(String[] args){
		String[] x={"","a","c","b","c","f"};
		String[] y={"","a","b","c","d","e","f"};
		lcs_length(x,y);
	}
}
