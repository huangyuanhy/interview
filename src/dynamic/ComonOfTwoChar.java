/**
 * 
 */
package dynamic;

import java.util.Arrays;

/**
 * @author Administrator
 *2018年9月5日
 *最长公共子序列  序列不需要连续
 */
public class ComonOfTwoChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c1= {'1','A','B','2','3','4','5','C','D'};
		char[] c2= {'1','2','3','4','5','E','F'};
		char[] res = solution(c1, c2);
		System.out.println(Arrays.toString(res));
	}
	public static char[] solution(char[] c1,char[] c2) {
		if (c1==null||c2==null||c1.length==0||c2.length==0) {
			return null;
		}
		int[][] dp=new int[c1.length][c2.length];
		dp[0][0]=c1[0]==c2[0]?1:0;
		for (int i = 1; i < c1.length; i++) {
			//第一列初始化
			dp[i][0]=Math.max(c2[0]==c1[i]?1:0, dp[i-1][0]);
		}
		for (int j = 1; j< c2.length; j++) {
			//第一行初始化
			dp[0][j]=Math.max(c1[0]==c2[j]?1:0, dp[0][j-1]);
		}
		//其他行为dp[i-1][j],dp[i][j-1],dp[i-1][j-1]三者中的最大值
		for (int i = 1; i < c1.length; i++) {
			for (int j = 1; j < c2.length; j++) {
				dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				if (c1[i]==c2[j]) {
					dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i][j]);
				}
			}

		}

		//return dp[c1.length-1][c2.length-1];//返回的是最大长度
		char[] res = getChar(c1, c2, dp);
		return res;
	}
	public static char[] getChar(char[] c1,char[] c2,int[][] dp) {
		int row=dp.length-1;
		int col=dp[0].length-1;
		char[] res=new char[dp[row][col]];
		int k=res.length-1;
		while (k>=0) {//col>=0&&row>=0
			if (col>0&&dp[row][col]==dp[row][col-1]) {
				col--;
			}else if (row>0&&dp[row][col]==dp[row-1][col]) {
				row--;
			}else {				
				res[k--]=c1[row];
				row--;
				col--;
			}
		}
		return res;
	}

}
