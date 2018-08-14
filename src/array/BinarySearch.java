/**
 * 
 */
package array;

import java.util.Arrays;

/**
 * @author Administrator
 *2018年7月25日
 *二分查找法   十分重要
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5};
		//boolean flag = whileSearch(a, 4);
		boolean flag = recrusion(a, 0, a.length-1, 6);
		System.out.println(flag);
	}
	//循环二分查找法
	public static boolean whileSearch(int[] a,int n) {
		Arrays.sort(a);//先排序
		int i=0;
		int j=a.length-1;
		
		while (i<=j) {
			int mid=(i+j)/2;
			if (a[mid]==n) {
				return true;
			}
			else if (a[mid]<n) {//要找的数在右边
				i=mid+1;
			}else {
				//要找的数在左边
				j=mid-1;
			}
		}
		return false;
	}
	//递归二分查找法
	public static boolean recrusion(int[] a,int start,int end,int n) { 
		if (a==null|| start>end) {
			return false;
		}
		int mid=(start+end)/2;
		
		if (a[mid]==n) {
			return true;
		}
		if (a[mid]<n) {
			return recrusion(a, mid+1,end,n);
		}
		if (a[mid]>n) {
			return recrusion(a, start, mid-1, n);
		}
		return false;
	}

}
