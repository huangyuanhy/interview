package array;

public class NewHopeOne {
	public static void main(String[] args) {
		// 测试
		ballFallDown(100, 10);
		compare( 3, 5, 1 );
	}

	/**
	 * 球落地问题
	 * 
	 * @param high 初始高度
	 * @param count 第几次反弹
	 */
	public static void ballFallDown(Integer high, Integer count) {
		double sum = 0;
		double height = high;
		for (int i = 1; i <= count; i++) {
			sum = height + height / 2 + sum;// 一次落地距离+弹起距离+已经过路程
			height /= 2;// 弹起高度为一半
		}
		sum -= height;// 求第10次落地经过路程需减去第10次弹起距离
		System.out.println("高度为" + high + "米 第" + count + "次落地时，共经过" + sum + "米");
		System.out.println("高度为" + high + "米 第" + count + "次反弹" + height + "米");

	}

	/**
	 * 排序并输出
	 */
	public static void compare(int num1, int num2, int num3) {
		int j = 0;
		if (num1 > num2) {
			j = num2;
			num2 = num1;
			num1 = j;
		}
		if (num1 > num3) {
			j = num3;
			num3 = num1;
			num1 = j;
		}
		if (num2 > num3) {
			j = num3;
			num3 = num2;
			num2 = j;
		}
		System.out.println(num1 + " " + num2 + " " + num3);
	}

}
