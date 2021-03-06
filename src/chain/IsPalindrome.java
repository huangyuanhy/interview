/**
 * 
 */
package chain;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Stack;

/**
 * @author Administrator
 *2018年8月21日
 *链表回文串判断
 */
public class IsPalindrome {
	public static void main(String[] args) {
		int[] arr= {1,2,3,2,1};
		Chain head = Chain.init(arr);
		System.out.println(solution(head));
	}
	//right一次走一步， cur 一次走两步
	private static boolean solution(Chain head) {
		if (head==null||head.next==null) {
			return true;
		}
		Chain right=head.next;
		Chain cur=head;
		while (right.next!=null&&cur.next!=null&&cur.next .next!=null) {
			cur=cur.next.next;
			right=right.next;
		}
		Stack<Chain> stack=new Stack<>();
		while (right!=null) {
			stack.push(right);
			right=right.next;
		}
		while (!stack.isEmpty()) {
			if (stack.pop().value!=head.value) {
				return false;
				
			}
			head=head.next;
		}
		return true;
	}
}
