/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

import array.intersect;


/**
 * @author Administrator
 *2018年7月23日
 */
public class Reconstruct {

	/**
	 * @param args
	 * 二叉树的重构   根据前序遍历及中序遍历的两个数组
	 */
	public static void main(String[] args) {
		int[] pre = {1, 2,4,7,3,5,6,8};
		int[] in = { 4,7,2,1,5,3,8,6};

		Node node=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
		//下面进行层次遍历
		orderPrint(node);
	}
	/**
	 * @param node 二叉树层次遍历
	 */
	private static void orderPrint(Node node) {
		Queue<Node> queue=new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node cur=queue.poll();
			System.out.println(cur.value);
			if (cur.left!=null) {
				queue.add(cur.left);
			}
			if (cur.right!=null) {
				queue.add(cur.right);
			}
		}
	}
	// 根据前序遍历和中序遍历重构二叉树
	private static Node reConstructBinaryTree(
			int[] pre,int startPre,int endPre,int[] in,int startIn, int endIn) {
		//参数校验
		if(startPre>endPre||startIn>endIn)
			return null;
		//构建根节点
		Node root=new Node(pre[startPre]);

		for(int i=startIn;i<=endIn;i++)
			if(in[i]==pre[startPre]){//找到中序遍历中的根节点 
				root.left=reConstructBinaryTree(
						pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right=reConstructBinaryTree(
						pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
			}

		return root;
	}
}



















