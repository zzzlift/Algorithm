package com.zhy.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestCommonSubstring {
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
				}else{
					c[i][j]=0;
				}
			}
		}
		System.out.println("a is:");
		printMatrix(c);
		System.out.println("\n\nb is:");
		printMatrix(b);
		Map<String,Deque<String>> r=backTracking(b,y);
		System.out.println(r);
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
	
	public static Map<String,Deque<String>> backTracking(int[][] b,String[] y){
		int col=b[0].length;
		int row=b.length;
		Map<String,Deque<String>> map=new HashMap<String,Deque<String>>();
		Deque<String> res=new ArrayDeque<String>();
		System.out.println("\n\nback:");
		for(String e:y){
			System.out.print(e+"\t");
		}
		System.out.println("\n\n");
		int i=row-1;
		int j=col-1;
		int o=0;
		while(i>0){
			while(j>0){
				int be=b[i][j];
				switch(be){
					case 1:
						res.push(y[j]);
						//after used, this position is set to 0;
						b[i][j]=0;
//						printMatrix(b);
						i=i-1;
						/*
						 * j-- under this while, so we don't need to write
						 */
						break;
					default:
						int l=res.size();
						if(l>0){
							String ls=String.valueOf(l);
							if(map.containsKey(ls)){
								ls=ls+"_"+o;
								o++;
							}
							map.put(ls, res);
							i=row-1;
							j=col-1;
							res=new ArrayDeque<String>();
						}
						break;
				}
				j--;
			}
			j=col-1;
			i--;
		}
		return map;
	}
	
	public static void main(String[] args){
		String[] x={"","a","c","b","c","f"};
		String[] y={"","a","b","c","d","e","f"};
		lcs_length(x,y);
	}
}
