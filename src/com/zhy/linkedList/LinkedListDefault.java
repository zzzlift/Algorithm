package com.zhy.linkedList;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class LinkedListDefault {
	
	@Test
	public void linkedList(){
		LinkedList books=new LinkedList<String>();
		books.push("1");
		books.push("2");
		for(Iterator<String> it=books.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}
}
