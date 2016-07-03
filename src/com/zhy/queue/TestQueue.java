package com.zhy.queue;

import org.junit.Test;

public class TestQueue {
	@Test
	public void testQueue(){
		Queue q =new Queue(5);
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.display();
		System.out.println(q.peek());
		System.out.println(q.end());
		System.out.println("=====");
		System.out.println(q.shift());
		System.out.println("=====");
		q.display();
		
	}
}
