/**
 * 
 */
package dynamic;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Administrator
 *2018年9月4日
 *最长递增子序列 2 1 5 3 6 4 8 9 7-----1 3 4 8 9/2 5 6 8 9/1 5 6 8 9
 */
public class Longest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= { 2,1 ,5 ,3, 6,8,9,7};
		
		LinkedList<Integer> linkedList=new LinkedList<>();
		int index=0;
		while(index<arr.length) {
			int[] c = Arrays.copyOfRange(arr, index, arr.length);
			linkedList = recrusive(c, linkedList);
			index++;
		}
		for(Integer num:linkedList) {
			System.out.println(num);
		}
	}
	
	/**
	 * @param arr
	 * @param linkedList
	 */
	private static LinkedList<Integer> recrusive(int[] arr, LinkedList<Integer> linkedList) {
		LinkedList<Integer> list=new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (list.size()==0) {
				list.add(arr[i]);
			}else {	
				Integer peek = list.getLast();
				if(peek<arr[i])
				list.add(arr[i]);
			}
		}
		return linkedList.size()>list.size()? linkedList:list;
	}

}
