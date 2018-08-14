package string;

import java.util.Scanner;

import org.junit.Test;

/**
 * 字符串  左移和游移的问题
 * @author Administrator
 *
 */
public class Rotate {
	public static void  main(String[] args) {
		/*//reverse1();
		reverse2("asdfg");
		String leftMove = leftMove("12345",-8);*/
		huiwen();
	}
	//------自带方法------
	public static void reverse1() {
		StringBuilder str=new StringBuilder("abcde");
		System.out.println(str.reverse());
	}
	//-----------字符组头尾两两交换
	public static String reverse2(String str) {
		char[] arr = str.toCharArray();
		int len=arr.length;
		for(int i=0;i<len/2;i++) {
			char tem=arr[i];
			arr[i]=arr[len-1-i];
			arr[len-1-i]=tem;
		}
		return String.valueOf(arr);
	
	}
	//---------循环左移index位字符串   先部分反转，后整体反转-------------
	 static String leftMove(String str,int index) {
		 if (index<=0) {
			return null;
		}
		 if (index>str.length()) {
			index=index%str.length();
		}
		String first=str.substring(0, index);//先将字符串截成两部分
		String second=str.substring(index);//先将字符串截成两部分
		first=reverse2(first);
		second=reverse2(second);
		return reverse2(first+second);
	}
	 
	 //判断是否是回文串字符
	 @Test
	 public static void  huiwen() {
		 Scanner sc = new Scanner(System.in);
	       int n = sc.nextInt();//指定输入多少个字符串
	       System.out.println(n);
	       while(n-->0){
	           String str = sc.next();
	           boolean boo = true;
	           for(int i=0;i<str.length()/2;i++){
	               if(str.charAt(i)!=str.charAt(str.length()-i-1)){
	                   System.out.println("no");
	                   boo = false;
	                   break;
	               }
	           }
	           if(boo){
	               System.out.println("yes");
	           }            
	       }
	 }
	
}
