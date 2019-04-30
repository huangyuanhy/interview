package array;
/**
 * 假设有个二维矩阵式的棋盘，包含黑白两种颜色的棋子，分别用字母“X”和“O”表示，找到所有被黑色棋子“X”围绕的白色棋子“O”，并将其替换成黑色棋子。

   示例：

X X X X

X O O X

X X O X

X O X X

函数运行后，输出如下：

X X X X

X X X X

X X X X

X O X X

注意事项：任何边界上的白色棋子都不会置换成黑色棋子。
 * @author Administrator
 *2019年4月20日
 */
public class RepalceChess {
	public static void main(String[] args) {
		char[][] in= {{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','O','X'}};
		char[][] replace = replace(in);
		for (int i = 0; i < replace.length; i++) {
			for (int j = 0; j < replace.length; j++) {
				System.out.print(replace[i][j]+"  ");
			}
			System.out.println();
		}
	}
	/**
	 * 思路：
	 * 		1. 生成一个布尔类型的flag[][]数组，flag[i][j]==true,
	 * 表示当前位置值更改过。默认false.
	 * 		2.从第一行第一列开始遍历，如果当前位置是'O'并且上面和左面都是'X'，
	 *   则此位置变为'X'。同时flag[i][j]==true
	 *  	3. 从倒数第二行第二列开始反向遍历，如果flag[i][j]==true，
	 *  并且右边和下边任意位置为'O', 则此位置变为'O';
	 */
	public static  char[][] replace(char[][] in) {
		int row=in.length;
		int col = in[0].length;
		//用来记录数组中哪些字符修改过，若改过，记录为true，否则为false。
		boolean[][] flag=new boolean[row][col];
		
		//正向遍历in[1][1]到in[row-2][col-2]之间的字符
		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < col-1; j++) {
				//如果当前位置为O，并且左边、上边为X，此位置变为X，且flag[i][j]=true,表示修改过值
				if (in[i][j]=='O'&&in[i-1][j]=='X'&&in[i][j-1]=='X') {
					in[i][j]='X';
					flag[i][j]=true;
				}
			}
		}
		//反向遍历从in[row-2][col-2]到in[1][1]之间的字符
		for (int i = row-2; i >0; i--) {
			for (int j = col-2; j>0; j--) {
				//如果当前位置的值改过，且右边、下边任一位置的值为'O'，则此位置设为'O'
				if ((in[i+1][j]=='O'||in[i][j+1]=='O')&&flag[i][j]==true) {
					in[i][j]='O';
				}
			}
		}
		return in;
	}

}
