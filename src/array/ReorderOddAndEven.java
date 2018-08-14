package array;

import java.util.Arrays;

public class ReorderOddAndEven {
	public static void main(String[] args) {
		//调整数组 使得 奇数在前，偶数在后
		
	int[] a= {1,2,3,4,5};
	int[] reorder = reorder(a);
	System.out.println(Arrays.toString(reorder));
	
	
	}
	public static int[] reorder(int[] a) {
		if (a==null) {
			return null;
		}
		//定义两个指针，一前一后
		int i=0;
		int j=a.length-1;
		while(i<j) {
			while(i<j&&(a[i] & 0x1)==1) {//表明是个奇数
				i++;
			}
			while(i<j&&(a[j] & 0x1)==0) {//表明是个偶数
				i--;
				
			}
			if (i<j) {
				
				swap(a, i, j);
			}
		}
		return a;
			/*if (i+1==j&&(a[i] & 0x1)==1&&(a[j] & 0x1)!=1) {
				break;
			}
			if ((a[i] & 0x1)!=1) {//表明是个偶数
				if ((a[j] & 0x1)==1 ) {//表明是个奇数
					swap(a, i, j);
					i++;
					j--;
				}else {
					j--;
				}
			}else {//说明a[i]是个奇数
				if ((a[j] & 0x1)==1) {//表明是个奇数
					i++;
				}else {
					swap(a, i, j);
					i++;
					j--;
				}
			}
		}
		return a;*/
	}
	/**
	 * @param a
	 * @param i
	 * @param j
	 */
	private static void swap(int[] a, int i, int j) {
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}

}
