package comprehensive;

import java.util.HashMap;

/**
 * 换钱的方法数有多少
 * @author Administrator
 *2018年11月21日
 */
public class Conis {
	public static void main(String[] args) {
		int[] arr= {5,10,25,1};
		int res = process2(arr, 100);
		System.out.println(res);
	}
	/**
	 * 暴力递归法
	 */
	public static int process1(int[] arr,int aim) {
		if (arr.length==0||arr==null||aim<=0) {
			return 0;
		}
		return process11(arr, 0, aim);
	}
	private static int process11(int[] arr,int index,int aim) {

		int res=0;
		if (index==arr.length) {
			res=aim==0?1:0;
		}
		else {		 
			for (int i = 0; arr[index]*i<=aim; i++) {
				res+=process11(arr, index+1, aim-arr[index]*i);
			}
		}
		return res;	
	}
	/**
	 * 第一次优化，将每次递归的结果保存在集合中
	 */
	public static int process2(int[] arr,int aim) {
		if (arr.length==0||arr==null||aim<=0) {
			return 0;
		}
		int[][] map=new int[arr.length+1][aim+1];
		return process22(arr, 0, aim,map);
	}
	private static int process22(int[] arr,int index,int aim,int[][] map) {
//		map[i][j]=0 表示没计算过
//		map[i][j]=-1计算了返回结果为0

		int res=0;
		if (index==arr.length) {//递归出口
			res=aim==0?1:0;
		}
		else {
			int mapvalue=0;
			for (int i = 0; arr[index]*i<=aim; i++) {
				mapvalue = map[index+1][aim-arr[index]*i];
				if (mapvalue!=0) {//说明有缓存
					res+=mapvalue==-1?0:mapvalue;
				}else {
					res+=process22(arr, index+1, aim-arr[index]*i,map);
				}
			}
		}
		//把这次计算的结果保存起来
		map[index][aim]=res==0?-1:res;
		return res;	
	}
}
