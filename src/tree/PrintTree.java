package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 二叉树的几种打印方式
 * @author Administrator
 *2018年8月22日
 */
public class PrintTree {
	public static void main(String[] args) {
		Node head = Node.initNode();
		System.out.println("层次遍历的两种方式");
		printTree(head);
		printTree1(head);
		System.out.println("前序遍历的两种方式");
		printPre(head);
		System.out.println();
		printPre1(head);
		System.out.println();
		System.out.println("中序遍历的两种方式");
		printMid2(head);
		System.out.println();
		printMid1(head);
		System.out.println();
		printMid(head);
		System.out.println();
		System.out.println("后续遍历的两种方式");
		printPost1(head);
		System.out.println();
		printPost(head);
		System.out.println();

	}
	/**
	 * 层次遍历  按行打印
	 * @param root
	 */
	public static  void printTree(Node root) {
		if (root==null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int nodeNum=1;//当前层的数量
		int nextNum=0;//下一层的数量
		while (!queue.isEmpty()) {
			Node t = queue.peek();
			System.out.print(queue.poll().value + " ");
			nodeNum--;
			if (t.left != null) {
				queue.add(t.left);
				nextNum++;
			}
			if (t.right != null) {
				queue.add(t.right);
				nextNum++;
			}
			// 如果当前输出结点是最右结点，那么换行
			if (nodeNum == 0) {
				System.out.println();
				nodeNum= nextNum;
				nextNum=0;
			}
		}
	}
	/**
	 * 层次遍历  按行打印
	 * @param root
	 */
	public static  void printTree1(Node root) {
		if (root==null) {
			return;
		}
		Node last= root;
		Node nlast= root;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node t = queue.peek();
			System.out.print(queue.poll().value + " ");
			if (t.left != null) {
				queue.add(t.left);
				nlast = t.left;
			}
			if (t.right != null) {
				queue.add(t.right);
				nlast = t.right;
			}
			// 如果当前输出结点是最右结点，那么换行
			if (last == t) {
				System.out.println();
				last = nlast;
			}
		} 
	}
	/**
	 * 先序遍历
	 * @param node
	 */
	public static void printPre(Node node) {
		if (node==null) {
			return;
		}
		Stack<Node> stack=new Stack<>();
		while (node!=null||!stack.isEmpty()) {
			if (node!=null) {
				stack.add(node);
				System.out.print(node.value+" ");
				node=node.left;
			}else {
				node=stack.pop().right;
			}
		}
	}
	/**
	 * 先序遍历
	 * @param node
	 */
	public static void printPre1(Node node) {
		if (node==null) {
			return;
		}
		Stack<Node> stack=new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			node=stack.pop();
			System.out.print(node.value+" ");
			if (node.right!=null) {
				stack.push(node.right);
			} 
			if (node.left!=null) {
				stack.push(node.left);
			} 
		}
	}

	/**
	 * 中序遍历
	 * @param node
	 */

	public static void printMid2(Node node) {
		if (node==null) {
			return;
		}
		Stack<Node> stack=new Stack<>();
		while (node!=null||!stack.isEmpty()) {
			while (node!=null) {
				stack.add(node);
				node=node.left;
			} 
			if (!stack.isEmpty()) {
				node=stack.pop();
				System.out.print(node.value+"  ");
				node=node.right;
			}

		}
	}
	/**
	 * 中序遍历
	 * @param node
	 */
	public static void printMid1(Node node) {
		if (node==null) {
			return;
		}
		Node n=node;
		Stack<Node> stack=new Stack<>();
		stack.add(n);
		while (stack.size()!=0) {
			if (n.left!=null) {
				stack.push(n.left);
				n=n.left;
			}else {
				n = stack.pop();
				System.out.print(n.value+"  ");
				if (n.right!=null) {
					stack.push(n.right);
					n=n.right;
				}
			}
		}
	}
	/**
	 * 中序遍历
	 * @param node
	 */
	public static void printMid(Node node) {
		if (node==null) {
			return;
		}
		Stack<Node> stack=new Stack<>();
		while (node!=null||stack.size()!=0) {
			if (node!=null) {
				stack.push(node);
				node=node.left;
			}else {
				Node pop = stack.pop();
				System.out.print(pop.value+"  ");
				node=pop.right;
			}
		}
	}

	/**
	 * 后续遍历                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	 * @param node
	 */
	public static void printPost(Node node) {
		if (node==null) {
			return;
		}
		Stack<Node> stack=new Stack<>();
		stack.push(node);
		Node tmp=null;
		while (stack.size()!=0) {
			tmp=stack.peek();
			if (tmp.left!=null&&node!=tmp.left&&node!=tmp.right) {
				stack.push(tmp.left);
			}else if (tmp.right!=null&&node!=tmp.right) {
				stack.push(tmp.right);
			}else {
				System.out.print(stack.pop().value+"  ");
				node=tmp;
			}
		}

	}
	public static void printPost1(Node node) {
		if (node==null) {
			return;
		}
		Stack<Node> stack1=new Stack<>();
		Stack<Node> stack2=new Stack<>();
		stack1.push(node);
		while (!stack1.isEmpty()) {
			node=stack1.pop();
			stack2.push(node);
			if (node.left!=null) {
				stack1.push(node.left);

			}
			if (node.right!=null) {
				stack1.push(node.right);

			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().value+"  ");
		}
	}
}




















