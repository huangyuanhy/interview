package comprehensive;
/**
 * 字符串是否为旋转词
 * @author Administrator
 *2018年11月23日
 */
public class five {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="2ab1";
		String s2="ab12";
		solution(s1, s2);
	}
private static void solution(String s1,String s2) {
	 
	StringBuilder stringBuilder=new StringBuilder();
	for (int i = 0; i < s1.length(); i++) {
		String tmp=s1.substring(i)+s1.substring(0, i);
		if (tmp.equals(s2)) {
			System.out.println(true);
			return;
		};
	}
	System.out.println(false);
}
}
