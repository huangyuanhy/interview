/**
 * 
 */
package array;

import org.junit.Test;

/**
 * @author 黄渊
 *2018年7月6日
 *打印菱形
 */
public class RhombusPrint {
@Test
	public void test(){
		int[][] arr=new int[5][5];
		for(int i=0;i<arr.length;i++) {			
			for(int j=0;j<arr.length;j++) {					
						System.out.print("*");					
			}
			System.out.println();
		}
		
	}
}
