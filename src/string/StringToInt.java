package string;

import java.util.Arrays;

/**
 * 字符串转换为整数
 * @author Administrator
 *2018年8月9日
 */
public class StringToInt {
	public static void main(String[] args) {
		Integer valueOf = Integer.valueOf("-1234");
		int parseInt = Integer.parseInt("1234");
		System.out.println(valueOf);
		System.out.println(parseInt);
		
		int[] invert = invert("1234");
		System.out.println(Arrays.toString(invert));
	}
	public static int[] invert(String str) {
		char[] charArray = str.toCharArray();
		int[] a=new int[10];
		StringBuilder stringBuilder=new StringBuilder();
		for(int i=0;i<charArray.length;i++) {
			a[i]=charArray[i];
			
		}
		return a;
	}
}
