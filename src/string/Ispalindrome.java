/**
 * 
 */
package string;

/**
 * @author Administrator
 *2018年8月27日
 *判断一个数是否为回文数
 */
public class Ispalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean solution = solution(12321);
		System.out.println(solution);
	}
	private static boolean solution(int num) {
		if (num==Integer.MIN_VALUE) {
			return false;
		}
		num=Math.abs(num);
		int help=1;
		while (num/help>=10) {//判断num是几位数
			help*=10;
		}
		while (num!=0) {
			if (num/help!=num%10) {
				return false;
			}
			num=(num%help)/10;
			help/=100;			
		}
		return true;
	}

}
