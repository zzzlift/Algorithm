package com.zhy.sort;

public class Run {
	public static void main(String args[]){
		Sort quickSort=new QuickSort();
//		QuickSort.main(args);
		//因为父类中没有main方法，所以需要强制转换
		//成员变量是不具有多态性的
		((QuickSort) quickSort).main(args);
	}
}
