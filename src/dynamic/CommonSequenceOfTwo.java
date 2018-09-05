/**
 * 
 */
package dynamic;

import java.util.Arrays;

/**
 * @author Administrator
 *2018年9月5日
 *最长公共子串  要是连续的e
 */
public class CommonSequenceOfTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c1= {'b','e','b','c','d'};
		char[] c2= {'a','b','c','d','e'};
		char[] solution = solution(c1, c2);
		System.out.println(Arrays.toString(solution));
	}
	public static char[] solution(char[] c1,char[] c2) {
		if (c1==null||c2==null||c1.length==0||c2.length==0) {
			return null;
		}
		int[][] dp=new int[c1.length][c2.length];
		for (int i = 0; i < c1.length; i++) {
			dp[i][0]=c2[0]==c1[i]?1:0;
		}
		for (int j = 0; j < c2.length; j++) {
			dp[0][j]=c2[j]==c1[0]?1:0;
		}
		for (int i = 1; i < c1.length; i++) {
			for (int j = 1; j < c2.length; j++) {
				if (c1[i]==c2[j]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}				
			}
		}
		
		//找出最大值
		int max=0;
		int end=0;
		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (dp[i][j]>max) {
					max=dp[i][j];
					end=i;
				}
			}
		}
				
		char[] copyOfRange = Arrays.copyOfRange(c2, end-max, end);
		return copyOfRange;
	}
}
