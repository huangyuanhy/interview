package chain;

import java.util.List;

import sun.security.krb5.internal.ccache.CCacheInputStream;
import sun.security.krb5.internal.crypto.crc32;

/**]
 * 链表相关问题
 * @author Administrator
 *2019年4月15日
 */
public class SerialProblemsOfLinkedList {

	public static void main(String[] args) {
		int[] arr3= {5,4,3,2,1};
		Chain c3 = Chain.init(arr3);
		printChain(reverseK(c3, 2));
	}
	public static void printChain(Chain node) {
		while (node!=null) {
			System.out.println(node.value);
			node=node.next;
		}
	}
	// 反转链表  递归
	public static  Chain reverseLinkedList1(Chain node) {
		if (node==null||node.next==null) {
			return node;
		}
		Chain res=reverseLinkedList1(node.next);
		node.next.next=node;
		node.next=null;
		return res;
	}
	// 反转链表  循环
	public static  Chain reverseLinkedList(Chain node) {
		Chain resNode=null;
		Chain tmp=null;
		while (node!=null) {
			tmp=node.next;
			node.next=resNode;
			resNode=node;
			node=tmp;
		}
		return resNode;
	}
	//判断链表是否有环
	public static boolean hasCycle(Chain node) {
		if (node==null||node.next==null) {
			return false;
		}
		Chain fst=node;
		Chain sec=node.next;
		while (fst!=sec) {
			if (fst==null||sec.next==null) {
				return false;
			}
			fst=fst.next;
			sec=fst.next.next;
		}
		return true;
	}
	//链表排序
	public static Chain sortChain(Chain node) {
		if (node==null) {
			return null;
		}
		Chain lastNode=null;
		Chain tmp=node;
		while (tmp.next!=lastNode) {
			while (tmp.next!=lastNode) {
				if (tmp.value>tmp.next.value) {
					swap(tmp, tmp.next);
				}
				tmp=tmp.next;
			}
			lastNode=tmp;
			tmp=node;
		}
		return node;
	}
	private static void swap(Chain n1,Chain n2) {
		if (n1!=null&&n2!=null) {
			Integer tmp=n1.value;
			n1.value=n2.value;
			n2.value=tmp;
		}
	}
	//合并两个有序链表  方法一循环
	public static Chain mergeMutiChainOfTwo(Chain c1,Chain c2) {
		if (c1==null||c2==null) {
			return c2==null?c1:c2;
		}
		Chain res=new Chain(0);
		Chain tmp=res;
		while (c1!=null&&c2!=null) {
			if (c1.value<c2.value) {
				tmp.next=c1;
				c1=c1.next;
			}else {
				tmp.next=c2;
				c2=c2.next;
			}
			tmp=tmp.next; 
		}
		if (c1!=null) {
			tmp.next=c1;
		}
		else {
			tmp.next=c2;
		}
		return res.next;
	}
	//合并两个有序链表  方法二 递归
	public static Chain mergeMutiChainOfTwo2(Chain c1,Chain c2) {
		if (c1==null||c2==null) {
			return c2==null?c1:c2;
		}
		Chain res=null;//返回的头结点
		if (c1.value<c2.value) {
			res=c1;
			res.next= mergeMutiChainOfTwo2(c1.next, c2);
		}else {
			res=c2;
			res.next= mergeMutiChainOfTwo2(c1, c2.next);
		} 
		return res;
	}
	//合并两个有序链表  方法二 递归
	public static Chain mergeMutiChainOfTwo3(Chain c1,Chain c2) {
		if (c1==null||c2==null) {
			return c2==null?c1:c2;
		}
		if (c1.value<c2.value) {
			c1.next= mergeMutiChainOfTwo3(c1.next, c2);
			return c1;
		}else {
			c2.next=mergeMutiChainOfTwo3(c1, c2.next);
			return c2;
		}
	}
	//合并K个链表
	public static Chain mergeMutiChainOfK(List<Chain> list,int start,int end) {
		if (list==null||list.size()==0) {
			return null;
		}
		if (start<end) {
			int middle=(start+end)/2;
			Chain c1=mergeMutiChainOfK(list, start, middle);
			Chain c2=mergeMutiChainOfK(list, middle+1,end);
			return mergeMutiChainOfTwo3(c1, c2);
		}
		return list.get(start);
	}
	//返回链表倒数第K个节点
	public static Chain getKthNode(Chain c,int K) {
		if (c==null||K<0) {
			return null;
		}
		int index=1;
		Chain c1=c;
		Chain c2=c;
		while(index++!=K) {
			if (c1.next==null) {//节点的长度小于K
				return null;
			}
			c1=c1.next;
		}
		while (c1.next!=null) {
			c1=c1.next;
			c2=c2.next;
		}
		return c2;
	}
	//删除链表倒数第N个节点
	public static Chain deleteNth(Chain c,int N) {
		//找到倒数第N+1个节点
		Chain node = getKthNode(c, N+1);
		//待删除的节点
		Chain delete=node.next;
		node.next=node.next.next;
		delete.next=null;
		return c;
	}
	//翻转链表的第n个到m之间的节点
	public static Chain reverseFromN2M(Chain c,int n,int m){
		if (c==null||c.next==null||n>m||m<=1) {
			return c;
		}
		if (n==1) {
			Chain tmp=c;
			while (--m!=0) {
				tmp=tmp.next;//找到第m个节点
			}
			Chain end=tmp.next;
			Chain res = reverse2N(c, end);
			//头尾相连
			c.next=end;
			return res;
		}
		//找到第n-1个节点
		Chain start=c;
		for (int i = 2; i <= n-1; i++) {//从第二个节点开始计算
			if (start==null) {
				return c;
			}
			start=start.next;
		}
		//找到第m+1个节点  即 从start节点往后走m-n+2个节点
		Chain end=start;
		for (int i = n; i <=m+1; i++) {
			if (end==null) {
				return c;
			}
			end=end.next;
		}
		//将原来的第N个节点保存起来，翻转之后就是最后一个节点，方便与end节点相连
		Chain tmp=start.next;
		//翻转 start.next 到end 节点之间的节点，不包括end节点
		//将翻转后的头节点与start节点相连，
		start.next=reverse2N(start.next, end);
		//原来的头节点与end节点相连
		tmp.next=end;
		return c;

	}
	/**
	 * 指定翻转到N节点前的所有节点
	 * @param c 传入的头节点
	 * @param index 翻转的最后一个节点,不包括此节点
	 * @return 翻转后的链表
	 */
	public static Chain reverse2N(Chain c,Chain index){
		if (c==index||c.next==index) {
			return c;
		}
		Chain res=reverse2N(c.next, index);
		c.next.next=c;
		c.next=null;
		return res;
	}

	//将单链表的每K个节点之间逆序 不足K个节点不翻转
	public static Chain reverseK(Chain c,int K) {
		if (c==null||c.next==null||K<=1) {
			return c;
		}
		int num=1;
		//计算出总共有多少节点
		Chain tmp=c;
		while (tmp.next!=null) {
			tmp=tmp.next;
			num++;
		}
		//计算翻转几次
		int count=num/K;
		for (int i = 1; i <=count; i++) {
			//确定每次翻转的头尾节点
			c= reverseFromN2M(c, K*i-K+1, K*i);
		}
		return c;

	}
}









