/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;


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
       // Node node=construct(pre, 0, pre.length-1, in, 0, in.length-1);
        //下面进行层次遍历
        Node node=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

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
	/*public static Node construct(int[] pre,int start1,int end1,int[] mid,int start2,int end2 ) {
		if (pre==null||mid==null||pre.length!=mid.length) {
			return null;
		}
		// 根据先序遍历的第一个数字先建立根节点
		Node root=new Node(pre[start1]);
		//在中序数组中找到此节点的位置
		int count=0;
		while(count<mid.length) {
			if (pre[0]==mid[count]) {
				break;
			}
			count++;
		}
		//如果咩有找到 则无法构建
		if (count>=mid.length) {
			return null;
		}
		//此时已经划分出根 左子树，右子树  递归进行构建	
		root.left=construct(pre,start1+1,start1+count-start2, mid,start2,count-1);
		root.right=construct(pre,count+1-start2+start1,end1, mid,count+1,end2);
		return root;
	}*/

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
