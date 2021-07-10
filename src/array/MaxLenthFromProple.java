package array;
/**
 * 给定一排位置，找出离最近的人的距离，要求这个距离最大，1表示有人，0表示位置上没有人。
 * @author pc
 *2021年5月15日
 */
public class MaxLenthFromProple {
	public static void main(String[] args) {
		int[] arr = { 1,0,0,0 ,1,0,1 };
		int[] arr1 = { 0, 1 };

		int[] arr2 = {1,0,0,0 };

		solution(arr2);
	}

	public static void solution(int[] arr) {
		boolean leftIsNull = arr[0] == 1 ? false : true;
		boolean rightIsNull = arr[arr.length - 1] == 1 ? false : true;
		int record = -1;// 上一次出现人的位置，-1 表示初始位置
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				if (record == -1) {
					result = Math.max(2 * i, result);
				} else {
					result = Math.max(result, i - record);
				}
				record = i;
			}
		}
		if (rightIsNull) {
			result = Math.max((arr.length-1 - record) * 2, result);
		}
		System.out.print(result / 2);
	}
}
