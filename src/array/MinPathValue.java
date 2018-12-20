/**
 * 
 */
package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 *2018年12月6日
 *二维数组最短通路值
 */
public class MinPathValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {{1,0,1,1,1},
					{1,0,1,0,1},
					{1,1,1,0,1},
					{0,0,0,0,1}};
		//System.out.println(minPath(a));
		int res=(int)Math.random()*5+1;
		System.out.println(res);
	}
	public static int minPath(int[][] a) {
		int res=0;
		int[][] map=new int[a.length][a[0].length];
		map[0][0]=1;
		Queue<Integer> rQueue=new LinkedList<>();//行队列
		Queue<Integer> cQueue=new LinkedList<>();//列队列
		
		rQueue.add(0);
		cQueue.add(0);
		
		int r=0;int c=0;
		while (!rQueue.isEmpty()) {
			r=rQueue.poll();
			c=cQueue.poll();
			if (r==a.length-1 && c==a[0].length-1) {
				return map[r][c];
			}
			walkTo(map[r][c],r-1,c,a,map,rQueue,cQueue);
			walkTo(map[r][c],r+1,c,a,map,rQueue,cQueue);
			walkTo(map[r][c],r,c-1,a,map,rQueue,cQueue);
			walkTo(map[r][c],r,c-1,a,map,rQueue,cQueue);
		}
		return res;
	}
	private static void walkTo(int pre, int toR, int toC, 
			int[][] a, int[][] map, Queue<Integer> rQueue, Queue<Integer> cQueue) {
		if (toR<0||toR==a.length||toC<0||toC==a[0].length
				|| a[toR][toC]!=1||map[toR][toC]!=0) {
			return;
			
		}
		map[toR][toC]=pre+1;
		rQueue.add(toR);
		cQueue.add(toC);
	}
}
