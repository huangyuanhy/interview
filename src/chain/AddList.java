package chain;

import java.util.Stack;

/**
 * 两个链表中的数值相加，得到一个新的链表
 * 9--3--7  和 6--3 相加   得到 1-0-0-0
 * @author Administrator
 *2018年8月21日
 */
public class AddList {
	public static void main(String[] args) {
		int[] a= {7,3,9};
		Chain head1 = Chain.init(a);
		int[] b= {3,6};
		Chain head2 = Chain.init(b);
		Chain solution = solution(head1, head2);
		while (solution!=null) {
			System.out.println(solution.value);
			solution=solution.next;
		}
	}
	/**
	 * 链表翻转后 由低位向高位运算，然后再返回新的链表  这样不需要辅助桟
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Chain solution(Chain head1,Chain head2) {
		Chain reverse1 = Reverse.reverse(head1);
		Chain reverse2 = Reverse.reverse(head2);
		 
		Chain nNode=null;
		int tmp=0;
		while (reverse1!=null||reverse2!=null) {
			int a=reverse1==null?0:reverse1.value;
			int b=reverse2==null?0:reverse2.value;
			
			int sum=a+b+tmp;
			nNode=new Chain(sum%10, nNode);
			tmp=sum/10;
			
			reverse1=reverse1==null?null:reverse1.next;
			reverse2=reverse2==null?null:reverse2.next;
		}
		if (1==tmp) {
			nNode=new Chain(tmp, nNode);
			
		}
		return nNode;
	
	}
	/**
	 * 这个方法需要借助辅助桟
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Chain solution1(Chain head1,Chain head2) {
		if (head1==null||head2==null) {
			return head1==null? head2:head1;
		}
		
		Stack<Chain> stack1=new Stack<>();
		Stack<Chain> stack2=new Stack<>();
		while (head1!=null) {
			stack1.push(head1);	
			head1=head1.next;
		}
		while (head2!=null) {		
			stack2.push(head2);
			head2=head2.next;
		}
		int tmp=0;
		Chain nNode=null;
		Chain pre=null;
		while (stack1.size()!=0||stack2.size()!=0) {
			int a =stack1.isEmpty()?0:stack1.pop().value;
			int b =stack2.isEmpty()?0:stack2.pop().value;

			int sum=a+b+tmp;
			pre=new Chain(sum%10,nNode);
			nNode=pre;
			pre=null;
			tmp=sum/10;

		}	
		if (1==tmp) {
			pre=new Chain(tmp, nNode);
			nNode=pre;
			pre=null;
		}
		return nNode;
	}
	private static class Reverse {
		private static Chain reverse(Chain head) {
			Chain pre=null;
			Chain tmp=null;
			while (head!=null) {
				tmp=head.next;
				head.next=pre;
				pre=head;
				head=tmp;
			}
			return pre;
		}
	}
}
