package chain;



import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;



/**
 * 锟斤拷锟斤拷桶锟�2019实习锟斤拷锟斤拷聘锟斤拷锟斤拷锟斤拷
 * 锟斤拷锟姐单锟斤拷锟斤拷锟斤拷馗锟斤拷锟斤拷锟斤拷锟� 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫★拷锟斤拷锟斤拷去锟斤拷
 * @author 锟斤拷渊
 *2018锟斤拷4锟斤拷27锟斤拷
 */
public class RepeatChain {
	int[] arr= {1,2,3,4,1,2,3,4,4,4,5,3};
	@Test
	public void test() {
		//锟斤拷始锟斤拷锟斤拷锟斤拷
		Node top = Node.init(arr);
		//锟揭筹拷锟斤拷锟斤拷锟斤拷锟截革拷锟斤拷锟斤拷锟斤拷锟斤拷值锟斤拷锟斤拷锟截革拷锟斤拷锟斤拷
		repeat(top);
		//锟斤拷锟斤拷锟斤拷锟斤拷
		Node sort = sort(top);
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		while(sort!=null) {
			System.out.println(sort.value);
			sort=sort.next;
		}
		//锟斤拷锟斤拷去锟斤拷
		Node distinct = distinct(top);
		//锟斤拷锟斤拷去锟截猴拷锟斤拷锟斤拷锟斤拷
		while(distinct!=null) {
			System.out.println(distinct.value);
			distinct=distinct.next;
		}
	}
	@Test
	public void testSort() {
		Node top =Node.init(arr);
		Node sort = sort(top);
		while(sort!=null) {
			System.out.println(sort.value);
			sort=sort.next;
		}
	}
	
	//锟斤拷始锟斤拷锟斤拷锟斤拷

	//锟揭筹拷锟斤拷锟斤拷锟斤拷锟截革拷锟斤拷锟斤拷锟斤拷锟斤拷值锟斤拷锟斤拷锟截革拷锟斤拷锟斤拷
	public void repeat(Node top) {			
		Node node=top;
		//锟斤拷一锟斤拷integer锟角憋拷示锟斤拷锟斤拷锟叫碉拷值锟斤拷锟节讹拷锟斤拷锟角憋拷示锟截革拷锟侥达拷锟斤拷
		Map<Integer,Integer> map=new HashMap(16);
		int key=0;//锟斤拷示锟斤拷锟斤拷锟叫碉拷值
		int count=0;//锟斤拷示锟截革拷锟侥达拷锟斤拷
		while(node!=null) {
			key=node.value;
			if (map.containsKey(key)) {
				count=map.get(key)+1;
				map.replace(key, count);
			}
			else {
				map.put(key,1);	
			}
			node=node.next;
		}
		//锟斤拷锟斤拷锟斤拷锟酵筹拷锟�
		Collection<Integer> values = map.values();
		Integer max = Collections.max(values);//锟斤拷锟斤拷馗锟斤拷锟斤拷锟斤拷锟街�
		Set<Integer> keySet = map.keySet();
		
		for(Integer value:keySet) {
			Integer integer = map.get(value);
			System.out.println(value+"---"+integer);
			if (integer==max) {
				System.out.println("锟截革拷锟斤拷锟斤拷锟斤拷锟斤拷锟角节碉拷锟斤拷值为"+value+"---"+"锟斤拷锟截革拷锟斤拷锟斤拷为锟斤拷"+integer);
			}
		}
	}
	
	//冒锟斤拷锟斤拷锟斤拷
	public Node sort(Node head){
		if(head == null || head.next == null)  //锟斤拷锟斤拷为锟秸伙拷锟竭斤拷锟叫碉拷锟斤拷锟斤拷锟�
			return head;

		Node cur = null, tail = null;

		cur = head;

		while(cur.next != tail){
			while(cur.next != tail){
				if(cur.value > cur.next.value){
					int tmp = cur.value;
					cur.value = cur.next.value;
					cur.next.value = tmp;
				}
				cur = cur.next;
			}

			tail = cur;  //锟斤拷一锟轿憋拷锟斤拷锟斤拷尾锟斤拷锟斤拷堑锟角帮拷锟斤拷(锟斤拷细锟斤拷磨一锟斤拷锟斤拷锟斤拷牡锟斤拷锟�)
			cur = head;     //锟斤拷锟斤拷锟斤拷始锟斤拷锟斤拷锟斤拷锟轿凤拷锟斤拷    
		}
		
		
		

		return head;
	}
	//锟斤拷锟斤拷去锟斤拷
	public Node distinct(Node top) {
		
		//锟斤拷锟斤拷锟斤拷
		Node sort = sort(top);
		
		Node node=sort;
		Node current=null;
		while(node!=null) {
			current=node.next;
			if (current!=null&&current.value==node.value) {
				node.next=current.next;
			}else {
				node=current;
			}
		}
		return sort;
	}
}

