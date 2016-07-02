package com.zhy.linkedList;

public class DoublyLList {
	private DNode head;
	public DoublyLList(){
		this.head=new DNode("head");
	}
	
	public DNode find(Object item){
		DNode current=this.head;
		while(current.data!=item){
			if(current.next == null) {
				return null;
			}
			current=current.next;
		}
		return current;
	}
	
	public DNode findLast(){
		DNode current=this.head;
		while(!(current.next==null)){
			current=current.next;
		}
		return current;
	}
	
	/**
	 * insert data after item
	 * @param data
	 * @param item
	 */
	public void insert(Object data,Object item){
		DNode newNode=new DNode(data);
		DNode current=find(item);
		newNode.next=current.next;
		newNode.previous=current;
		current.next=newNode;
		
	}
	
	public void push(Object data){
		DNode current=findLast();
		DNode newNode=new DNode(data);
		current.next=newNode;
		newNode.previous=current;
	}
	
	public void remove(Object item){
		DNode current=find(item);
		if(!(current==null)){
			current.previous.next=current.next;
			current.next.previous=current.previous;
			current.next=null;
			current.previous=null;
		}
	}
	
	public void display(){
		DNode current=this.head;
		while(!(current.next==null)){
			System.out.println(current.next.data);
			current=current.next;
		}
	}
	
	public void dispalyReverse(){
		DNode current=this.findLast();
		while(!(current.previous==null)){
			System.out.println(current.data);
			current=current.previous;
		}
	}
}

class DNode{
	public Object data;
	public DNode next;
	public DNode previous;
	public DNode(Object data){
		this.data=data;
		this.next=null;
		this.previous=null;
	}
}