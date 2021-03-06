package chain;



import org.junit.Test;

public class sortChain {
	int[] arr= {2,3,13,2,4,2};
	@Test
	public void test(){
		
		Chain head = Chain.init(arr);
		Chain sort = sort(head);
		Chain node=distinct(sort);
		while(node!=null) {
			System.out.println(node.value);
			node=node.next;
		}
	}
	//链表排序  此种方法时从头到尾由小到大排序。
	public Chain sort(Chain head) {
		if(head == null || head.next == null) 
			return head;

		Chain cur = head, tail = cur.next;

		while(cur!=null&&cur.next!=null) {
			
			//每次结束后，current 节点一定是最小的数值
			while(cur!=null&&tail!=null) {
				if(cur.value > tail.value){
					int tmp = cur.value;
					cur.value = tail.value;
					tail.value = tmp;
				}
				tail=tail.next;
			}
			cur=cur.next;
			tail=cur.next;
		}
		return head;
	}
	//链表去重
	public Chain distinct(Chain head) {
		if (head==null&& null==head.next) {
			return head;
		}
		Chain cur=head;
		Chain tail=null;
		while (cur.next!=null) {
			tail=cur.next;
			if (cur.value==tail.value) {
				cur.next=tail.next;
			}
			cur=cur.next;
		}
		return head;
	}
	
	

}
