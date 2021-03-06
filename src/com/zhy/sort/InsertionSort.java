package com.zhy.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int[] a){
		for(int j=1;j<a.length;j++){
			int key=a[j];
			int i=j-1;
			//如果当前的元素大于下一个元素key的时候，就把key变成当前元素值，然后指针后退一步
			//如果后退了仍然比key大，则把当前元素赋给下一位直到遇到比key小的位置，则把key放到下一位
			while(i>=0 && a[i]>key){
				a[i+1]=a[i];
				i=i-1;
			}
			a[i+1]=key;
		}
	}
	
	public static float[] insertionSortF(float[] a){
		for(int j=1;j<a.length;j++){
			float key=a[j];
			int i=j-1;
			//如果当前的元素大于下一个元素key的时候，就把key变成当前元素值，然后指针后退一步
			//如果后退了仍然比key大，则把当前元素赋给下一位直到遇到比key小的位置，则把key放到下一位
			while(i>=0 && a[i]>key){
				a[i+1]=a[i];
				i=i-1;
			}
			a[i+1]=key;
		}
		return a;
	}
	
	public static void main (String args[]){
		int[] a={5,2,4};
		float[] b={(float) 0.2,(float) 0.3,(float) 0.15};
		insertionSort(a);
		insertionSortF(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	
}
