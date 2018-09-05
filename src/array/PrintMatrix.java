/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年8月20日
 *矩阵转圈打印  顺时针
 *思路： 求出矩阵的子矩阵，，由大到小 
 */
public class PrintMatrix {
	public static void main(String[] args) {
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int i=0;int j=0;
		int col = arr[0].length-1;
		int row = arr.length-1;
		while(i<row&&j<col) {
			
			printEdge(arr,i,j,row,col);
			i++;j++;
			row--;col--;
		}
		
	}
	public static void printEdge(int[][] arr,int start_1,int start_2,int end_1,int end_2) {
		/*int col = arr[0].length-1;
		int row = arr.length-1;*/
		int b=start_2;
		int a=start_1;
		int c=end_1;
		int d=end_2;
		
		while(b<end_2) {
			System.out.print(arr[start_1][b]+"  ");
			b++;
		}
		while(a<end_1) {
			System.out.print(arr[a][end_2]+"  ");
			a++;
		}
		while(start_2<d) {
			System.out.print(arr[end_1][d]+"  ");
			d--;
		}
		while(start_1<c) {
			System.out.print(arr[c][start_1]+"  ");
			c--;
		}
	}
}
