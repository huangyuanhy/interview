/**
 * 
 */
package pdd;

/**
 * @author huangyuan
 * @date 2018年11月13日下午7:55:07
 * @Description
 * 输入是一个只含有 0 和 1 的二维矩阵，每一行都是排过序的，也就是说每一行前一部分都
是 0,剩下的全都是 1。请找哪些行包含的 1 最多
 */
public class NO1 {
	public static void main(String[] args) {
		int[][] arr= {
				{0,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
				{0 ,0 ,0 ,0 ,1, 1, 1 ,1, 1, 1, 1 ,1},
				{0 ,0, 0, 0, 0 ,0, 1 ,1, 1, 1, 1, 1},
				{0, 0 ,0 ,0, 0, 0, 0, 0, 0, 1 ,1 ,1},
				{0 ,0, 0 ,0 ,0 ,0 ,0 ,1 ,1, 1, 1, 1},
				{0 ,0, 0, 0 ,1, 1, 1, 1, 1, 1, 1, 1}};
		solution(arr);
	}
	private static void  solution(int[][] arr){
		int n=0;//第几行
		int m=0;//每行1的个数；
		int row=arr.length;//行
		int column=arr[0].length;//列
		int count;
		if (arr!=null&&arr.length!=0) {
			for (int i = 0; i < arr.length; i++) {
				count=column;
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j]==0) {
						count--;
					}else {
						m=count>m?count:m;
						n=m==count?i:n;
					}
				}
			}
		}
		n++;
		System.out.println("["+n+","+m+"]");
	}
}
