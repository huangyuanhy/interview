package sort;

import java.util.Arrays;

import org.junit.Test;

public class Insert2 {
	@Test
	public void  test() {
		int[] a= {2,3,1,5};
		insertSort2(a);
		System.out.println(Arrays.toString(a));
	}
	
	
	//插入排序 
	 private static void insertSort(int[] a) {
	   for(int i=0;i<a.length-1;i++){
	     int temp = a[i+1];
	     int j=i;
	     while(a[j]>temp) {
	       a[j+1]=a[j];
	       j--;
	       if (j<0) {
	         break;
	       }
	     }
	     a[j+1]=temp;
	   }
	 }
	 
	//二分插入排序
	 private static void insertSort2(int[] a) {
	   for(int i=0;i<a.length-1;i++){
	     int temp = a[i+1];
	     
	     int low = 0;
	     int high = i;
	     int mid;
	     
	     while(low<=high) {
	       mid = (low+high)/2;
	       if (a[mid]>temp) {
	         high = mid-1;
	       }else{
	         low = mid+1;
	       }
	     }
	     for(int j=i;j>=high+1;j--){
	       a[j+1]=a[j];
	     }
	     a[high+1]=temp;
	   }
	 }
}
