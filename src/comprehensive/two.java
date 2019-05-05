package comprehensive;

import java.util.Arrays;

/**
 * 最长递增子数列
 * @author Administrator
 *2018年11月22日
 */
public class two {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,1,5,3,6,4,8,9,7};
		name2(arr);
	}
	/**
	 * 动态规划，n*n的复杂度
	 * @param arr
	 */
	private static void name2(int[] arr) {
		int dp[]=new int[arr.length];//dp[i]表示以arr[i]结尾的最大递增子数组长度
		
		for (int i = 0; i < dp.length; i++) {
			dp[i]=1;//预先初始化
			for (int j = 0; j < i; j++) {
				if (arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}		
		}
		System.out.println(Arrays.toString(dp));//[1, 1, 2, 2, 3, 3, 4, 5, 4]
		
		
	}
	private String print(int[] dp,int[] arr,int index) {
		StringBuilder stringBuilder=new StringBuilder("");
		for (int i = index; i < dp.length-1; i++) {
			if (dp[i+1]==dp[i]) {
				StringBuilder tmp1=new StringBuilder();
				tmp1.append(arr[i]);
				StringBuilder tmp2=new StringBuilder();
				tmp2.append(arr[i+1]);
			}
			if (dp[i+1]==dp[i]+1) {
				System.out.print(arr[i+1]+" ");
			}
		}
		return stringBuilder.toString();
		
	}
	/**
	 * 这个方法有缺陷，不能算出所有的可能情况
	 * @param arr
	 */
	private static void name(int[] arr) {
		StringBuilder res=new StringBuilder("");
				
		for (int i = 0; i < arr.length; i++) {
			StringBuilder tmp=new StringBuilder();
			tmp.append(arr[i]);
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j]>=arr[i]&&arr[j]>=arr[j-1]) {
					tmp.append(arr[j]);
				}
			}
			if (res.length()==tmp.length()) {
				System.out.println(tmp.toString());
			}
			res=res.length()<tmp.length()?tmp:res;
			
		}
		System.out.println(res.toString());
	}

}
