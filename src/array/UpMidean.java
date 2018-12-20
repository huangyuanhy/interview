/**
 * 
 */
package array;


/**
 * @author Administrator
 *2018年12月19日
 *获取两个排序数组中的上中位数
 */
public class UpMidean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a2= {1,2,3,4};
		int[] a1= {3,4,5,6};
		int res=getMidean(a1, a2, 0, a1.length-1, 0, a2.length-1);
		System.out.println(res);
	}
	public static int getMidean(int[] a1,int[] a2,int start1,int end1,int start2,int end2) {
		if (a1==null||a2==null||a1.length==0||a2.length==0) {
			return 0;
		}
		//只有一个元素
		if (start1==end1) {
			return Math.min(a1[start1], a2[start2]);
		}
		int mid1=(start1+end1)/2;
		int mid2=(start2+end2)/2;
		if (a1[mid1]==a2[mid2]) {
			return a1[mid1];
		}else if (a1[mid1]>a2[mid2]) {
			//长度为奇数
			if ((end1-start1+1)%2==1) {
				return getMidean(a1, a2, start1, mid1, mid2, end2);
				
			}else {
				return getMidean(a1, a2, start1, mid1, mid2+1, end2);
			}
		}else {
			return getMidean(a2, a1, start1, end1, start1, end2);
		}
		
		 
	}
	
	
	/**
	 * 循环的方式解决问题
	 */
	public static int getMidean1(int[] a1,int[] a2){
		int s1=0;
		int s2=0;
		int e1=a1.length-1;
		int e2=a2.length-1;
		int m1=0;
		int m2=0;
		int offset=0;
		while (s1<e1) {
			m1=(s1+e1)/2;
			m2=(s2+e2)/2;
			offset=((e1-s1+1)&1)^1;//奇数为0，偶数为1
			if (a1[m1]>a2[m2]) {
				e1=m1;
				s2=m2+offset;
			}else if (a1[m1]>a2[m2]) {
				s1=m1+offset;
				e2=m2;
			}else {
				return a1[m1];
			}
		}
		return Math.min(a1[s1], a2[s2]);
				
	}
}
