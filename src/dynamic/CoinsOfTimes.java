/**
 * 
 */
package dynamic;


/**
 * @author Administrator
 *2018年9月4日
 *换零钱有多少种方法【5 10 25 1】 aim=100 从数组中找出和为100 有几种方法
 */
public class CoinsOfTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,10,25,1};
		int coin = coins(arr, 100);
		
		System.out.println(coin);
		
	}
	/**
	 * 动态规划
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coins(int[] arr,int aim) {
		if (arr==null||arr.length==0||aim<0) {
			return 0;
		}
		int[][] dp =new int[arr.length][aim+1];
		for (int i = 0; i < arr.length; i++) {
			//第一列表示能组成钱数为的0----1中方法
			dp[i][0]=1;
		}
		for (int j = 1;arr[0]*j<aim; j++) {
		//将第一列以后的第一行的所有列置为1 表示啊arr[0]只能组成arr[0]的倍数
			dp[0][arr[0]*j]=1;
			
		}
		int num=0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <=aim; j++) {
				num=0;
				for(int k=0;j-arr[i]*k>=0;k++) {
					num+=dp[i-1][j-arr[i]*k];
				}
				dp[i][j]=num;
			}
		}
		return dp[arr.length-1][aim];
		
	}
	/**
	 * 暴力递归法
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coin(int[] arr,int aim) {
		if (arr==null||arr.length==0||aim<0) {
			return 0;
		}
		return solution(arr,0,aim);
	}
	private static int solution(int[] arr,int index,int aim) {
		int res=0;
		if (index==arr.length) {
			res=aim==0?1:0;
		}else {
			for (int i = 0; arr[index]*i<=aim; i++) {
				res+=solution(arr, index+1, aim-arr[index]*i);
			}
		}
		return res;
	}
	/**
	 * 在上述方法的基础上，把每次重复计算的值保存起来 一边下次直接使用
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coin1(int[] arr,int aim) {
		if (arr==null||arr.length==0||aim<0) {
			return 0;
		}
		int[][] map=new int [arr.length+1][aim+1];
		return solution1(arr,0,aim,map);
	}
	private static int solution1(int[] arr,int index,int aim,int[][] map) {
		int res=0;
		if (index==arr.length) {
			res=aim==0?1:0;
		}else {
			int mapValue=0;
			for (int i = 0; arr[index]*i<=aim; i++) {
				mapValue=map[index+1][aim-arr[index]*i];
				if (mapValue!=0) {
					res=res+mapValue==-1?0:mapValue;
				}else {
					
					res+=solution1(arr, index+1, aim-arr[index]*i,map);
				}
			}
		}
		return res;
	}
}
