package com.zhy.sort;

import java.util.Arrays;
/**
 * wikipedia
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void bubbleSort(int[] a){
		int n=a.length;
		boolean swapped=true;
		while(swapped){
			swapped=false;
			//第n次循环都是把第n大的数字放在后面，所以没必要每次都循环到最后
			for(int i=1;i<n;i++){
				if(a[i-1]>a[i]){
					swap(a,i-1,i);
					swapped=true;
				}
			}
			n=n-1;
		}
	}
	
	public static void swap(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3};
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}
}
