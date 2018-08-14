package string;
import java.util.HashMap;
/**
 * 输入字符串中，第一次只出现一次的字符
 * @author Administrator
 *  2018年8月10日
 */
public class FirstShow {
	public static void main(String[] args) {		
		
	}	   
	public static void test(String str) {
		//TreeMap<Character, Integer> map = new TreeMap<>(); treemap 这里会按照字符顺序排序，而不是出现的先后顺序排序。
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}		
		for(int i=0;i<str.length();i++){
	           char c = str.charAt(i);
	           if(map.get(c).intValue()==1) {
	        	   System.out.println(c);
		           break;
	           }
	           
	    }
	}
}
