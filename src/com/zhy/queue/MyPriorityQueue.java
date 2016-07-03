package com.zhy.queue;


public class MyPriorityQueue {
	private Object[] data;
	private int head;
	private int end;
	private int len;
	
	public MyPriorityQueue(int max){
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
			System.out.println((Object)((Object[]) data[i])[0]);
		}
	}
	
	public void enqueue(Object item,int priority){
//		Map m=new HashMap<Object,Integer>();
//		m.put(item, priority);
		Object[] o=new Object[2];
		o[0]=item;
		o[1]=priority;
		if(end==-1){
			push(o);
		}
		else if(priority>=(int) ((Object[]) data[end])[1]){
			push(o);
		}else{
			for(int i=0;i<=end;i++){
				/*
				Object[] current=(Object[]) data[i];
				int cuint=(int) current[1];
				if(priority<cuint){
				}
				*/
				if(priority<(int) ((Object[]) data[i])[1]){
					splice(i,o);
					break;
				}
			}
		}
	}
	
	public void splice(int insert,Object item){
		for(int i=end;i>=insert;i--){
			data[i+1]=data[i];
		}
		data[insert]=item;
		len++;
		end++;
	}
}
