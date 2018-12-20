/**
 * 
 */
package array;

import java.util.Arrays;

/**
 * @author Administrator
 *2018年12月6日
 *数组partion的调整
 *给定有序数组，使左半部分有序，右边不管
 */
public class AjustArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,2,3,3,4,5,6,6};
		ajust(a);
	}
	private static void ajust(int[] a) {
		int[] b=new int[a.length];
		b[0]=a[0];
		int i=1,j=1;
		int k=a.length-1;//数组b的最右边
		while (j<k&&i<a.length) {
			if (a[i]==a[i-1]) {
				b[k--]=a[i++];
			}else  {
				b[j++]=a[i++];
			}
		}
		System.out.println(Arrays.toString(b));
				
	}

}
