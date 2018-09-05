/**
 * 
 */
package array;

import java.util.Random;

/**
 * @author Administrator
 *2018年8月27日
 *从N个数中等概率打印M个数
 */
public class EqualOddPrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		print(arr, 3);
	}
	public static void print(int[] arr,int M) {
		Random random=new Random();
		int index=arr.length-1;
		for(int i=1;i<=M;i++ ) {
			int nextInt = random.nextInt(index+1);
			System.out.println(arr[nextInt]);
			int tem=arr[index];
			arr[index]=arr[nextInt];
			arr[nextInt]=tem;
			index--;
		}
	}

}
