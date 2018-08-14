package array;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int [] a= {3,2,1,4,3};
		for(int i=1;i<a.length;i++) {
			int tmp=a[i];
			int p=i;
			for(;p>0&&tmp<a[p-1];p--) {
				a[p]=a[p-1];
			}
			a[p]=tmp;
		}
		System.out.println(Arrays.toString(a));
	}
}
