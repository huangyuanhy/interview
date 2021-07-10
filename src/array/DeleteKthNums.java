package array;

/**
 * 循环隔K个数删除数组中的数
 * 
 * @author pc 2021年5月8日
 */
public class DeleteKthNums {
	public static void main(String[] args) {
		int[] arrs = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int times = 0;
		int K = 2;// 每隔k个数删除一个数
		int nums = arrs.length;
		while (nums != 1) {
			for (int i = 0; i < arrs.length && nums != 1; i++) {
				if (times == K && arrs[i] != Integer.MIN_VALUE) {
					arrs[i] = Integer.MIN_VALUE;
					nums--;
					times = 0;
				} else if (arrs[i] != Integer.MIN_VALUE) {
					times++;
				}
			}
		}
		for (int i = 0; i < arrs.length; i++) {
			if (arrs[i] != Integer.MIN_VALUE) {
				System.out.print(i);
			}
		}
	}

}
