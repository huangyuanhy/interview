/**
 * 
 */
package array;


/**
 * 为排序数组中累加和为给定值得最大子数组系列问题
 * @author Administrator
 *2018年8月23日
 */
public class MaxLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,1,1,1};
		int maxLength = getMaxLength(arr, 3);
		System.out.println(maxLength);
	}
	/**
	 * 此方法探究是数组中全为正数的情况
	 * @param arr 给定的数组参数
	 * @param K 指定和
	 * @return 最大长度
	 */
	public static int getMaxLength(int[] arr,int K) {
		if (arr==null||arr.length==0||K<=0) {
			return 0;
		}
		int left=0;
		int right=0;
		int sum=arr[0];
		int len=0;
		while (right<arr.length) {
			if (sum==K) {
				len=Math.max(len, right-left+1);
				sum-=arr[left++];
			}else if (sum<K) {
				right++;
				if (right==arr.length) {
					break;
				}
				sum+=arr[right];
			}else {
				sum-=arr[left++];
			}
		}
		return len;
	}
	/**
	 * 给定数组中有正有负数和0       求正数和负数个数相等的最大子数组长度
	 * @param arr
	 * @return
	 */
	public static int getMaxLenthAmount(int[] arr) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		int minus=0;//负数的个数
		int plus=0;//正数的个数
		int length=0;//最大长度
		int left =0;//左下标
		int right=0;//右下标
		minus=arr[right]<0?1:0;
		plus=minus==1?0:1;
		while (right<arr.length) {
			if (plus==minus) {
				length=Math.max(length, right-left+1);
				right++;
			}else if (plus>=minus) {
				length=Math.max(length, right-left+1);
				right++;
			}    
		}
		return 0;
	}

}
