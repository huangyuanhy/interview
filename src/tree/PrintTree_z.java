package tree;

import java.util.Stack;

/**
 * 之字形打印树节点
 * @author Administrator
 *2018年8月3日
 */
public class PrintTree_z {
	
	
	
	public void printTree_z(Node root) {
		if (root!=null) {
			Stack<Node>[] stacks=null;
			int cur=0;
			int next=1;
			
			stacks[cur].push(root);
			while(!stacks[0].empty()||!stacks[1].empty()) {
				Node node=stacks[cur].pop();
				System.out.println(node.value);
				
				if (cur==0) {//先左后右
					if (node.left!=null) {
						stacks[next].push(node.left);
					}
					if (node.right!=null) {
						stacks[next].push(node.right);
					}
				}else {//先右后左
					if (node.right!=null) {
						stacks[next].push(node.right);
					}
					if (node.left!=null) {
						stacks[next].push(node.left);
					}
					
				}
				if (stacks[cur].empty()) {
					cur=1-cur;
					next=1-next;
				}
			}
			
		}
	}
}
