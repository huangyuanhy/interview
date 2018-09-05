/**
 * 
 */
package chain;

import java.util.Stack;

/**
 * @author Administrator
 *2018年8月21日
 *将单链表的每K个节点之间逆序
 */
public class ReverseKNode {
	static int count=0;
	static Node nNode=null;//返回的头节点
	static boolean flag=true;		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,9,8,7,6,5,4,3,2,1};
		Node head = Node.init(a);
		Node tmp=head;
		while (tmp!=null) {
			count++;
			tmp=tmp.next;
		}
		count=count/3;//循环几次；
		Node solution = loopReverse(head, 3,count);
		while (solution!=null) {
			System.out.println(solution.value);
			solution=solution.next;
		}
	}

	public static Node loopReverse(Node n,int K,int count) {
		if (count==0||null==n) {
			return n;
		}
		int a=count;
		Node tmp=n;
		int num=1;//第几个节点
		Node pre=null;
		while (n!=null&&num<=K&&a-->0) {
			Node next=n.next;
			n.next=pre;
			pre=n;
			n=next;		
			num++;
		}
		if (flag) {
			nNode=pre;
			flag=false;
		}
			pre = loopReverse(n, K,count);//
			
			tmp.next=pre;

		
		return nNode;
	}
}
