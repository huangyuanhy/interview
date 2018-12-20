package array;

import java.util.Arrays;
import java.util.Scanner;

public class ZhaoShangKeJi {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		name(K);
	}
	public static void name(int K) {
		int[] arr=new int[K];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		int i=0;
		int j=0;
		int sum=i;
		while (i<K) {
			sum=i;
			j=i;
			while (j<K) {
				if (sum==K) {
					for (int l = i; l <j; l++) {
						System.out.print(i+" ");
						System.out.println();
					}
				}else if (sum<K) {
					j++;
					if (j==K) {
						break;
					}
					sum+=j;
				}else {
					break;
				}
			}
			i++;
		}
	}
	public static void getSum(int K) {
		if(K<0){
			return;
		} 
		int[] arr=new int[K];
		for(int i=0;i<K;i++){
			arr[i]=i;
		}
		int left=0;
		int right=0;
		int sum=0;
		int len=0;
		while (right<arr.length) {
			if (sum==K&&(right-left+1)==len){ 
				sum-=arr[left++];
				int[] res=Arrays.copyOfRange(arr,left,right+1);
				System.out.println(Arrays.toString(res));
			}else if (sum<K) {
				right++;
				if (right==arr.length) {
					break;
				}
				sum+=arr[right];
			}else {
				sum-=arr[left++];
			}
		}
	}
}	


