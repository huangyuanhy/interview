package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 二叉树的相关题目
 * @author Administrator
 *2019年4月1日
 */
public class SerialProblemsOfTree {
	public static void main(String[] args) {
		Node head = Node.initNode();
		SerialProblemsOfTree instance = new SerialProblemsOfTree();
		instance.findAllPath(head, 10);
	}
	//二叉树的最大深度
	public int maxDeepth(Node node) {
		if (node==null) {
			return 0;
		}
		int left=maxDeepth(node.left);
		int right=maxDeepth(node.right);
		return Math.max(left, right)+1;// 这里的1 指的就是当前节点的高度为1 
	}
	//二叉树的节点个数
	public int numsOfNode(Node node) {
		if (node==null) {
			return 0;
		}
		int left=numsOfNode(node.left);
		int right=numsOfNode(node.right);
		return left+right+1;
	}
	//二叉树叶子节点的个数
	public int numsOfLeafNode(Node node) {
		if (node==null) {
			return 0;
		}
		if (node.left==null&&node.right==null) {
			return 1;
		}
		return numsOfLeafNode(node.left)+numsOfLeafNode(node.right);
	}
	//二叉树第K层节点的个数
	public int numsOfKthLevel(Node node,int k) {
		if (node==null||k<1) {
			return 0;
		}
		if (k==1) {
			return 1;
		}
		return numsOfKthLevel(node.left, k-1)+numsOfKthLevel(node.right, k-1);
	}
	//判断二叉树是否是平衡二叉树
	public boolean isBalancedTree(Node node) {
		return maxDeepth2(node)!=-1;
	}
	int maxDeepth2(Node node){
		if(node == null){
			return 0;
		}
		int left = maxDeepth2(node.left);
		int right = maxDeepth2(node.right);
		if(left==-1||right==-1||Math.abs(left-right)>1){
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	//判断二叉树是否是平衡二叉树
	public boolean isBalancedTree1(Node node) {
		if (node==null) {
			return true;
		}
		int left = maxDeepth(node.left);
		int right = maxDeepth(node.right);
		if (Math.abs(right-left)<=1) {
			return isBalancedTree1(node.left)&&isBalancedTree1(node.right);
		}else {
			return false;
		}
	}
	/*
	 * 二叉树是否是完全二叉树
	 * 层次遍历二叉树
		1 任何一个结点如果右孩子不为空，左孩子却是空，则一定不是完全二叉树
		2 当一个结点出现右孩子为空时候，判断该结点的层次遍历后继结点是否为叶子节点，如果全部都是叶子节点，则是完全二叉树;
			如果存在任何一个结点不是叶节点，则一定不是完全二叉树。
	 */
	public boolean isCompleteBinaryTree(Node node) {
		if (node==null) {
			return false;
		}
		Queue<Node> queue=new LinkedList<>();
		boolean hasRightChild=true;//当前节点有右孩子，默认
		queue.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (!hasRightChild&&(cur.left!=null||cur.right!=null)) {
				// 如果之前层遍历的结点没有右孩子，且当前的结点有左或右孩子，直接返回false
				return false;
			}

			if (cur.right!=null&&cur.left==null) {
				// 如果当前结点有右孩子却没有左孩子，直接返回false
				return false;
			}    

			if (cur.left!=null) {
				queue.add(cur.left);
			}
			if (cur.right!=null) {
				queue.add(node.right);
			}else { 
				// 如果当前结点没有右孩子，那么之后层遍历到的结点必须为叶子结点
				hasRightChild=false;
			}
		}
		return true;
	}
	//两个二叉树是否完全相同
	public boolean isSameTree(Node node1,Node node2) {
		if (node1==null&&node2==null) {
			return true;
		}
		if (node1==null||node2==null) {
			return false;
		}
		if (node1.value!=node2.value) {
			return false;
		}
		return isSameTree(node1.left, node2.left)
				&&isSameTree(node1.right, node2.right);
	}
	//两个二叉树是否互为镜像
	public boolean isMirroredTree(Node node1,Node node2) {
		if (node1==null&&node2==null) {
			return true;
		}
		if (node1==null||node2==null) {
			return false;
		}
		if (node1.value!=node2.value) {
			return false;
		}
		return isMirroredTree(node1.left,node2.right)&&
				isMirroredTree(node1.right,node2.left);
	}
	//反转二叉树||镜像二叉树
	public Node reverse(Node node) {
		if (node==null) {
			return null;
		}
		Node tmp=node.left;
		node.left=reverse(node.right);
		node.right=reverse(tmp);
		return node;
	}
	//反转二叉树||镜像二叉树
	public Node reverse1(Node node) {
		if (node==null) {
			return null;
		}
		Node left=reverse(node.left);
		Node right=reverse(node.right);
		node.left=right;
		node.right=left;
		return node;
	}
	//两个二叉树的最近公共祖先节点  -----方案一
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		//发现目标节点则通过返回值标记该子树发现了某个目标结点 
		if(root == null || root == p || root == q) 
			return root; 
		//查看左子树中是否有目标结点，没有为null 
		Node left = lowestCommonAncestor(root.left, p, q);
		//查看右子树是否有目标节点，没有为null 
		Node right = lowestCommonAncestor(root.right, p, q); 
		//都不为空，说明做右子树都有目标结点，则公共祖先就是本身 
		if(left!=null&&right!=null) return root;
		//如果发现了目标节点，则继续向上标记为该目标节点 
		return left == null ? right : left; 
	} 

	//两个二叉树的最近公共祖先节点-----方案二
	public Node lowestCommonAncestor1(Node root,Node node1,Node node2) {
		if (findNode(root.left, node1)) {
			if (findNode(root.right, node2)) {
				//如果节点一在左子树中，节点二在右子树中，返回根节点
				return root;
			}else {
				//如果节点一、节点二都在左子树中，那么在左子树递归找
				return lowestCommonAncestor1(root.left, node1, node2);
			}
		}else {
			if (findNode(root.left, node2)) {
				//如果节点一在右子树中，节点二在左子树中，返回根节点
				return root;
			}else {
				//如果节点一、节点二都在右子树中，那么在右子树递归找
				return lowestCommonAncestor1(root.right, node1, node2);
			}
		}
	}
	/**
	 * 查找root 中是否包含 target 节点
	 * @param root
	 * @param target
	 * @return
	 */
	boolean findNode(Node root,Node target) {
		if (root==null||target==null) {
			return false;
		}
		if (root==target) {
			return true;
		}
		boolean flag=findNode(root.left, target);
		if (!flag) {
			flag=findNode(root.right, target);
		}
		return flag;
	}
	//输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数所有的路径
	public void findAllPath(Node node,int K){
		if (node==null) {
			return;
		}
		Stack<Integer> path=new Stack<>();//记录路径值
		find(node, K, 0, path);
	}
	void find(Node node,int K,int curSum,Stack<Integer> path) {
		if (node==null) {
			return;
		}
		curSum+=node.value;
		path.push(node.value);
		if (K==curSum) {
			for (Integer integer : path) {
				System.out.print(integer+"  ");
				System.out.println();
			}
		} 
		find(node.left, K, curSum, path);
		find(node.right, K, curSum, path);
		 
		path.pop();
	}
	//输入一个二叉树和一个整数，打印出二叉树中节点值的和等于输入整数最大路径长度
	public int findMaxLength(Node node,int K) {
		// key={curSum，当前层的所有和},value={level 当前的层数}
		HashMap<Integer, Integer> sumMap=new HashMap<>();
		sumMap.put(0, 0);//最开始的时候，累加和为0 ，不包括任何节点
		return preOrder(node,K,0,1,0,sumMap);//先序遍历
	}
	/**
	 * 
	 * @param node 当前节点
	 * @param sum 给定数字
	 * @param preSum 上一节点的所有和
	 * @param level 当前节点的层数
	 * @param maxLenth 满足条件最大长度
	 * @param sumMap {key=[curSum，当前层的所有和],value=[level 当前的层数]}
	 * @return 满足条件最大长度
	 */
	private int preOrder(Node node, int sum, int preSum, int level, int maxLenth, HashMap<Integer, Integer> sumMap) {
		if (node==null) {
			return maxLenth;
		}
		int curSum=preSum+node.value;
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		if (sumMap.containsKey(curSum-sum)) {
			Math.max(level-sumMap.get(curSum-sum),maxLenth);
		}
		maxLenth=preOrder(node.left, sum, curSum, level+1, maxLenth, sumMap);
		maxLenth=preOrder(node.right, sum, curSum, level+1, maxLenth, sumMap);
		if (level==sumMap.get(curSum)) {
			sumMap.remove(curSum);
		}
		return maxLenth;
	}
}
















