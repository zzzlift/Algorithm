package com.zhy.sort;

import java.util.Arrays;
/**
 * wikipedia
 * @author Administrator
 *
 */
public class BubbleSort_final {
	public static void bubbleSort(int[] a){
		int n=a.length;
		boolean swapped=true;
		while(swapped){
			swapped=false;
			int newn = 0;
			//第n次循环不仅把第n大的放在最后，还有可能在离末尾很远的地方就不再交换元素了，
			//即便不是最终解反正最后一次循环肯定会纠正的
			for(int i=1;i<n;i++){
				if(a[i-1]>a[i]){
					swap(a,i-1,i);
					swapped=true;
					newn=i;
				}
			}
			n=newn;
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
