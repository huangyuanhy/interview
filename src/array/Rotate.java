/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年7月25日
 *输入一个排序数组的一个旋转，输出旋转数组的最小数字  利用二分查找法实现logn的时间
 */
public class Rotate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {3,4,5,1,2};
		int[] b= {1,0,1,1,1};
		//int rotate = rotate(b, 0, a.length-1);
		int rotate = rotate(a, 0, a.length-1);
		System.out.println(rotate);
	}
	public static int rotate(int[] a, int index,int end) {
		
		int mid=index;//中间指针 初始化
		
		while(a[index]>=a[end]) {//左边数组大于右边数组
			if ((end-index)==1) {//两个指针处于相邻位置
				mid=end; //将中间指向后一个指针，即是最小的数字
				break;
			}
			mid=(index+end)/2;
			if (a[mid]==a[end]&& a[end]==a[index]) { //三个数都相等的情况 
				 
				return inorder( a,index, end);
			}
			if (a[mid]>=a[end]) {//最小的数在右边  将第一个指针指向中间指针
				index=mid;
			}
			if (a[mid]<=a[end]) {//最小的数在左边 将尾指针指向中间指针
				end=mid;
			}
		}
		return a[mid];
	}
	static int inorder(int[] a,int index,int end) {
		//这种情况只能遍历找出最小的数  时间复杂度为On
		int result=a[0];//结果值初始化
		for(int i=index;i<end;i++) {
			if (result>a[i]) {
				result=a[i];
			}
		}
		return result;
	}
}
