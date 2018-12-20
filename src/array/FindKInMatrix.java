/**
 * 
 */
package array;

/**
 * 在矩阵中找到指定正数K,每行每列都拍好序了
 * @author Administrator
 *2018年9月7日
 */
public class FindKInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		boolean found = isFound(arr, 17);
		System.out.println(found);
	}
	public static boolean isFound(int[][] arr,int K) {
		int row=arr.length-1;
		int col=arr[0].length-1;
		int index=0;
		while (col>=0&&index<=row) {
			if (arr[index][col]==K) {
				return true;
			}else if (arr[index][col]<=K) {
				index++;
			} else {
				col--;
			}
		}
		return false;
	}
}
