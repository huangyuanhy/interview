package array;
import java.util.Arrays;
//����һ�������һ��sum������������������a+b=sum��a b
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ab {
	/**
	 * 求数组中两两之和为某一数字的全部数字对
	 */
	@Test
	public void test() {
		int[] arr= {4,3,6,3,1,8,5,0};
		int num=9;
		sum(arr, num);
		
 	}
	public void sum(int[] arr,int num) {
		Arrays.sort(arr);
		int i=0;
		int j=arr.length-1;
		int sum=0;
		while(i<j) {
			sum=arr[i]+arr[j];
			if(sum==num) {
				System.out.println(arr[i]+"-----"+arr[j]);
				j--;
			}
			else if (sum>num) {
				j--;
			}
			else {
				i++;
			}
		}
		
	
	}
}
