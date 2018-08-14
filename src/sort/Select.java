package sort;

import org.junit.Test;

public class Select {
	@Test
	public static void test() {
		int[] arr= {2,4,1,6,5};
		for(int i=0;i<arr.length;i++) {
			int max=arr[0];
			for(int j=0;j<arr.length-i;j++) {
				if(arr[j]>max) {
					max=arr[i];
				}
				
			}
			arr[arr.length-i-1]=max;
		}
		System.out.println(arr);
	}
}
