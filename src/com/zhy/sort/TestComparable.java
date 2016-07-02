package com.zhy.sort;

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
}
