package tree;

import java.util.Stack;


/**
 * 二叉树的几种打印方式
 * @author Administrator
 *2018年8月22日
 */
public class PrintTree {
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node thr = new Node(3);
		Node fou = new Node(4);
		Node fiv = new Node(5);
		Node six = new Node(6);
		Node sev = new Node(7);
		one.left=two;one.right=thr;
		two.left=fou;two.right=fiv;
		thr.left=six;thr.right=sev;
		print1(one);
		System.out.println();
		postOrder1(one);

	}
	private static void print1(Node node) {
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
	public static void postOrder(Node node) {
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
	public static void postOrder1(Node node) {
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




















