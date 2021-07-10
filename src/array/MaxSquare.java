package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 矩形的最大面积
 * 
 * @author pc 2021年5月23日
 */
public class MaxSquare {
	public static void main(String[] args) {
		List<Integer> res = new ArrayList<Integer>();
		int[] arr = { 2, 1, 5, 6, 3, 18 };
		Deque<Integer> tmp = new ArrayDeque<>();
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
				tmp.add(i);
			}
		}
		System.out.print(tmp);
		tmp.add(arr.length);
		int left = 0;
		int right = left;
		while (tmp.size() != 0) {
			Integer pop = tmp.pop();
			right = pop - 1;
			while (left <= right) {
				int min = Math.min(arr[left], arr[right]);
				res.add(min * (right - left + 1));
				if (arr[left] < arr[right]) {
					left++;
				} else {
					right--;
				}
			}
			left = pop;
		}
		System.out.print(res);
	}

}
