/**
 * 
 */
package array;


/**
 * @author Administrator
 *2018年7月23日 求数组中给定指定和的数对
 */
public class AssignedSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a=new int[] {1,2,3,4,5,6,7,8,9,10};
		test(a, 10);
	}
	public static void test(int[] a, int sum) {
		int i=0;
		int j=a.length-1;
		
		while(i<j) {
			int A=a[i];
			int B=a[j];
			int C=A+B;
			if (C==sum) {
				System.out.println(A+"**"+B);
				i++;
				j--;
			}else if (C<sum) {
				i++;
			}else {
				j--;
			}
		}
	}
}
