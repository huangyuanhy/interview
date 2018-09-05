package array;

import java.util.Arrays;

/**
 * 归并排序
 * @author Administrator
 *2018年8月14日
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a= {3,2,1,4};
		int length = a.length;
		int[] sort = sort(a, 0, length-1);
		System.out.println(Arrays.toString(sort));
	}

	public static int[] sort(int[] a,int low,int high){
		int mid = (low+high)/2;
		if(low<high){
			sort(a,low,mid);
			sort(a,mid+1,high);
			//左右归并
			merge(a,low,mid,high);
		}
		return a;
	}

	public static void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high-low+1];
		int i= low;
		int j = mid+1;
		int k=0;
		// 把较小的数先移到新数组中
		while(i<=mid && j<=high){
			if(a[i]<a[j]){
				temp[k++] = a[i++];
			}else{
				temp[k++] = a[j++];
			}
		}
		// 把左边剩余的数移入数组 
		while(i<=mid){
			temp[k++] = a[i++];
		}
		// 把右边边剩余的数移入数组
		while(j<=high){
			temp[k++] = a[j++];
		}
		// 把新数组中的数覆盖nums数组
		for(int x=0;x<temp.length;x++){
			a[x+low] = temp[x];
		}
	}
}
