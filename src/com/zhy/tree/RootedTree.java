package com.zhy.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
/**
 * build rooted tree list all the situation
 * @author Administrator
 *
 */
public class RootedTree {
	public RNode buildRootedTree(int[] indexArray, int level) {
		int n = indexArray.length;
		RNode root = new RNode(indexArray[0]);
		/*
		 * recusive method
		 */
		buildTree(root, indexArray, level, 0);
		return root;

	}

	private void buildTree(RNode root, int[] indexArray, int level, int cLevel) {
		int[] a = ArrayUtils.removeElement(indexArray, (int) root.data);
		int n = a.length;
		cLevel++;
		if (cLevel > level)
			return;
		/*
		 * each element append children
		 */
		for (int i = 0; i < n; i++) {
			RNode node = new RNode(a[i]);
			root.appendChild(node);
			buildTree(node, a, level, cLevel);
		}
		
	}

	public static void main(String[] args) {
		RootedTree rt = new RootedTree();
		int[] a = { 1, 2, 3, 4 };
		RNode root = rt.buildRootedTree(a, 2);
		rt.printTree(root);
	}

	private void printTree(RNode root) {
		Deque<RNode> d = new ArrayDeque<RNode>();
		d.offer(root);
		while (!d.isEmpty()) {
			RNode r = d.poll();
			System.out.println(r.data);
			List<RNode> list = r.getChildren();
			if(list==null){
				continue;
			}
			for (RNode e : list) {
				d.offer(e);
			}
		}
	}
}

class RNode<T> {
	/*
	 * if you use Object, then you will cast each time very boring
	 * using generic no need to cast
	 */
	public T data;
	public RNode leftChild;
	public RNode rightSibling;

	public RNode(T data) {
		this.data = data;
		this.leftChild = null;
		this.rightSibling = null;
	}

	public void appendChild(RNode node) {
		if (leftChild == null) {
			leftChild = node;
		} else {
			/*
			 * you must use this or it will only save 2 nodes
			 */
			// leftChild.rightSibling=node;
			RNode r=this.leftChild;
			/*
			 * you cannot use r!=null see LList
			 */
			while (!(r.rightSibling == null)) {
				r = r.rightSibling;
			}
			r.rightSibling = node;
		}
	}

	public void displayChildren(RNode node) {
		List<RNode> list = getChildren();
		for (RNode e : list) {
			System.out.print(e.data + "\t");
		}
		System.out.println();
	}

	public List<RNode> getChildren() {
		if(leftChild==null) return null;
		List<RNode> list = new ArrayList<RNode>();
		list.add(leftChild);
		RNode left = leftChild;
		while (!(left.rightSibling==null)) {
			left = left.rightSibling;
			list.add(left);
		}
		return list;
	}
}