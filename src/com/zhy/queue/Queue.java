package com.zhy.queue;

public class Queue {
	private Object[] data;
	private int head;
	private int end;
	private int len;
	
	public Queue(int max){
		data=new Object[max];
		head=0;
		end=-1;
		len=0;
	}
	
	public void push(Object item){
		data[++end]=item;
		len++;
	}
	
	public Object shift(){
		len--;
		return data[head++];
	}
	
	public void enqueue(Object item){
		push(item);
	}
	
	public void dequeue(){
		shift();
	}
	
	public Object peek(){
		return data[head];
	}
	
	public Object end(){
		return data[end];
	}
	
	public boolean isEmpty(){
		return len==0;
	}
	
	public boolean isFull(){
		return len==data.length;
	}
	
	public void display(){
		for(int i=head;i<=end;i++){
			System.out.println(data[i]);
		}
	}
	
}
