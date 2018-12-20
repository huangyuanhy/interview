package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class InvertTree {
	@Test
	public void test() {
		TreeNode node=new TreeNode(1);
		TreeNode nodeleft=new TreeNode(2);
		TreeNode noderight=new TreeNode(3);
		node.left=nodeleft;
		node.right=noderight;
		
		TreeNode invertTree1 = invertTree(node);
		System.out.println(invertTree1);
	}
	
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //�ݹ鷴ת��������
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;       
       	invertTree(root.left);			  
       	invertTree(root.right);

        return root;
        
    }
	//�ݹ鷽��
	 public TreeNode invertTree1(TreeNode root) {
	        if (root == null) {
	            return null;
	        }
	        //�ݹ鷴ת��������
	        TreeNode temp = root.left;
	        root.left = invertTree1(root.right);
	        root.right = invertTree1(temp);
	        return root;
	    }
	 
	//�ڶ��ַ���
	public TreeNode invertNode(TreeNode root) {  
        if(root==null)  
            return null;          
        Queue<TreeNode> queue=new LinkedList<TreeNode>();  
        queue.add(root);  
        while(!queue.isEmpty()){  
            TreeNode current=queue.poll();  
            TreeNode temp=current.left;  
            current.left=current.right;  
            current.right=temp;  
            if(current.left!=null)  
                queue.add(current.left);  
            if(current.right!=null)  
                queue.add(current.right);  
        }  
        return root;          
    }  
	
	//�����з���
	public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//�Ƚ����ڵ�ѹ���ջ
        while (stack.size() > 0) {
     //����ջ���Ƚ������������ȡջ�����һ��Ԫ�أ���������ջ��Ԫ��
            TreeNode temp = stack.lastElement();
            stack.pop();//����ջ��Ԫ��
            
            //������������
            TreeNode tempLeft = temp.left;
            temp.left = temp.right;
            temp.right = tempLeft;

            //��������Ϊ�գ�����������ջ
            if (temp.left != null) {
                stack.push(temp.left);
            }
            //��������Ϊ�գ�����������ջ
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }


        return root;

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}