package com.zhy.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void selectionSort(int[] a){
		int n=a.length;
		for(int i=0;i<n-1;i++){
			int iMin=i;
			for(int j=i+1;j<n;j++){
				if(a[j]<a[iMin]){
					iMin=j;
				}
			}
			if(iMin!=i){
				swap(a,i,iMin);
			}
		}
	}
	public static void swap(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3};
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}
}
