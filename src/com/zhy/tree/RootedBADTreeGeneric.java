package com.zhy.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
/**
 * build BAD rooted tree list all the situation
 * @author Administrator
 *
 */
public class RootedBADTreeGeneric<T> {
	public RNode buildRootedTree(T[] indexArray, int level) {
		int n = indexArray.length;
		RNode root = new RNode(indexArray[0]);
		/*
		 * recusive method
		 */
		buildTree(root, indexArray, level, 0,0);
		return root;

	}

	/**
	 * build branch and bound tree
	 * @param root each parent node you delivered
	 * @param indexArray the array you want to build tree
	 * @param level the highest level of the tree you expected
	 * @param cLevel the current level of the root node
	 * @param th the th node in every level. the children of th node is concerned with the th 
	 */
	private void buildTree(RNode root, T[] indexArray, int level, int cLevel,int th) {
		T[] a = (T[]) ArrayUtils.removeElement(indexArray, root.data);
		int n = a.length;
		cLevel++;
		if (cLevel > level)
			return;
		/*
		 * each element append children
		 */
		for (int i = th; i < n; i++) {
			RNode node = new RNode(a[i]);
			root.appendChild(node);
			buildTree(node, a, level, cLevel,i);
		}
		
	}

	public static void main(String[] args) {
		RootedBADTreeGeneric rt = new RootedBADTreeGeneric();
		Integer[] a = { 1, 2, 3, 4,5,6 };
		RNode root = rt.buildRootedTree(a, 3);
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