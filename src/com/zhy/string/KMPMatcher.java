package com.zhy.string;

public class KMPMatcher {
	public static int[] compute_prefix_function(char[] P){
		int m=P.length;
		int[] pi=new int[m];
		pi[0]=0;
		int k=0;//k是匹配的长度
		for(int q=1;q<m;q++){
			while(k>0 && P[k]!=P[q]){
				k=pi[k-1];
			}
			//P[k]是前缀，P[q]是目前指针的位置判断是否与前缀相等
			if(P[k]==P[q]){
				k++;
			}
			pi[q]=k;
		}
		return pi;
	}
	
	public static void kmp_matcher(char[] T,char[] P){
		int n=T.length;
		int m=P.length;
		int[] pi=compute_prefix_function(P);
		int q=0;
		//这一段模式与T匹配的代码与P与自己匹配的代码基本一样，因为原理相同
		for(int i=0;i<n;i++){
			while(q>0 && P[q]!=T[i]){
				q=pi[q-1];
			}
			if(P[q]==T[i]){
				q=q+1;
			}
			if(q==m){
				System.out.println("Pattern occurs "+(i-m+1));
				//这句话的作用就是在要读下一个T[i+1]时，能够直接与pi匹配的最后一段的前缀加1进行比较
				q=pi[q-1];
			}
		}
	}
	
	public static void main(String[] args){
		String text="dcocodddcoco";
		String pattern="coco";
		char[] T=text.toCharArray();
		char[] P=pattern.toCharArray();
		kmp_matcher(T, P);
	}
}
