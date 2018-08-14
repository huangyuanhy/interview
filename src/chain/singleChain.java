package chain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;


/**
 * 单链表的反转
 * @author Administrator
 *2018年4月27日
 */
public class singleChain {
	@Test
	public void main() {
		Node top=null;
		for(int i=0;i<5;i++) {
			top=new Node(i,top);
		}
		Node node=top;	
		//正向遍历链表
		/*while(node!=null) {
			System.out.println(node.value);
			node=node.next;
			
		}*/
		//链表反转后进行打印遍历
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
