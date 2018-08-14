package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//统计一篇文章中英文单词的数量  ，使用正则表达式
public class Split {
	public static void main(String[]args) throws IOException {
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in) );
		String readLine = br.readLine();
		//正则表达式对象
		Pattern pattern=Pattern.compile("\\b\\w+\\b");
		java.util.regex.Matcher matcher=pattern.matcher(readLine);
		int wordsCount=0;
		//遍历查找匹配，统计单词数量
		while(matcher.find()) {
			wordsCount++;
		}
		System.out.println(readLine+"单词数"+wordsCount);*/
		
		System.out.println("---------------------------------------------");
		String text = "Hello, my name is liujianfeng";  
		System.out.println(Arrays.toString(text.split("\\s")));//以空格为切割符  
		System.out.println(Arrays.toString(text.split("\\W+")));//以非单词为切割符  
		System.out.println(Arrays.toString(text.split("m")));//以字母m为切割符  
		  
		String number = "Hello, 985 or 211, I will say ssooss";  
		System.out.println(Arrays.toString(number.split("\\d")));//以数字为切割符  
		System.out.println(Arrays.toString(number.split("\\D")));//以非数字为切割符  
		System.out.println(Arrays.toString(number.split("[Ho]")));//以非数字为切割符  
		System.out.println(Arrays.toString(number.split("1{2}")));//以两个1为切割符 
	}
}
