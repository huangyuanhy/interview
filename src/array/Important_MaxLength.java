/**
 * 
 */
package array;

import java.util.HashMap;
import java.util.Set;

/**
 * 未排序数组中累加和为给定值得最大子数组系列问题
 * @author Administrator
 *2018年8月23日
 */
public class Important_MaxLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,3};
		//未排序数组正数数组中累加和为给定值K的最长子数组长度
		int maxLength = getMaxLength(arr, 3);
		System.out.println(maxLength);
		System.out.println("-------------");
		
		//给定数组中有正有负数和0      求所有子数组中累加和为K的最长子数组长度
		System.out.println(getMaxLengthOfK(arr, 6));
		//给定数组中有正有负数和0      求正数和负数个数相等最长子数组的长度
		int[] arr1= {1,1,0,-1,1,-1,0,1};
		System.out.println(getMaxLenthAmount(arr1));
		
		//元素只能是1 0 求数组中所有子数组中0 1 个数相等的最长子数组长度
		int[] arr2= {0,1,1,1,1,0,1,0};
		System.out.println(getMaxLength(arr2));
		System.out.println("-------------");
		System.out.println(getMaxLengthOfSmallerThanK(arr,6));
		System.out.println("-------------");
		maxSum(new int[]{1,-2,3,5,-2,6,-1});
	}
	/**
	 *未排序数组正数数组中累加和为给定值K的最长子数组长度
     *【1,2,1,1,1】 K=3 ---- retrun 3=1+1+1
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
	 * 给定数组中有正有负数和0      求所有子数组中累加和为K的最长子数组长度
	 * @param arr
	 * @param K
	 * @return
	 * ------------这个算法流弊了------------------------
	 */
	public static int getMaxLengthOfK(int[] arr,int K) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		HashMap<Integer, Integer> map=new HashMap<>();
		map.put(0, -1);//最开始的状态 key是sum的值，value是sum值第一次出现的位置
		int len=0;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if (map.containsKey(sum-K)) {
				len=Math.max(i-map.get(sum-K), len);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return len;
	}
	/**
	 * 给定数组中有正有负数和0       求正数和负数个数相等的最大子数组长度
	 * 将正数变为1 负数变为-1,0不变，然后求累加和为0的最长子数组长度
	 * @param arr
	 * @return
	 */
	public static int getMaxLenthAmount(int[] arr) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]<0) {
				arr[i]=-1;
			}else if (arr[i]>0) {
				arr[i]=1;
			}
		}		
		return getMaxLengthOfK(arr, 0);
	}
	/**
	 * 给定一个无序数组，元素只能是1 0 求数组中所有子数组中0 1 个数相等的最长子数组长度。
	 * 把数组中0 全部变成-1 然后求累加和为0的最长子数组长度
	 * @param arr
	 * @return
	 */
	public static int getMaxLength(int[] arr) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==0) {
				arr[i]=-1;
			}
		}return getMaxLengthOfK(arr, 0);
	}
	/**
	 * 求所有子数组中累加和小于或者等于K的最长子数组长度
	 * @param arr
	 * @return
	 */
	public static int getMaxLengthOfSmallerThanK(int[] arr,int K) {
		if (arr==null||arr.length==0) {
			return 0;
		}
		HashMap<Integer, Integer> map=new HashMap<>();
		map.put(0, -1);//最开始的状态 key是sum的值，value是sum值第一次出现的位置
		int len=0;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			for(Integer s:map.keySet()) {
				if (s>=sum-K) {
					len=Math.max(i-map.get(s), len);
				}
			}
			
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return len;
	}
	/**
	 * 子数组最大累加和
	 * @param a
	 */
	private static void maxSum(int[] a) {
		int i=0,j=1;
		int sum=a[i],tmp=a[i];
		while (j<a.length) {
			tmp+=a[j++];
			if (tmp<0) {
				tmp=0;
				i=j;
			}
			else if (sum<=tmp) {
				sum=tmp;
			}
		}
		System.out.println(sum);
		for (int k = i; k < a.length; k++) {
			System.out.println(a[k]);
			if ((sum-=a[k])==0) {
				return;
			}
		}
	}
}




















