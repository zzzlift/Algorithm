package com.zhy.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

import org.junit.Test;

public class QueueDefault {
	@Test
	public void testPriorityQueue(){
		PriorityQueue pq=new PriorityQueue();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(20);
		pq.offer(18);
		System.out.println(pq);
	}
	
	@Test
	public void testArrayDeque(){
		ArrayDeque queue=new ArrayDeque();
		queue.offer(6);
		queue.offer(-3);
		queue.offer(20);
		queue.offer(18);
		System.out.println(queue.poll());
	}
}
