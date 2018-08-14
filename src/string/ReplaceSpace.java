/**
 * 
 */
package string;

import static org.hamcrest.CoreMatchers.nullValue;

/**
 * @author Administrator
 *2018年7月23日
 *空格替换 we are happy -->>>we%20are%20happy 
 */
public class ReplaceSpace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(test("we are happy"));
	}
	public static String test(String str) {
		
		String[] split = str.split(" ");
		String string=null;
		for(int i=0;i<split.length;i++) {
			string+="%20"+split[i];
		}
		string=string.substring(string.indexOf("0", 1)+1);
		return string;
	}

}
