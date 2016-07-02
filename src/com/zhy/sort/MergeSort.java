package com.zhy.sort;

import java.util.Arrays;
/**
 * 算法导论的方法
 * @author Administrator
 *
 */
public class MergeSort {
	public static void merge(int[] a,int p,int q,int r){
		int n1=q-p+1;
		int n2=r-q;
		int[] L=new int[n1+1];
		int[] R=new int[n2+1];
		for(int i=0;i<n1;i++){
			L[i]=a[p+i];
		}
		for(int j=0;j<n2;j++){
			/*之前一直错都是因为这里q+j+1忘记了写1这样就不对了你想想
			 * 前面是0,1,2,3 后面 肯定是从4开始如果你不加1还是从3开始
			 */
			R[j]=a[q+j+1];
		}
		int mark=Integer.MAX_VALUE;
		L[n1]=mark;
		R[n2]=mark;
		int i=0;
		int j=0;
		for(int k=p;k<=r;k++){
			//两个哨兵永远不会比较，因为在此之前一定会运行完而退出
			if(L[i]<=R[j]){
				a[k]=L[i];
				i=i+1;
			}else{
				a[k]=R[j];
				j=j+1;
			}
		}
	}
	
	public static void mergeSort(int[] a,int p, int r){
		if(p<r){
			int q=(p+r)/2;
			mergeSort(a,p,q);
			mergeSort(a,q+1,r);
			merge(a,p,q,r);
		}
	}
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3};
		mergeSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
