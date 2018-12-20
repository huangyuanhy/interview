package comprehensive;
/**
 * 矩阵的最小路径和
 * @author Administrator
 *2018年11月21日
 */
public class one {
	public static void main(String[] args) {
		int[][] num= {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		name1(num);
	}
	//优化方案，生产一维数组
	public static void name1(int[][] num) {
		int len=num[0].length;
		int[] tmp=new int[len];
		tmp[0]=num[0][0];
		for (int i = 1; i < tmp.length; i++) {
			tmp[i]=num[0][i]+num[0][i-1];
		}
		for (int i = 1; i < tmp.length; i++) {//从第二行开始
			tmp[0]+=num[i][0];
			for (int j = 1; j < tmp.length; j++) {
				tmp[j]=Math.min(tmp[j-1], tmp[j])+num[i][j];
			}
		}
		System.out.println(tmp[len-1]);
	}
	public static void name(int[][] num) {
		int row=num.length;
		int col=num[0].length;
		int tmp[][]=new int[row][col];
		tmp[0][0]=num[0][0];
		for (int i = 1; i < row; i++) {
			tmp[0][i]=num[0][i]+num[0][i-1];
		}
		for (int i = 1; i < col; i++) {
			tmp[i][0]=num[i][0]+num[i-1][0];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				tmp[i][j]=Math.min(tmp[i-1][j], tmp[i][j-1])+num[i][j];
			}
		}
		int min=tmp[row-1][col-1];
		System.out.println(tmp[row-1][col-1]);
		row--;col--;
		while (row>=0&&col>=0) {

			int min2 = Math.min(tmp[row-1][col], tmp[row][col-1]);
			if (min2==tmp[row-1][col]) {
				System.out.println(num[row-1][col]);
				row--;
			}else {
				System.out.println(num[row][col-1]);
				col--;
			}
		}
	}
}
