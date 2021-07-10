package array;

import java.util.ArrayList;
import java.util.List;

public class MergeArray {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 2, 3, 4 };
		List<Integer> result = merge(arr1, arr2);
		System.out.print(result);
	}

	private static List<Integer> merge(int[] arr1, int[] arr2) {

		List<Integer> res = new ArrayList<Integer>(10);
		if (arr1 == null || arr1.length == 0) {
			return res;
		}
		if (arr2 == null || arr2.length == 0) {
			return res;
		}
		int i = 0;
		int j = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				res.add(arr1[i]);
				i++;
				j++;
			}
			if (arr1[i] > arr2[j]) {
				j++;
			} else {
				i++;
			}
		}
		return res;

	}
}
