package array;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组，目标和为sum, 找出所有的组合等于sum,顺序不同组合视为不同的解
 * 
 * @author pc 2021年5月16日
 */
public class N_sum3 {
	static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	static LinkedList<Integer> fuck = new LinkedList<>();

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		findList(4, 0, arr);
		System.out.print(lists);
		System.out.print(dp(arr, 4));
	}
	public static int dp(int[] arr,int target) {
		int[] dp=new int[target+1];
		dp[0]=1;
		for(int i=1;i<=target;i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i>=arr[j]) {
					dp[i]+=dp[i-arr[j]];
				}
			}
		}
		return dp[target];
	}
/**
 * 递归法
 * @param sum
 * @param index
 * @param arr
 */
	public static void findList(int sum, int index, int[] arr) {
		if (index > arr.length - 1) {
			return;
		}
		if (sum == 0) {
			ArrayList<Integer> list = new ArrayList<>();
			for (Integer num : fuck) {
				list.add(num);
			}
			lists.add(list);
		} else {
			if (sum >= arr[index]) {
				fuck.add(arr[index]);
//				findList(sum - arr[index], index, arr);// 同一组合的不同顺序算一种
				findList(sum - arr[index], 0, arr);// 同一组合的不同顺序算多种
				fuck.remove(fuck.size() - 1);
			}
			findList(sum, index + 1, arr);
		}
	}
}
