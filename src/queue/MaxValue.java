package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * 队列中   滑动窗口的最大值
 */
public class MaxValue {
public static void main(String[] args) {
	int[] a= {2,3,4,2,6};
	ArrayList<Integer> list = maxInWindows(a,3);
	list.forEach((aa)-> System.out.println(aa));
}
	
	 public static ArrayList<Integer> maxInWindows(int[] num, int size) {
	        ArrayList<Integer> result = new ArrayList<>();

	        if(num == null || num.length == 0 || size == 0 || size > num.length) {
	            return result;
	        }

	        LinkedList<Integer> queue = new LinkedList<>();// 双端队列  存的是数组下标，不是数组元素

	        for(int i = 0; i < num.length; i++) {
	            if(!queue.isEmpty()){
	                // 如果队列头元素不在滑动窗口中了，就删除头元素
	                if(i >= queue.peek() + size) { 
	                    queue.pop();
	                }

	                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
	                while(!queue.isEmpty() && num[i] >= num[queue.getLast()]) {
	                    queue.removeLast();
	                }
	            }
	            queue.offer(i); // 入队列

	            // 滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
	            if(i-size>=-1) {
	                result.add(num[queue.peek()]);
	            }
	        }
	        return result;
	    }
}
