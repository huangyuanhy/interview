/**
 * 
 */
package dynamic;

/**
 * @author Administrator
 *2018年9月12日
 *经典的背包问题  01  c[i][m]=max{c[i-1][m-w[i]]+p[i] , c[i-1][m]}
 *   Gravity:３　４　５　
 *   Value:  4  5  6
 */
public class BackPackProblems {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] gravity= {3,4,5};
		int[] value= {4,5,6};
		solution(gravity, value,10);
	}
	public static void solution(int[] gravity,int[] value,int K) {
		int[][] arr=new int[value.length+1][K+1];//行数为物品，列数为总重量
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < K+1; j++) {
				//第0行第0列的值都为0 所以从arr[1][1]开始   
				if (j>=gravity[i-1]) {
					//只能放一次
					arr[i][j]=Math.max(arr[i-1][j],arr[i-1][j-gravity[i-1]]+value[i-1]);
					//可以重复放入
					//arr[i][j]=Math.max(arr[i][j],arr[i][j-gravity[i-1]]+value[i-1]);
				}else {
					arr[i][j]=arr[i-1][j];
				}
			}
		}
		System.out.println(arr[value.length][K]);		
	}
	
}







