package tree;

 
import java.util.Stack;

/**
 * 
 * <p>Title: ConvertTreeToLinkedList</p>  
 * <p>Description: 二叉搜索树转化为双向链表 </p>  
 * @author huangyuan  
 * @date 2019年1月3日
 */
public class ConvertTreeToLinkedList {

	public static void main(String[] args) {
		Node root=new Node(4);
		Node left1=new Node(2);
		Node right1=new Node(5);
		root.left=left1;
		root.right=right1;
		Node left2=new Node(1);
		Node right2=new Node(3);
		left1.left=left2;
		left1.right=right2;

		Node convertToLinkedList = convertToLinkedList(root);
		while (convertToLinkedList!=null) {
			System.out.println(convertToLinkedList.value);
			convertToLinkedList=convertToLinkedList.right;
		}
	}
	/**
	 * 
	 * <p>Title: convertToLinkedList</p>  
	 * <p>Description:  根据 中序遍历二叉树  来生成双向链表</p>  
	 * @param root 给定的根节点
	 * @return 返回链表的第一个节点
	 */
	public static Node convertToLinkedList(Node root) {
		if (root==null) {
			return null;
		}
		Node listNode=null;//返回链表的第一个节点
		Node curNode=root;
		Stack<Node> stack=new Stack<Node>();
		Node preNode=null;//前一个节点
		while (curNode!=null||stack.size()>0) {
			if (curNode!=null) {
				stack.add(curNode);
				curNode=curNode.left;
			}
			else {
				//左节点遍历完毕 弹出 
				curNode = stack.pop();

				if (preNode==null) {//最开始的时候 preNode为空
					preNode=curNode;
					listNode=preNode;
				}else {
					preNode.right=curNode;//preNode的下一个节点 为当前节点
					curNode.left=preNode;//当前节点的上一个节点为preNode节点
					preNode=curNode;//重新将当前节点置为上一节点
				}
				curNode=curNode.right;
			}
		}
		return listNode;
	}

}
