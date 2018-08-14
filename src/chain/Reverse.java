/**
 * 
 */
package chain;

import org.junit.Test;

/**
 * @author Administrator
 *2018年7月6日  链表反转
 */
public class Reverse {
	int[] arr= {1,2,3};
	@Test
	public void test() {
		//链表初试化
		Node node = Node.init(arr);
		//Node reverse = reverse(node);
		Node reverse = execute(node);
		while(reverse!=null) {
			System.out.println(reverse.value);
			reverse=reverse.next;
		}
		
	}
	/**
	 * 循环遍历
	 * @param head
	 * @return
	 */
	public Node reverse(Node head) {
		Node tmp=null;
		
		Node newNode=null;
		while (head!=null) {
			tmp=head;
			head=head.next;
			tmp.next=newNode;
			newNode=tmp;
			 
		}
		return newNode;
	}
	/**
	 * 递归反转      
	 * @param node
	 * @return
	 */
	public Node execute(Node node) {
        Node prev = null;
        
        //可以先假设只有2个节点的特殊情况， pre 和tmp 永远都指向最后一个节点 且相等。
        if (node == null || node.next == null) {
            prev = node;
        } else {
        	//下面代码就是只有两个节点的情况
        	//Node tmp =node.next;
            Node tmp = execute(node.next);
            node.next.next = node;
            node.next = null;
            prev = tmp;
        }
        return prev;
    }
}
