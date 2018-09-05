/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年8月20日
 *旋转N*N矩阵 90度
 */
public class RotateMatrix {
	public static void main(String[] args) {
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		print(arr);
		System.out.println("----------");
		int start=0;
		int end=arr.length-1;
		while(start<end) {
			rotate(arr, start, end);
			start++;end--;
		}
		print(arr);
	}
	public static void rotate(int[][] arr,int start,int end) {
		
		for (int i=0;start+i<end;i++) {
			int tmp=arr[start][start+i];
			arr[start][start+i]=arr[end-i][start];//13---1
			arr[end-i][start]=arr[end][end-i];
			arr[end][end-i]=arr[start+i][end];
			arr[start+i][end]=tmp;

		}
	}
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
			
		}
	}
}
