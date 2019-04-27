/**
 * 
 */
package chain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 *2018年7月13日
 *找到链表环的入口节点java
 *
 */
public class LoopNode {
	//基于hash
	public Chain hashLoop(Chain node) {
		Chain cur=node;
		Chain result=null;
		Set<Chain> set=new HashSet<>();
		while (cur!=null) {
			if (!set.contains(cur)) {
				set.add(cur);
				cur=cur.next;
			}else {
				result=cur;
				break;
			}
		}
		return result;
	}
	//基于快慢指针  快的一次走两步，当再次相遇时，慢指针走的步数就是环的大小， 此时让快指针从新从头开始一步一步走，第二次相遇时的节点就是环的入口节点。
	public Chain loop2(Chain node) {
		Chain fast=node;
		Chain slow=node;
		int count=0;
		while (fast!=null&&fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			count++;
			if (fast==slow) {
				fast=node;
				break;
			}
		}
		while(fast!=slow) {
			fast=fast.next;
			slow=slow.next;
		}
		return fast;
	}
}
