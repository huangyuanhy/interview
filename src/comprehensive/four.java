package comprehensive;
/**
 * 最小代价的编辑
 * @author Administrator
 *2018年11月22日
 */
public class four {
public static void main(String[] args) {
	char[] c2= {'a','b','c','d','f'};
	char[] c1= {'a','b','1','2','c','d','3'};
	name(c1, c2, 3, 2, 5);
}
public static void name(char[] c1,char[] c2,int dc,int rc,int ic) {
	int[][] dp=new int[c1.length+1][c2.length+1];
	for (int i = 1; i <=c1.length; i++) {
		dp[i][0]=i*dc;
	}
	for (int i = 1; i <=c2.length; i++) {
		dp[0][i]=i*ic;
	}
	for (int i = 1; i <= c1.length; i++) {
		for (int j = 1; j <= c2.length; j++) {
			if (c1[i-1]==c2[j-1]) {
				dp[i][j]=dp[i-1][j-1];
			}else {
				dp[i][j]=dp[i-1][j-1]+rc;
			}
			//采用删除的方式
			dp[i][j]=Math.min(dp[i-1][j]+dc, dp[i][j]);
			//采用插入的方式
			dp[i][j]=Math.min(dp[i][j-1]+ic, dp[i][j]);
		}
	}
	System.out.println(dp[c1.length][c2.length]);
}
}
