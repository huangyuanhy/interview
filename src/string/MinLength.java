/**
 * 
 */
package string;

/**
 * @author Administrator
 *2018年8月28日
 *最小包含子串的长度 str1= abcde    str2= ac----->abc    3
 */
public class MinLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="12345";
		String s2="344";
		/*int length = length(s1, s2);
		System.out.println(length);*/
		name(s1, s2);
	}
	public static void name(String s1,String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int row=c2.length;
		int col=c1.length;
		int begin=0;
		int lastEnd=0;
		int end=0;
		int min=Integer.MAX_VALUE;
		int first=0;
		int[][] arr=new int[row][col];
		boolean[] flag=new boolean[c2.length];
  		for (int i = 0; i < row; i++) {
			for (int j = first; j < col; j++) {
				if (c1[j]==c2[i]) {
					arr[i][j]=1;
					first=first==0?1:0;
					flag[i]=true;
				}
			}
			first=0;
		}
		for (boolean b:flag) {
			if (!b) {
				System.out.println("不包含子串");
				return;
			}
		}
		for (int i = 0; i < c2.length; i++) {
			for (int j = 0; j < c1.length; j++) {
				
			}
		}
		for (int i = 0; i < col; i++) {
			if (arr[row-1][i]==1) {
				end=i;
				for (int j = i; j >=lastEnd; j--) {
					if (arr[0][j]==1) {
						begin=j;
						min=Math.min(min, end-begin+1);
						lastEnd=i;
						break;//退出当前循环
					}
				}
			}
		}
		System.out.println(min);
	}
	/**
	 * 
	 * @param s1  第一个字符串
	 * @param s2 第二个字符串
	 * @return 最小长度
	 */
	public static int length(String s1,String s2) {
		if (s1==null||s2==null||s1.length()<s2.length()) {
			return 0;
		}
		int left=0;
		int right=0;
		int minLen=Integer.MAX_VALUE; //返回的最小长度
		int match=s2.length();//表示还要匹配多少个字符
		int[] map=new int[256];
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		
		for (int i = 0; i < c2.length; i++) {
			map[c2[i]]++;//这个很妙，用字符做下标，最多为256的长度，避免用map集合
		}
		while (right<c1.length) {
			map[c1[right]]--;
			if (map[c1[right]]>=0) {
				match--; 
			}
			if (match==0) {
				while (map[c1[left]]<0) {
					map[c1[left++]]++;
				}
				minLen=Math.min(minLen, right-left+1);
				match++;
				map[c1[left++]]++;
			}
			right++;

		}

		return minLen==Integer.MIN_VALUE?0:minLen;
	}

}












