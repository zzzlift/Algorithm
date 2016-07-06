package com.zhy.sort;

import java.util.Arrays;

public class HeapSort {
	
	public int left(int i){
		return 2*i+1;
	}
	
	public int right(int i){
		return 2*i+2;
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public void swap(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
	public void maxHeapify(int[] a,int i){
		int l=left(i);
		int r=right(i);
		int largest;
		if(l<a.length && a[l]>a[i]){
			largest=l;
		}else{
			largest =i;
		}
		
		if(r<a.length && a[r]>a[largest]){
			largest=r;
		}
		if(largest!=i){
			swap(a,i,largest);
			maxHeapify(a, largest);
		}
	}
	
	public void buildMaxHeap(int[] a){
//		int[] aHeap=new int[a.length];
		for(int i=(a.length-1)/2;i>=0;i--){
			maxHeapify(a, i);
		}
	}
	
	public void heapSort(int[] a){
		buildMaxHeap(a);
		int n=a.length;
		//这个a.length不能换成n
		for(int i=a.length-1;i>0;i--){
			swap(a,0,i);
			int[] aheap=Arrays.copyOfRange(a, 0	, --n);
			
			maxHeapify(aheap, 0);
			//你每执行完一次都要把排列的那一小段覆盖原来的a才行
			for(int j=0;j<aheap.length;j++){
				a[j]=aheap[j];
			}
			
		}
	}
	
	public static void main (String args[]){
//		int[] a={2,4,1,5,7,0,3};
		int[] a={2,4,1,5,7,10,32,23};
		HeapSort hs=new HeapSort();
		hs.heapSort(a);
		System.out.println(Arrays.toString(a));
	}
	
}
