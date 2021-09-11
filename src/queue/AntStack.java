package queue;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 两个队列实现栈
 * @author pc
 *2021年8月12日
 */
public class AntStack {
	Queue<Integer> q1=new LinkedList<Integer>();
			Queue<Integer> q2=new LinkedList<Integer>();
			
			public static void main(String[] args) {
				AntStack antStack = new AntStack();
				antStack.add(1);
				antStack.add(2);
				antStack.add(3);
				System.out.println(antStack.pop());
				System.out.println(antStack.pop());
				System.out.println(antStack.pop());
			}
			
	public void add(int data) {
		q1.add(data);	
	}
	public Integer pop() {
		while (!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		Integer data=q2.poll();
		while (!q2.isEmpty()) {
			q1.add(q2.poll());
		}
		return data;
	}
}
