/**
 * 
 */
package string;
/**
 * @author Administrator
 *2018年8月28日
 *字符串的替换 a b  c ---->a%20b%20%20c
 *字符串的调整   123***45----->***12345
 */
public class Repalce {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="123***45";
		String repalce = replan(str);
		System.out.println(repalce);
	}
	public static String replan(String str) {
		char[] cs=new char[str.length()];
		int k=str.length()-1;
		int i=k;
		while (i>=0) {
			if (str.charAt(i)!='*') {
				cs[k--]=str.charAt(i);
			}
			i--;
		}
		while (k>=0) {
			cs[k--]='*';
		}
		return new String(cs);
	}
	/**
	 * 字符串的替换
	 * @param str
	 * @return
	 */
	public static String repalce(String str) {
		char[] c = str.toCharArray();

		StringBuilder sd=new StringBuilder();
		for(char cc:c) {
			if (cc==' ') {
				sd.append("%20");
			}else {
				sd.append(cc);
			}
			
		}
		return sd.toString();
	}

}
