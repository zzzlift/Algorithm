package com.zhy.sort;

import java.util.Arrays;

public class BucketSort {
	public int[] bucketSort(int[] a){
		return null;
	}
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3,2,3};
		BucketSort bu=new BucketSort();
		int[] b=bu.bucketSort(a);
		System.out.println(Arrays.toString(b));
	}
}
