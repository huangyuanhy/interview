/**
 * 
 */
package array;

import java.util.LinkedList;

/**
 * 滑动窗口中的最大值
 * @author Administrator
 *2018年9月10日
 *3,1,2,1,4,2,1----3 2 4 4 4
 */
public class MaxValueInWindows {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {3,1,2,1,4,2,1};
		solution(a, 3);
	}
	public static void solution(int[] a,int K) {
		if (a==null||a.length==0) {
			return ;
		}
		LinkedList<Integer> queue=new LinkedList<>();
		int index=0;
		while (index!=a.length) {
			if (queue.isEmpty()) {
				queue.addLast(index);
			}
			else {				
				while(!queue.isEmpty()&&a[queue.peekLast()]<a[index]) {
					queue.pollLast();
				}
				queue.addLast(a[index]);
				if (index-queue.peekFirst()>=K) {
					queue.pollFirst();
				}
				if (index>=2) {
					System.out.println(a[queue.peekFirst()]);
				}
			}
			index++;
		}
	}

}
