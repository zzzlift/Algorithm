package com.zhy.sort;

import java.util.Arrays;

public class ShellSort {
	public static void shellSort(int[] a) {
		int[] gaps = { 5, 3, 1 };
		for (int g : gaps) {
			for (int i = g; i < a.length; i++) {
				int temp = a[i];
				//j>=g 是保证下一次循环不会溢出 
				//a[j - g] > temp 是直到找到合适的插入位置
				int j;
				for (j = i; j >= g && a[j - g] > temp; j = j - g) {
					a[j]=a[j-g];
				}
				a[j]=temp;
			}
		}
	}
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3};
		shellSort(a);
		System.out.println(Arrays.toString(a));
	}
}
