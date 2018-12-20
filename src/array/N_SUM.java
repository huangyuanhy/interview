package array;

/**
 * 这个方法看不懂啊  
 *  给定n个数 从中选出一些数 判断和是否为k
 * @author Administrator
 *2018年9月16日
 */
public class N_SUM {
public static void main(String[] args) {
	 int[] a = { 10, 4, 7, 1, 9, 6, 3 };
     int initVal = 10;
     solve1(a, initVal);
     System.out.println("------------------");
     Solve(a, initVal);
}
/**
 * @param a
 * @param initVal
 */
private static void solve1(int[] a, int initVal) {
	for (int i = 1; i < 1 << a.length; i++) {
         int sum = 0;
         StringBuffer sb = new StringBuffer();
         for (int j = 0; j < a.length; j++) {
             if ((i & 1 << j) != 0) { 
                 sum += a[j];
                 sb.append(a[j]).append("+");
             }
         }
         if (sum == initVal) {
             System.out.println(sb.substring(0,sb.lastIndexOf("+")));
         }
     }
}
//找出数组中和为K的一组解
	public static void Solve(int[] a,int k){
		if (!haveAnswer(a, a.length, k)) {
			System.out.println("没有解");
		}
	}
	//前n个数中是否有和为K的解
	public static boolean haveAnswer(int[] a,int n,int k){
		if (k==0) {//k已经被凑齐
			return true;
		}
		if (n==1) {//计算到第一个元素时
			return a[0]==k?true:false;
		}
		boolean b=haveAnswer(a, n-1, k-a[n-1]);
		if (b) {//这个解中包含a[n-1]
			System.out.println(a[n-1]);
			return true;
		} else {//解中不包含a[n-1]，继续计算前面的数组中是否有解
			return haveAnswer(a, n-1, k);
		}
	}


}
