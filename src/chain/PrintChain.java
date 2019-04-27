/**
 * 
 */
package chain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Administrator
 *2018年7月23日
 */
public class PrintChain {

	/**
	 * @param args
	 * 从尾部到头打印单链表
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= new int[]{1,2,3,4};
		Chain node=null;
		for(int i=0;i<a.length;i++) {
			node=new Chain(a[i], node);
		}
		print(null);
		print2(null);
	}
	public static void print(Chain node) {
		if (node!=null) {
			if (node.next!=null) {
				print(node.next);
				
			}
			System.out.println(node.value);
		}

	}
	//基于桟的思想
	public static void print2(Chain node) {
		/*if (node==null) {
			throw new RuntimeException("请输入一个非空节点");
		}*/
		if (node!=null) {
			Stack<Chain> stact=new Stack<>();
			while (node!=null) {
				stact.push(node);
				node=node.next;
			}
			while (!stact.isEmpty()) {
				Chain pop = stact.pop();
				System.out.println(pop.value);
			}
		}
		
	}

}
