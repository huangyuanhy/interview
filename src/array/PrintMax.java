/**
 * 
 */
package array;

/**
 * @author Administrator
 *2018年7月26日
 *打印从1 到最大的N位数
 */
public class PrintMax {
	
		 
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int n = 3;
			print1ToMaxN(n);
		}
	 
		private static void print1ToMaxN(int n) {
			// TODO Auto-generated method stub
			char number[] = new char[n];
			recursivePrint(0, number, n);
		}
	 
		private static void recursivePrint(int index, char[] number, int n) {
			// TODO Auto-generated method stub
			if (index == n) {
				boolean beginWith0 = true;
	 
				for (int i = 0; i < n; i++) {
	 
					if (number[i] != '0') {
						beginWith0 = false;
					}
					if (!beginWith0) {
						System.out.print(number[i]);
	 
					}
				}
	 
				if (!beginWith0) {
					System.out.println();
	 
				}
	 
				return;
			}
	 
			for (int i = 0; i < 10; i++) {
				number[index] = (char) ('0' + i);
				recursivePrint(index + 1, number, n);
			}
	 
		}
	 
	}


