package comprehensive;

/**
 * 最长公共子序列问题
 * @author Administrator
 *2018年11月22日
 */
public class three {
	public static void main(String[] args) {
		String s1="a1bc2";
		String s2="ab34c";
		name(s2, s1);
	}
	private static void name(String s1,String s2) {
		int row=s1.length();
		int col=s2.length();
		int[][] dp=new int[row][col];
		dp[0][0]=s1.charAt(0)==s2.charAt(0)?1:0;
		//初始化行
		for (int i = 1; i < row; i++) {		
			char c = s1.charAt(i);
			if (c==s2.charAt(0)) {
				dp[i][0]=1;			
			}
			dp[i][0]=dp[i-1][0];

		}
		//初始化列
		for (int i = 1; i < col; i++) {		
			char c = s2.charAt(i);
			if (c==s1.charAt(0)) {
				dp[0][i]=1;			
			}
			dp[0][i]=dp[0][i-1];		 
		}
		for (int i = 1; i < row; i++) {
			char c1 = s1.charAt(i);
			for (int j = 1; j < col; j++) {
				char c2 = s2.charAt(j);			
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);			
				if (c1==c2) {
					dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i][j]);
				}
			}
		}
		System.out.println(dp[row-1][col-1]);
		solution(s1, s2, dp);
	}
	/**
	 * 下面计算如何把相关的字符求出来
	 */
	private static void solution(String s1,String s2,int[][] dp) {
		StringBuilder sb=new StringBuilder();
		int i=s1.length()-1;
		int j=s2.length()-1;
		while(i>=0&&j>=0) {

			if (i>0&&dp[i][j]==dp[i-1][j]) {//上下两行相等
				i--;
			}else if (j>0&&dp[i][j]==dp[i][j-1]) {//左右两列相等
				j--;
			}
			else {
				//一定是左上角
				sb.append(s1.charAt(i));
				i--;
				j--;
			}


		}
		System.out.println(sb.reverse().toString());
	}
}

