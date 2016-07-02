package com.zhy.linkedList;

public class LList {
	private Node head;
	public LList(){
		this.head=new Node("head");
	}
	
	public Node find(Object item){
		Node current=this.head;
		while(current.data!=item){
			if(current.next == null) {
				return null;
			}
			current=current.next;
		}
		return current;
	}
	
	public Node findLast(){
		Node current=this.head;
		while(!(current.next==null)){
			current=current.next;
		}
		return current;
	}
	
	public Node findPrevious(Object item){
		Node current=this.head;
		while(!(current.next==null) && current.next.data!=item){
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
		Node newNode=new Node(data);
		Node current=find(item);
		newNode.next=current.next;
		current.next=newNode;
		
	}
	
	public void push(Object data){
		Node current=findLast();
		current.next=new Node(data);
	}
	
	public void remove(Object item){
		Node preNode=findPrevious(item);
		if(!(preNode.next==null)){
			preNode.next=preNode.next.next;
		}
	}
	
	public void display(){
		Node current=this.head;
		while(!(current.next==null)){
			System.out.println(current.next.data);
			current=current.next;
		}
	}
	
}

class Node{
	public Object data;
	public Node next;
	public Node(Object data){
		this.data=data;
		this.next=null;
	}
}