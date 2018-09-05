/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年7月23日
 *
 */
public class DynamicPlan {
	
	public static void main(String[] args) {
		int [][] a={{1,3,5,9},{8,1,4,3},{5,0,6,1},{8,8,4,0}};
		int min = minLength1(a);
		System.out.println(min);
	}
	/**
	 * 利用一维数组来存储数据  只能够算出最优解，不能算出优路径具体值
	 * @param a
	 * @return
	 */
	public static int minLength1(int[][] a) {
		if (a==null) {
			return 0;
		}
		int row = a.length;//row 或col 中最短的
		int[] num=new int[row];
		num[0]=a[0][0];
		for (int i = 1; i < num.length; i++) {
			num[i]=a[0][i]+num[i-1];
		}
		for (int i = 1; i < a.length; i++) {
			num[0]=num[0]+a[i][0];
			for (int j = 1; j < a.length; j++) {
				num[j]=a[i][j]+Math.min(num[j], num[j-1]);
			}
		}
		return num[row-1];	
	}
	/**
	 * 利用二维数组来存所有记录 能够算出最有路劲
	 * @param a
	 * @return
	 */
	public static int minLength(int[][] a) {
		
		if (a==null) {
			return 0;
		}
		int row = a.length;
		int col=a[0].length;
		int[][] num=new int[row][col];
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				 int fromLeft = 0; //左边
	               int fromUp = 0; //上面
	               if (i > 0)
	                    fromUp = num[i - 1][j];
	                if (j > 0)
	                    fromLeft = num[i][j - 1];
	                if (i==0||j==0) {
	                	 num[i][j] = Math.max(fromLeft, fromUp) + a[i][j];
					}else {
						num[i][j] = Math.min(fromLeft, fromUp) + a[i][j];
					}   
			}
		}
		return num[row-1][col-1];
	}
	/**
	 * 二维数组中某个数字的查找
	 * @param a
	 * @param num
	 * @return
	 */
	public static boolean search(int[][] a,int num) {
		boolean flag=false;
		if (a!=null) {
			int row=0;
			int column=a.length-1;
			
			while(row<a.length && column>=0) {
				if (a[row][column]==num) {
					flag=true;
					return flag;
				}else if(a[row][column]>num){
					column--;
				}else {
					row++;
				}
			}
		}
		return flag;
	}
}
