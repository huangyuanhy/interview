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
		String s1="acedcb";
		String s2="cb";
		int length = length(s1, s2);
		System.out.println(length);
		
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
			map[c2[i]]++;
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












