package comprehensive;

public class seven {

	public static void main(String[] args) {
		repalce("123abcabc", "abc", "4567");

	}
private static void repalce(String str,String from,String to) {
	 String res=null;
	for (int i = 0; i <= str.length()-from.length(); i++) {
		
		String tmp=str.substring(i, i+from.length());
		boolean flag = isEquals(tmp, from);
		if (flag) {//tmp和from 字符串相等
			String s1 = str.substring(0,i);
			String s2=str.substring(i+from.length());
			str=s1+to+s2;
			System.out.println(str);
		}
	}
}
private static boolean isEquals(String str,String from) {
	int index=0;
	while (index<from.length()) {
		if (str.charAt(index)!=from.charAt(index)) {
			return false;
		}else {
			index++;
		}
	}
	return true;
}
}
