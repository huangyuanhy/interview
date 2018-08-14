/**
 * 
 */
package other;

/**
 * @author Administrator
 *2018年7月26日
 *数值的整数次方
 */
public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(2, 30));
	}
	public static int power(int base,int number) {
		if (number==0) {
			return 1;
		}
		if (number==1) {
			return base;
		}
		int result=power(base, number>>1);
		result*=result;
		if ((number&0x1) ==1) {
			result*=base;
		}
		return result;
		
	}

}
