package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * 作者：D1C0
链接：https://www.nowcoder.com/discuss/105965
来源：牛客网

本公司有很多团队，现在要将关系紧密的团队放到同一个部门。给定一个M*M的二维数组，如：
4
0 1 1 0
1 0 0 0
1 0 0 1
0 0 1 1
其中4表示二维数组的大小，1代表一个团队，上下或左右相连的1（团队）表示其关系紧密，求最后分出的部门数。
输入描述：
第一行第一个整数表示M（M<1000），
后面每一行表示团队之间的关系分布，如上所示的数阵
输出描述：
一个整数
示例：
输入：
4
0 1 1 0
1 0 0 0
1 0 0 1
0 0 1 1
输出：
3
 * @author Administrator
 *2018年9月9日
 */
public class JingDong2 {   
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num = scanner.nextInt();
		int[][] arr=new int[num][num];
		String line=null;
		scanner.nextLine();

		for (int i = 0; i < arr.length; i++) {
			line=scanner.nextLine();
			String[] split = line.split(" ");
			for (int j = 0; j < split.length; j++) {
				arr[i][j]=Integer.parseInt(split[j]);
			}
		}

		int res = deptAmount(arr);
		System.out.println(res);
	}
	public static int deptAmount(int[][] arr) {
		int len=arr.length;
		int count=0;
		int[][] res=new int[len][len];
		res[0][0]=arr[0][0];//只可能是0 或者1
		count=res[0][0]==1?1:0;
		for (int i = 1; i != len; i++) {//初始化行
			if (arr[0][i]==1) {//如果当前为1
				if (arr[0][i-1]==1) {//如果前一个也等于1
					res[0][i]=res[0][i-1];
				}else {//如果前一个等于0  新建一个部门
					count++;
					res[0][i]=count;
				}
			}else {//如果当前为0
				res[0][i]=res[0][i-1];
			}
		}
		for(int j=1;j!=len;j++) {//初始化列
			if (arr[j][0]==1) {
				if (arr[j-1][0]==1) {//如果前一个也等于1
					res[j][0]=res[j-1][0];
				}else {//如果前一个等于0     新建一个部门
					count++;
					res[j][0]=count;
				}
			}else {//如果当前为0
				res[j][0]=res[j-1][0];
			}
		}
		for (int i = 1; i < len; i++) {
			for (int j = 1; j < len; j++) {
				if (arr[i][j]==1) {//当前元素为1
					if (arr[i-1][j]==1||arr[j][i-1]==1) {//上一个或者左边的也为1 都属于同一个部门
						res[i][j]=Math.max(res[i-1][j], res[i][j-1]);
					}else {
						//上左都为0 则是一个新的部门
						count++;
						res[i][j]=count;
					}
				}else {
					//当前元素为0
					res[i][j]=Math.max(res[i-1][j], res[i][j-1]);
				}
			}
		}
		return count;
	}
}