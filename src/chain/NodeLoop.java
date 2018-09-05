/**
 * 
 */
package chain;

/**
 * @author Administrator
 *2018年8月22日
 *环形有序链表插入一个新节点，不保障插入后的节点有序
 */
public class NodeLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] a= {5,4,3,2,1};
		int[] a= {};
		Node n = Node.init(a);
		if (null==n) {
			Node head = insert(n, 5);
			System.out.println(head);
		}
		Node tmp=n;

		while (tmp.next!=null) {
			tmp=tmp.next;
		}
		tmp.next=n;
		Node head = insert(n, 5);
		System.out.println(head);

	}
	private static Node insert(Node head,int K) {
		Node node = new Node(K, null);
		if (head==null) {

			node.next=node;
			return  node;
		}
/*      
		if (head==head.next) {//说明只有一个节点    还是可以归纳到cur==head这种情况
			head.next=node;
			node.next=head;
			return head;
		}*/
		//节点不止一个
		Node pre=head;
		Node next=null;
		Node cur=head.next;
		while (cur!=head) {
			next=cur.next;
			if (cur.value<K) {
				pre=cur;
				cur=next;				
			}else {

				/*pre.next=node;
				node.next=cur;
				return head;*/
				break;
			}			
		}
		//将节点插入头节点之前
		pre.next=node;
		node.next=cur;
		return head.value<K?head:node;

	}

}
