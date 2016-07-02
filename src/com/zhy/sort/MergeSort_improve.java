package com.zhy.sort;

import java.util.Arrays;

/**
 * 简便方法
 * 
 * @author Administrator
 *
 */
public class MergeSort_improve {
	private int[] a;
	private int[] tmp;
	private int length;

	public static void main(String args[]) {

		int[] a = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		MergeSort_improve mms = new MergeSort_improve();
		mms.sort(a);
		for (int i : a) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int[] a) {
		this.a = a;
		this.length = a.length;
		this.tmp = new int[length];
		mergeSort(0, length - 1);
	}

	private void mergeSort(int p, int r) {

		if (p < r) {
			int q = (r + p) / 2;
			// Below step sorts the left side of the array
			mergeSort(p, q);
			// Below step sorts the right side of the array
			mergeSort(q + 1, r);
			// Now merge both sides
			merge(p, q, r);
		}
	}

	private void merge(int p, int q, int r) {

		for (int i = p; i <= r; i++) {
			tmp[i] = a[i];
		}
		int i = p;
		int j = q + 1;
		int k = p;
		while (i <= q && j <= r) {
			if (tmp[i] <= tmp[j]) {
				a[k] = tmp[i];
				i++;
			} else {
				a[k] = tmp[j];
				j++;
			}
			k++;
		}
		
		while (i <= q) {
			a[k] = tmp[i];
			k++;
			i++;
		}

	}
}
