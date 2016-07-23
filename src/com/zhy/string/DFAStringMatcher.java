package com.zhy.string;
/**
 * DFA使用的是后缀
 * KMP使用的是前缀
 * @author Administrator
 *
 */
public class DFAStringMatcher {
	
	private static final int NO_OF_CHARS=256;
	
	public static void main(String[] args){
		String text="c2abcaaaaabc";
		String ps="abc";
		char[] p=ps.toCharArray();
		
		int[][] delta=compute_transition_function(p);
		finite_automation_matcher(text.toCharArray(),delta,p.length);
	}
	public static void finite_automation_matcher(char[] text,int[][] delta,int m ){
		int n=text.length;
		int q=0;
		for(int i=0;i<n;i++){
//			System.out.println("i:"+i+"q:"+q);
			q=delta[q][text[i]];//直接转化为ascii码了
//			System.out.println(q);
			if(q==m){
				//为什么加1，因为你减去长度实际上是落在了上一位
				System.out.println(i+1-m);
			}
		}
	}

	public static int[][] compute_transition_function(char[] p){
		int m=p.length;
		//m+1是因为状态的数量比pattern的长度多1，小学植树问题
		int[][] delta=new int[m+1][NO_OF_CHARS];
		for(int q=0;q<=m;q++){
			//你这里用的ascii自然也不用转化就是一个无重复的字符集合了,char和int本来就是一家子
			for(int sigma_i=0;sigma_i<NO_OF_CHARS;++sigma_i){
				//状态k，后面都是拿状态说事
				//小心下标越界，p[k--]那里，最长 也只是p[m--]
//				int k=m<(q+1)?m:q;
				//k 是下一个状态,k=q+1；同时q+1又不能越界，当q是最后一个状态时K也得是最后一个状态
				int k=Math.min(m, q+1);
//				if(sigma_i=='a'){
//					System.out.println("q:"+q+" k:"+k+" sigma_i:"+(char)sigma_i);
//				}
				while(k>=0){
//					System.out.println("sigma:"+sigma_i);
					
					if(isSuffix(p,k,q,sigma_i)){
						break;
					}
					//这句一定要加，否则，当最后k=0，判断完之后，还要--，结果状态就存了-1
					if(k==0){
						break;
					}
					k--;
				}
				//从状态q转移到状态k，输入sigma_i
				
				if(k!=0){
					//打印状态转移过程
//					System.out.println("q:"+q+" k:"+k+" sigma_i:"+(char)sigma_i);
				}
				delta[q][sigma_i]=k;
			}
		}
		return delta;
	}

	private static boolean isSuffix(char[] p, int k, int q, int a) {
		// TODO Auto-generated method stub
		//先判断第一个字符a是否和p[k]相等
//		System.out.println("a:"+a);
		//状态总是比字母靠后一个, k状态对应的转化字母是p[k-1]
		//如果一上来就是0状态，epsilon看作是所有字符串的后缀
		if(k==0){
			return true;
		}
		
		if(p[k-1]!=a){
			return false;
		}
		k--;
		while(k>0){
			//q不要越界，注意q是从0状态开始的
			if(p[k-1]!=p[q-1]){
				return false;
			}
			k--;
			q--;
		}
		return true;
	}
	
	
	
}
