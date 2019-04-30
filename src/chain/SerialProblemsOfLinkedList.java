package chain;


/**]
 * 链表相关问题
 * @author Administrator
 *2019年4月15日
 */
public class SerialProblemsOfLinkedList {

	public static void main(String[] args) {
		int[] arr= {4,1,5,2,1};
		Chain chain = Chain.init(arr);
		printChain(sortChain(chain));
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
		Chain fst=node;
		Chain lastNode=null;
		Chain tmp=node;
		while (tmp.next!=lastNode) {
			while (tmp.next!=lastNode) {
				tmp=tmp.next;
				if (node.value>tmp.value) {
					swap(node, tmp);
				}
				node=tmp;
			}
			lastNode=node;
			node=fst;
			tmp=fst;
		}
		return fst;
	}
	private static void swap(Chain n1,Chain n2) {
		if (n1!=null&&n2!=null) {
			Integer tmp=n1.value;
			n1.value=n2.value;
			n2.value=tmp;
		}
	}
	//合并排序过的链表
	public static Chain mergeMutiChain(Chain c1,Chain c2) {
		return c2;
		
		
	}
}









