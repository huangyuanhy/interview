/**
 * 
 */
package tree;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 各种遍历（Traverse）二叉树
 * @author Administrator
 *2018年7月12日
 */
public class TraverseBinaryTree {
	
	
	
	//二叉树初始化
	public BinaryNode create(){
		LinkedList<Integer> list=new LinkedList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		BinaryNode binaryNode = new BinaryNode();
		binaryNode.initial(list);
		return binaryNode;
	}
	
	@Test
	public void test() {
		BinaryNode create = this.create();
		
		System.out.println(create);
	}
}
