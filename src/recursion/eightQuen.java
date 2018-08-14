/**
 * 
 */
package recursion;

/**
 * @author Administrator
 *---------基于国际象棋的8888888皇后问题-------
 */
public class eightQuen {
	static int[][] map=new int[8][8];//棋盘  0表示无棋子，1表示一个皇后
	public static void main(String[] args) {
		play(0);
	}
	static int count=1;//用于计算调用次数
	static void show() {
		System.out.println("第"+count+"种摆法");
		count++;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(map[i][j]+"   ");
			}
			System.out.println();
		}
	}
	//-------------核心代码来咯------------
	static void play(int row){
		//从第一行开始，遍历所有列
		for(int i=0;i<8;i++) {//代表8列
			if(check(row,i)) {//验证是否能够放皇后
				map[row][i]=1;//放一个皇后
				
				if(row==7) {//依次遍历下一行
					show();//说明皇后放置完毕，显示一下
					//map[row][i]=0;//摆好后，推翻最后个皇后，继续往下摆
				}else {
					play(row+1);//如果自己的方法调用结束都没有放置皇后，则说明，上一个位置不行
					//map[row][i]=0;//上个位置重新置为0；
					
				}
				map[row][i]=0;
			}
		}
	}
	static boolean check(int row,int col) {//判断某个格子是否有皇后
		//上面
		for(int i=row-1;i>=0;i--) {
			if(map[i][col]==1)   //此位置已经有皇后了
				return false;
		}
		//左上
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
			if(map[i][j]==1) {
				return false;
			}
		}
		//右上
		for(int i=row-1,j=col+1;i>=0&&j<8;i--,j++) {
			if(map[i][j]==1) {
				return false;
			}
		}
		return true;  //上面三个位置都没用皇后，说明此位置可以放一个皇后
	}
}
