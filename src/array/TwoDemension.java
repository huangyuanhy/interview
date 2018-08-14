/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年7月23日
 *二维数组的查找
 */
public class TwoDemension {
	public static void main(String[] args) {
		int [][] a={{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(test(a, 10));
	}
	public static boolean test(int[][] a,int num) {
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
