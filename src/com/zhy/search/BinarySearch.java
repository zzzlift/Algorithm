package com.zhy.search;


public class BinarySearch {
	public static int binaySearch(int[] a,int t){
		int min=0;
		int max=a.length-1;
		int guess;
		while(max>=min){
			guess=(min+max)/2;
			if(t==a[guess]){
				return guess; 
			}else if(t<a[guess]){
				max=guess-1;
			}else{
				min=guess+1;
			}
		}
		return -1;
	}
	
	public static void main (String args[]){
		int[] a={0,1,2,3,4,5};
		int r=binaySearch(a,3);
		System.out.println(r);
	}
}
