package com.zhy.tree;

public class BinarySearchTree {
	public Node root;
	public BinarySearchTree(){
		this.root=null;
	}
	
	public void insert(int data){
		Node n=new Node(data);
		if(this.root==null){
			this.root=n;
		}else{
			Node current=root;
			Node parent=null;
			while(true){
				parent=current;
				if(data<current.data){
					current=current.left;
					if(current==null){
						parent.left=n;
						break;
					}
				}else{
					current=current.right;
					if(current==null){
						parent.right=n;
						break;
					}
				}
			}
		}
	}
	//左中右 中序
	/*
	 * 递归理解的秘诀在于，你要想这层的调用是从上一层的哪个地方进来的
	 * 当时上一层的每个变量取值是几，这层的如果不再递归，而是顺利执行完了，它将接着
	 * 上一层的入口执行上一层的下一步
	 */
	public void inOrder(Node node){
		if(node!=null){
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	
	
	public void preOrder(Node node){
		if(node!=null){
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void postOrder(Node node){
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}
	/*
	 * 这才是random walk的方式，而不是递归，简单的while循环
	 * 就能walk
	 */
	public Node find(int data){
		Node current=this.root;
		while(current.data!=data){
			if(data<current.data){
				current=current.left;
			}else{
				current=current.right;
			}
			if(current==null){
				return null;
			}
		}
		return current;
	}
	
	public Node getMin(){
		Node current=this.root;
		while(current.left!=null){
			current=current.left;
		}
		return current;
	}
	
	public Node getMax(){
		Node current=this.root;
		while(current.right!=null){
			current=current.right;
		}
		return current;
	}
	/*
	 * 查找子树的最小节点
	 * 这里用了递归，其实也是可以像上面一样用while
	 */
	public Node getSmallest(Node node){
		if(node.left==null){
			return node;
		}else{
			return getSmallest(node.left);
		}
	}
	/**
	 * 这个是js上的算法很好，比算法导论好
	 * @param data
	 * @return
	 */
	public Node remove(int data){
		return removeNode(this.root,data);
	}
	public Node removeNode(Node node,int data){
		if(node==null){
			return null;
		}
		if(data==node.data){
			/*
			 * 如果待删除节点是叶子节点（ 没有子节点的节点）， 那么只需要将从父节点指向它的链接
指向 null。
			 */
			if(node.left==null && node.right==null){
				return null;
			}
			if(node.left==null){
				return node.right;
			}
			if(node.right==null){
				return node.left;
			}
			/*
			 * 如果待删除节点包含两个子节点， 正确的做法有两种： 要么查找待删除节点左子树
上的最大值， 要么查找其右子树上的最小值。 这里我们选择后一种方式我们需要一个查找子树上最小值的方法， 后面会用它找到的最小值创建一个临时节点。 将
临时节点上的值复制到待删除节点， 然后再删除临时节点。
算法导论提供了另一种方法，比这个麻烦
			 */
			Node tempNode=getSmallest(node.right);
			node.data=tempNode.data;
			node.right=removeNode(node.right,tempNode.data);
			return node;
		}else if(data<node.data){
			/*这个node是要删除节点的父节点而不是自己，要弄清楚
			 * 而这个node.left则可能是要删除的节点自己
			 */
			node.left=removeNode(node.left,data);
			return node;
		}else{
			node.right=removeNode(node.right,data);
			return node;
		}
	}
}

class Node{
	public int data;
	public Node left;
	public Node right;
	Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}