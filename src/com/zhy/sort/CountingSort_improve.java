package com.zhy.sort;

import java.util.Arrays;

public class CountingSort_improve {
	public int[] sort(int[] sequence, int maxValue) 
    {
        // Bucket Sort
        int[] Bucket = new int[maxValue + 1];
        int[] sorted_sequence = new int[sequence.length];
 
        for (int i = 0; i < sequence.length; i++)
            Bucket[sequence[i]]++;
 
        /*
         * 简化版的counting sort省去了将bucket每个元素累加的步骤
         */
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[outPos++] = i;
 
        return sorted_sequence;
    }
	
	public static void main (String args[]){
		int[] a={2,4,1,5,7,0,3,2,3};
		CountingSort ct=new CountingSort();
		int[] b=ct.countingSort(a,7);
		System.out.println(Arrays.toString(b));
	}
 
}
