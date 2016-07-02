package com.zhy.sort;

import java.util.Arrays;

public class QuickSort extends Sort{
	public static void quickSort(int[] a,int p,int r){
		if(p<r){
			int q=partition(a,p,r);
			quickSort(a,p,q-1);
			quickSort(a,q+1,r);
		}
	}
	
	public static int partition(int[] a,int p,int r){
		int x=a[r];
		int i=p-1;
		for(int j=p;j<r;j++){
			if(a[j]<=x){
				i=i+1;
				swap(a,i,j);
			}
		}
		swap(a,i+1,r);
		return i+1;
	}
	
	public static void swap(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3};
		quickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
