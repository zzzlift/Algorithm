package com.zhy.linkedList;

import org.junit.Test;

public class TestLList {
	@Test
	public void testLList(){
		LList l=new LList();
		l.push("1");
		l.push(2);
		l.display();
		l.insert(3, "1");
		l.display();
		System.out.println("remove");
		l.remove(3);
		l.display();
		System.out.println("find");
		System.out.println(l.find(3));
	}
	@Test
	public void testDoublelyLList(){
		DoublyLList l=new DoublyLList();
		l.push(1);
		l.push(2);
		l.display();
		l.dispalyReverse();
		System.out.println("insert");
		l.insert(3,1);
		System.out.println("display");
		l.display();
		System.out.println("remove");
		l.remove(3);
		l.display();
		System.out.println("find");
		System.out.println(l.find(3));
	}
	@Test
	public void testCList(){
		CircularlyLList l=new CircularlyLList();
		l.push(1);
		l.push(2);
		l.display();
		System.out.println("insert");
		l.insert(3,1);
		System.out.println("display");
		l.display();
		System.out.println("remove");
		l.remove(3);
		l.display();
		System.out.println("find");
		System.out.println(l.find(3));
	}
}
