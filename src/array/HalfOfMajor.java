/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年8月20日
 *大于数组长度一半的元素  
 */
public class HalfOfMajor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,2,2,6};
		print(a);
	}
	/**
	 * 这个算法很牛逼
	 * @param a
	 */
	public static void print(int[] a) {
		int cand=0;
		int times=0;
		for (int i = 0; i < a.length; i++) {
			if (times==0) {
				cand=a[i];
				times=1;
				
			}else if (a[i]==cand) {
				times++;
				
			}else {
				times--;
			}
		}
		times=0;
		for (int i = 0; i < a.length; i++) {
			if (a[i]==cand) {
				times++;
			}
		}
		if (times>a.length/2) {
			System.out.println(cand);
		}else {
			System.err.println("error");
		}
	}

}
