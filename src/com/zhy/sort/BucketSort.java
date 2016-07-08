package com.zhy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 1.强制转换的局限
 * 2.老使用Object就完蛋
 * 3.泛型的重要性
 * 4.Float 与 float的区别  Integer "object" to "primitive types" like int
 * 5.没有现成的转化函数，自己用for循环实现的转化最可靠
 * @author Administrator
 *
 */
public class BucketSort {
	private InsertionSort insertion=new InsertionSort();
	public float[] bucketSort(float[] a){
		List<Float> f=new ArrayList<Float>();
		int n=a.length;
		Object[] b=new Object[n];
		for(int i=0;i<n;i++){
			b[i]=new ArrayList<Float>();
		}
		for(int i=0;i<n;i++){
			int ind=(int) (n*a[i]);
			((List<Float>) b[ind]).add(a[i]);
		}
		for(int i=0;i<n;i++){
			//sort list with insertion sort
			/*
			 * 我可以动态的添加节省空间，然后用的时候转化成数组排序速度快
			 */
			int l=((List<Float>)b[i]).size();
			List<Float> o=(List<Float>) b[i];
			
			
			float[] of=insertion.insertionSortF(List2floatArray(o));
			b[i]=floatArray2List(of);
			concatenateList(f,(List<Float>) b[i]);
		}
		
		return List2floatArray(f);
	}
	
	public float[] Float2float(Float[] F){
		float[] f=new float[F.length];
		for(int i=0;i<F.length;i++){
			String ts= Float.toString(F[i]);
			f[i]=Float.parseFloat(ts);
		}
		return f;
	}
	
	public float[] List2floatArray(List<Float> l){
		float[] f=new float[l.size()];
		for(int i=0;i<l.size();i++){
			String ts= Float.toString(l.get(i));
			f[i]=Float.parseFloat(ts);
		}
		return f;
	}
	
	public List<Float> floatArray2List(float[] f){
		List<Float> l=new ArrayList<Float>();
		for(float e:f){
			l.add(e);
		}
		return l;
	}
	
	public void concatenateList(List<Float> o,List<Float> e){
		o.addAll(e);
	}
	public static void main (String args[]){
		float[] a={(float) 0.2,(float) 0.3,(float) 0.15};
		BucketSort bu=new BucketSort();
		float[] b=bu.bucketSort(a);
		System.out.println(Arrays.toString(b));
	}
}
