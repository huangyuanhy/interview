package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ͳ��һƪ������Ӣ�ĵ��ʵ�����  ��ʹ��������ʽ
public class Split {
	public static void main(String[]args) throws IOException {
		/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in) );
		String readLine = br.readLine();
		//������ʽ����
		Pattern pattern=Pattern.compile("\\b\\w+\\b");
		java.util.regex.Matcher matcher=pattern.matcher(readLine);
		int wordsCount=0;
		//��������ƥ�䣬ͳ�Ƶ�������
		while(matcher.find()) {
			wordsCount++;
		}
		System.out.println(readLine+"������"+wordsCount);*/
		
		System.out.println("---------------------------------------------");
		String text = "Hello, my name is liujianfeng";  
		System.out.println(Arrays.toString(text.split("\\s")));//�Կո�Ϊ�и��  
		System.out.println(Arrays.toString(text.split("\\W+")));//�Էǵ���Ϊ�и��  
		System.out.println(Arrays.toString(text.split("m")));//����ĸmΪ�и��  
		  
		String number = "Hello, 985 or 211, I will say ssooss";  
		System.out.println(Arrays.toString(number.split("\\d")));//������Ϊ�и��  
		System.out.println(Arrays.toString(number.split("\\D")));//�Է�����Ϊ�и��  
		System.out.println(Arrays.toString(number.split("[Ho]")));//�Է�����Ϊ�и��  
		System.out.println(Arrays.toString(number.split("1{2}")));//������1Ϊ�и�� 
	}
}
