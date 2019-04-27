/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年9月7日
 *未排序数组正数数组中累加和为给定值K的最长子数组长度
 *【1,2,1,1,1】 K=3 ---- return 3=1+1+1
 */
public class MaxLengthOfPointedValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,1,3};
		int length = getLength1(arr, 4);
		System.out.println(length);
	}
	public static int getLength1(int[] arr,int K) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		int i=0;
		int j=0;
		int len=0;
		int sum=0;
		while (j<arr.length) {
			sum+=arr[j];
			if (sum==K) {
				len=Math.max(len, j-i+1);
				sum-=arr[i++];
				
			}else if (sum>K) {
				sum-=arr[i++];
			}
			j++;
		}
		return len;
	}
	public static int getLength(int[] arr,int K) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		int i=0;
		int j=0;
		int len=0;
		int sum=0;
		while (i<arr.length)  {
			j=i;//右指针初始位置
			while (j<arr.length) {
				sum+=arr[j];
				if (sum==K) {
					len=Math.max(len, j-i+1);
					sum=0;
					break;//此时退出循环，将左指针向右移动
				}else if(sum<K){
					j++;
				}else {					
					//如果第一个元素的值都比指定值大，那个直接i++；
					break;
				}
			}
			i++;
		}
		return len;
	}
}
