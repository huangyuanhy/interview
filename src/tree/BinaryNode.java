/**
 * 
 */
package tree;

import java.util.LinkedList;

/**
 * @author Administrator
 *2018年7月12日
 *定义节点
 */
public class BinaryNode {
	/**
	 * 利用链表来初始化二叉树    先序初始化 
	 * @param list
	 * @return
	 */
	public Node initial(LinkedList<Integer> list){
		Node root=null;
		Integer data=null;
		data= list.pop();
		if (data!=null) {
			root=new Node(data,null,null);
		}
		root.left=initial(list);
		root.right=initial(list);
		return root;
	}
}
