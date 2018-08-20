/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年7月23日
 *数组中最大的连续子段和
 */
public class MaxSegment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[] {5, -2 , -5};
		//sum(a);
		int maxSubArray = MaxSubArray(a);
		System.out.println(maxSubArray);
	}
	public static void sum(int[] a) {
		int curSum=0;
		int maxSum=0;
		for(int i=0;i<a.length;i++) {
			if (curSum+a[i]<=0) {
				curSum=0;
			}
			else {
				curSum+=a[i];
				maxSum=Math.max(maxSum, curSum);
			}
		}
		System.out.println(maxSum);
	}



	static int MaxSubArray(int A[])
	{
		int curSum;
		int sum;
		curSum = sum = 0;
		for(int i=A.length-1; i >=0; i--)
		{
			curSum =Math. max(curSum + A[i], A[i]);
			sum = Math.max(sum, curSum);
		}
		return sum;
	}
}
