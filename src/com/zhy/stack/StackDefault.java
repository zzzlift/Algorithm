package com.zhy.stack;

import java.util.ArrayDeque;

import org.junit.Test;

public class StackDefault {
	@Test
	public void testStack(){
		ArrayDeque stack=new ArrayDeque();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
	}
	
	@Test
	public void testMyStack(){
		Stack stack=new Stack(10);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek());
		System.out.println(stack.pop()+" "+stack.pop());
	}
}
