package number;
/**|
 * 打印和为 S的连续整数序列
 * @author Administrator
 *2018年9月10日
 */
public class ContinuousSequence {
public static void main(String[] args) {
	solution(90);
}
public static void solution(int sum) {
	int small=1;
	int big=2;
	int mid=(1+sum)>>1;
	int tmpSum=small+big;
	while (small<mid) {
		if (tmpSum==sum) {
			printSum(small,big);
			tmpSum-=small;
			small++;
		}else if (tmpSum<sum) {
			big++;
			tmpSum+=big;
		}else {
			tmpSum-=small;
			small++;
		}
	}
}
public static void printSum(int s,int b) {
	while (s<=b) {
		System.out.print(s+" ");
		s++;
	}
	System.out.println();
}
}
