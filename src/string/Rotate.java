package string;

import java.util.Scanner;

import org.junit.Test;

/**
 * �ַ���  ���ƺ����Ƶ�����
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
	//------�Դ�����------
	public static void reverse1() {
		StringBuilder str=new StringBuilder("abcde");
		System.out.println(str.reverse());
	}
	//-----------�ַ���ͷβ��������
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
	//---------ѭ������indexλ�ַ���   �Ȳ��ַ�ת�������巴ת-------------
	 static String leftMove(String str,int index) {
		 if (index<=0) {
			return null;
		}
		 if (index>str.length()) {
			index=index%str.length();
		}
		String first=str.substring(0, index);//�Ƚ��ַ����س�������
		String second=str.substring(index);//�Ƚ��ַ����س�������
		first=reverse2(first);
		second=reverse2(second);
		return reverse2(first+second);
	}
	 
	 //�ж��Ƿ��ǻ��Ĵ��ַ�
	 @Test
	 public static void  huiwen() {
		 Scanner sc = new Scanner(System.in);
	       int n = sc.nextInt();//ָ��������ٸ��ַ���
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
