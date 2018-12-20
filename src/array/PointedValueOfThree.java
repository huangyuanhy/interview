/**
 * 
 */
package array;

import java.util.Arrays;

/**
 * 数组中三个数相加为0 的数组元素
 * @author Administrator
 *2018年8月11日
 */
public class PointedValueOfThree {
	public static void main(String[] args) {
		int[] a= {-1, 0 ,1, 2, -1, -4};
		
		first(a,0);
		System.out.println("--------");
		second(a,0);
	}

	private static void second(int[] a,int num) {
		Arrays.sort(a);	
		int i=0;
		while (i!=a.length-1) {
			solution(a, i++,num);
		}
	}

	/**
	 * @param a
	 * @param i
	 * @param j
	 * @param k
	 */
	private static void solution(int[] a, int i,int sum) {
		int k=a.length-1;
		if (k-i<2) {
			return;
		}
		int j=i+1;
		while(j<k){				
				if (a[j]+a[k]+a[i]==sum) {
					System.out.println(a[i]+","+a[j]+","+a[k]);
					//去重
					while (j<k&&a[--k]==a[k]) {
						k--;
					}
					while (j<k&&a[++j]==a[j]) {
						j++;
					}
					j++;k--;
				}else if (a[j]+a[k]+a[i]>sum) {
					k--;
				}else {
					j++;
				}				
		}
	}

	private static void first(int[] a,int num) {
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				for(int k=i+2;k<a.length;k++) {
					if (a[i]+a[j]+a[k]==0) {
						System.out.println(a[i]+","+a[j]+","+a[k]);
					}
				}
			}
		}
	}
}
