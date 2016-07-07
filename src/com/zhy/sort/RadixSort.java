package com.zhy.sort;

import java.util.Arrays;

public class RadixSort {
	public void radixSort(int[] a){
		int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
            	//把每个元素的个位放进bucket来计数[1, 2, 2, 2, 0, 0, 0, 1, 1, 0]，用的计数排序的思想
                bucket[(a[i] / exp) % 10]++;
            //将数量进行累加[1, 3, 5, 7, 7, 7, 7, 8, 9, 9]
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            //然后改变a为第一次排列后的值
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
	}
	
	public static void main (String args[]){
		int[] a={48,32,1,51,7,20,3,2,3};
		RadixSort r=new RadixSort();
		r.radixSort(a);
		System.out.println(Arrays.toString(a));
	}
}
