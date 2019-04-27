/**
 * 
 */
package chain;

/**
 * @author Administrator
 *2018年8月22日
 *删除指定节点，且不给定头节点
 */
public class DeleteNode {
	public static void main(String[] args) {
		int[] a= {10,9,8,7,6,5,4,3,1,1};
		Chain n = Chain.init(a);
		Chain delete = delete(n);
		System.out.println(n.value);
	}
	private static Chain delete(Chain n) {
		if (null==n||n.next==null) {
			throw new RuntimeException("节点为空或者节点为最后一个，无法删除");
			
		}
		Chain next=n.next;
		while (n.value==next.value) {
			n.next=next.next;
			next=n.next;
		}		
		n.value=next.value;
		n.next=next.next;
		return n;
	}
}
