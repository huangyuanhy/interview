package chain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;


/**
 * ������ķ�ת
 * @author Administrator
 *2018��4��27��
 */
public class singleChain {
	@Test
	public void main() {
		Node top=null;
		for(int i=0;i<5;i++) {
			top=new Node(i,top);
		}
		Node node=top;	
		//�����������
		/*while(node!=null) {
			System.out.println(node.value);
			node=node.next;
			
		}*/
		//����ת����д�ӡ����
		/*Node reverse = reverse(node);
		while(reverse!=null) {
			System.out.println(reverse.value);
			reverse=reverse.next;
			
		}*/
	}
	
	
	
	public Node reverse(Node current) {  
	    //initialization  
	    Node previousNode = null;  
	    Node nextNode = null;  
	      
	    while (current != null) {  
	        //save the next node  
	        nextNode = current.next;  
	        //update the value of "next"  
	        current.next = previousNode;  
	        //shift the pointers  
	        previousNode = current;  
	        current = nextNode;           
	    }  
	    return previousNode;  
	}
	
	class Node{
		Node next=null;
		int value=0;
		Node(){
			Node next=null;
			int value=0;
		}
		Node(int value,Node node){
			this.value=value;
			this.next=node;
		}
	}
}
