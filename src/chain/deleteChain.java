/**
 * 
 */
package chain;

import static org.hamcrest.CoreMatchers.nullValue;

/**
 * @author Administrator
 *2018年7月27日
 *在O1 时间内删除链表中指定节点
 */
public class deleteChain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static  void delete(Node head,Node deleted) {
		if (head!=null&&deleted!=null) {//一定要先对参数进行校验          deleted有可能不在链表中，这个逻辑的判断咩有做，需要On 的时间
			//要删除的节点不是尾戒点
			if (deleted.next!=null) {
				int value=deleted.value;
				Node tmp=deleted.next;
				deleted.value=tmp.value;//将下一个节点的值赋值给当前要删除的节点
				deleted.next=tmp.next;//如果tmp.next为空也是符合要求的
				tmp=null;
				
			}else if (deleted==head) {//两节点都相同的情况
				deleted=null;
				head=null;
				
			}else if (deleted.next==null) {//要删除的节点是尾节点
				//此时只能够遍历删除
				while(head.next!=deleted) {
					head=head.next;
				}
				head.next=null;
				deleted=null;
			} 
		}

	}

}
