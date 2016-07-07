package com.zhy.sort;

import java.util.Arrays;

public class CountingSort {
	public int[] countingSort(int[] a,int k){
		int[] c=new int[k+1];
		int[] b=new int[a.length+1];
		for(int i=0;i<=k;i++){
			c[i]=0;
		}
		for(int j=0;j<a.length;j++){
			c[a[j]]=c[a[j]]+1;
		}
		for(int i=1;i<=k;i++){
			c[i]=c[i]+c[i-1];
		}
		for(int j=a.length-1;j>=0;j--){
			b[c[a[j]]]=a[j];
			c[a[j]]=c[a[j]]-1;
		}
		//注意最终的b[0]是一个多余的0，要干掉
		b=Arrays.copyOfRange(b, 1, b.length);
		return b;
	}
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3,2,3};
		CountingSort ct=new CountingSort();
		int[] b=ct.countingSort(a,7);
		System.out.println(Arrays.toString(b));
	}
}
