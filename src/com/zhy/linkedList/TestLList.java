package com.zhy.linkedList;

import org.junit.Test;

public class TestLList {
	@Test
	public void testLList(){
		LList l=new LList();
		l.push("1");
		l.push(2);
		l.display();
	}
}
