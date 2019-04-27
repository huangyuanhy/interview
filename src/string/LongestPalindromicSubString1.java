package string;

import java.util.Scanner;
/**
 * 最长回文串
 * @author Administrator
 *2018年9月19日
 */
public class LongestPalindromicSubString1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String str = scanner.nextLine();
		String longestPalindrome1 = longestPalindrome1(str);
		int len=longestPalindrome1.length();
				System.out.println(len);
	}
	public static String longestPalindrome1(String s) {
		 
		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();
		 
		// check all possible sub strings
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}
 
		return longestPalindrome;
	}
 
	public static boolean isPalindrome(String s) {
 
		for (int i = 0; i < s.length() /2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
 
		return true;
	}

}

	 
	
		
	
 
	
