/**
 * 
 */
package array;

import java.util.Arrays;

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
		System.out.println("--------------");
		int[] arr = { 1, 3, 2, 4, 5, 6 };
        int sum = 7;
        numGroup(arr, 0, arr.length, sum);
	}
	// Arrays.sort(arr);
    static int[] flag = new int[100];
    static int index = 0;// 记录当前
    public static void numGroup(int[] arr, int start, int length, int sum) {
    	if (sum == 0) {
            for (int j = 0; j < index; j++) {
                System.out.print(flag[j]+" ");
            }
            System.out.println();
        }
        else if(sum>0) {
            for (int i = start; i < length; i++) {
                flag[index++] = arr[i];
                //去掉第i个元素,求剩下元素中和为`SUM-第一个元素的值`的所有组合.
                numGroup(arr, i + 1, length-1, sum - arr[i]);
            }
        }
        index--;   //若sum<0  则表示该数不满足条件，需要index--, 因为之前假设该数满足条件 index++找该数下一个数
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
