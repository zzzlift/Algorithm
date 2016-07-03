package com.zhy.queue;

import org.junit.Test;

public class TestQueue {
	@Test
	public void testQueue(){
		Queue q =new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.display();
		System.out.println(q.peek());
		System.out.println(q.end());
		System.out.println("=====");
		System.out.println(q.dequeue());
		System.out.println("=====");
		q.display();
		
	}
	
	@Test
	public void testPQueue(){
		MyPriorityQueue q=new MyPriorityQueue(5);
		q.enqueue(5,5);
		q.enqueue(3, 3);
		q.enqueue(6, 6);
		q.enqueue(4, 4);
		q.display();
		q.dequeue();
		System.out.println("--");
		q.display();
	}
}
