/**
 * 
 */
package array;

import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * @author Administrator
 *2018年8月20日
 *无序数组中最小的K个数 时间复杂度为O(Nlogk)及O(N)
 */
public class SmallestOf_K {
	public static void main(String[] args) {
		int[] arr= {3,2,1,1,3,6,7};
		//solution1(arr, 3);
		solution(arr, 3);
	}

	public static void solution1(int[] arr,int k) {
		int partion = partion(arr,0,arr.length-1);
		while (partion!=k-1) {

			if (partion>k-1) {
				partion =partion(arr, 0, partion-1);
			}
			else if (partion<k-1) {
				partion =partion(arr, partion+1, arr.length-1);
			}
		}

		for (int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}


	}
	public static int partion(int[] arr,int start,int end) {
		int tmp=arr[0];
		int j=start;
		int d=end;
		while(j<d) {
			while(j<d&&arr[d]>=tmp) {
				d--;
			}
			arr[j]=arr[d];
			while(j<d&&arr[j]<=tmp) {
				j++;
			}
			arr[d]=arr[j];

		}
		int index=j;
		return index;

	}
	//---------有问题----------------------
	public static void solution(int[] arr,int k) {
		TreeMap<Integer,Integer> map=new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.size()==3) {
				Entry<Integer, Integer> lastEntry = map.lastEntry();
				Integer key = lastEntry.getKey();
				if (arr[i]<key){
					map.remove(key);
					map.put(arr[i],i);
				}
			}else {
				map.put(arr[i],i);
			}
		}
		System.out.println(map);

	}
}
