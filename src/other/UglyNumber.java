/**
 * 
 */
package other;

/**
 * @author Administrator
 *2018年9月6日
 *丑数
 */
public class UglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = getUgly(6);
		System.out.println(num);
	}
	/**
	 * 
	 * @param num 第 1500个丑数
	 * @return
	 */
	public static int getUgly(int num) {
		if (num<=0) {
			return 0;
		}
		int count=0;//第几个丑数
		int index=0;//自然数
		while (count<num) {
			index++;
			if (isUgly(index)) {//如果是丑数
				count++;				
			}
		}
		return index;
	}
	
	
	public static boolean isUgly(int num) {
		while (num%2==0) {
			num/=2;
		}
		while (num%2==0) {
			num/=2;
		}
		while (num%3==0) {
			num/=3;
		}
		while (num%5==0) {
			num/=5;
		}
		return num==1?true:false;
	}

}
