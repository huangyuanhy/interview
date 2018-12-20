/**
 * 
 */
package array;

import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 最长的可整合子数组的长度
 * @author Administrator
 *2018年9月7日
 */
public class SubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,5,3,2,6,4,3};
		int c1 = getSubArray2(arr);
		int c2 = getSubArray(arr);
		System.out.println(c1);
		System.out.println(c2);
	}
	public static int getSubArray2(int[] arr) {
		int count=0;
		int max=0;
		int min=0;
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) {
				if (set.contains(arr[j])) {//如果有重复元素肯定不是整合数组
					break;
				}
				set.add(arr[j]);
				max=Math.max(max, arr[j]);
				min=Math.min(min, arr[j]);
				if (max-min==j-i) {
					count=Math.max(count, j-i+1);
				}
			}
			set.clear();
		}
		return count;
	}
	/**
	 * 第一种方法排序判断
	 * @param arr
	 * @return
	 */
	public static int getSubArray(int[] arr) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		int len=arr.length;
		int count=0;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (isIntegrated(arr, i, j)) {
					count=Math.max(count, j-i+1);
				}
			}
		}
		return count;
	}
	private static boolean isIntegrated(int[] arr,int i,int j) {
		int[] copy = Arrays.copyOfRange(arr, i, j+1);//此方法是左闭右开
		Arrays.sort(copy);
		for (int k = 1; k < copy.length; k++) {
			if (copy[k-1]!=copy[k]-1) {
				return false;
			}
		}
		return true;
	}

}
