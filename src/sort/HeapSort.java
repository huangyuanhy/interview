/**
 * 
 */
package sort;

import java.util.Arrays;

/**
 * @author Administrator
 *2018年12月19日
 *大根堆排序
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,5,3,7,1,4,9};
		int[] heap = buildHeap(a);
		System.out.println(Arrays.toString(heap));
		
	}
	public static int[] buildHeap(int[] a) {
		int size=a.length;
		for (int i = size-1;i>1;i--) {
			//初始化堆
			a = initHeap(a, size--);
			//排序
			int tmp=a[0];
			a[0]=a[i];
			a[i]=tmp;
			
		}
		return a;
	}
	/**
	 * 初始化堆
	 * @param a
	 * @param size
	 * @return
	 */
	public static int[] initHeap(int[] a,int size) {
		
		for (int i = size-1; i>=0; i=i-2) {
			heapify1(a, i, size);
		}
		return a;
	}
	/**
	 * 建堆的核心方法
	 * @param a
	 * @param cur
	 * @param size
	 */
	
	public static void heapify1(int[] a,int cur,int size) {
		
		if (cur<size) {
			int k=(cur-1)/2;//找到当前节点的父节点
			int left=2*k+1;
			int right=left+1;

			int max=k;//记录最大节点的下标
			if (left<size&&a[max]<a[left]) {
				max=left;
			}
			if (right<size&&a[max]<a[right]) {
				max=right;
			}
			
			//交换
			if (max!=k) {
				int tmp=a[max];
				a[max]=a[k];
				a[k]=tmp;
			}
		}
	}
}
