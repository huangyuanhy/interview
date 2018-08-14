package array;

import java.util.Arrays;

import org.junit.Test;
//两个数组求交元素
public class intersect {
	@Test
	public void test() {
		int[] a= {1,2,4,5};
		int[] b= {1,4,6,7};
		inter(a, b);

	}
	public static void inter(int[] a,int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		int i=0;
		int j=0;
		for( i=0;i<a.length;i++) {
			if(a[i]==b[j]) {
				System.out.println(a[i]);
				i++;
				j++;
			}
			else if(a[i]>b[j]) {
				j++;
			}
			else {
				i++;
			}
		}
	}
}
