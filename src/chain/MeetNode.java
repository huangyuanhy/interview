/**
 * 
 */
package chain;

/**
 * @author Administrator
 *2018年8月21日
 *两个相交链表的第一个节点
 */
public class MeetNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Node meet(Node head1,Node head2) {
		Node n1=head1;
		Node n2=head2;
		int num=0;
		while (n1.next!=null) {
			num++;
			n1=n1.next;
		}
		while (n2.next!=null) {
			num--;
			n1=n2.next;
		}
		if (n1!=n2) {
			//最后节点不想等，说明链表不相交
			return null;
		}
		n1=num>0?head1:head2;//n1一定是链表最长那个--------------
		n2=n1==head1?head2:head1;
		num=Math.abs(num);
		while (num!=0) {//n1先走num步----------
			n1=n1.next;
			num--;
		}
		while (n1!=n2) {
			n1=n1.next;
			n2=n2.next;
			
		}
		return n1;
	}

}
