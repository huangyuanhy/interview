/**
 * 
 */
package other;

/**
 * @author Administrator
 *2018年7月25日
 *二进制中  1 的个数问题，输入一个数，输出其二进制中1 的个数   
 */
public class NumberOf1 {

	/**
	 * @param args 把一个整数减去1 再和原来的数做位与 运算，得到的结果相当于把整数的二进制表示的结果最右边的1变成0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stubc
		//System.out.println(countTest(-9));
		//System.out.println(isInteger(3));
		chagedCount(10, 13);
	}
	public static int countTest(int number) {
		int count=0;
		while (number!=0) {
			number=(number-1)&number;
			count++;
		}
		return count;
	}
	//判断是否2的幂
	public static boolean isInteger(int number) {
		
		return ((number-1)&number)==0?true:false;
	}
	//输入两个整数，计算需要改变二进制中的多少为才能变成另外一个数
	public static void chagedCount(int m ,int n) {
		m=m^n;//第一步求异或，得到有多少位1 即需要改变多少次
		int countTest = countTest(m);
		System.out.println(countTest);
	}
}
