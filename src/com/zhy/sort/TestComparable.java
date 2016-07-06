package com.zhy.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestComparable {
	@Test
	public void test(){
		String x="1",y="2";
		//compareTo不能比较int这种原生数据类型
		int res=x.compareTo(y);
//		int r=compare(x,y);
		System.out.println(res);
	}
	
	@Test
	public void testContinue(){
		int i=0;
		while(++i<10){
		if(true){
			System.out.println("before");
			continue;
//			System.out.println("after");
		}
		}
	}
	
	@Test
	public void testCopy(){
		int[] a={1,2,3};
		int[] b=Arrays.copyOfRange(a, 0, 1);
		System.out.println(b.length);
		System.out.println(Arrays.toString(b));
	}
}
