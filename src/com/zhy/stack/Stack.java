package com.zhy.stack;

public class Stack {
	private Object[] data;
	private int top;
	
	public Stack(int len){
		data=new Object[len];
		top=-1;
	}
	
	public void push(Object item){
		data[++top]=item;
	}
	
	public Object peek(){
		return data[top];
	}
	
	public Object pop(){
		return data[top--];
	}
	
	public void clear(){
		top=-1;
	}
	
	public boolean ifFull(){
		return top==data.length-1;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
}
