/**
 * 
 */
package other;

/**
 * @author Administrator
 *2018年12月6日
 *给定一个以P概率产生0，1-p概率产生1的随机函数rand01p，
 *实现随机函数rand1To6
 */
public class Random1To6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(rand1To6());
	}
	private static int rand1To6() {
		int num=(rand0To3()*4+rand0To3());
		while (num>11) {
			 num=(rand0To3()*4+rand0To3());
		}
		return num%6+1;
	}
	/*
	 * 随机产生0-3
	 */
	private static int rand0To3() {
		 
		return rand01()*2+rand01();
	}

	/**
	 * 等概率产生0 1
	 * 
	 * @return
	 */
private static int rand01() {
		int num;
		do {
			num=rand01p();
		} while (num==rand01p());
		return num;
	}
	/**
	 * 此为给定函数
	 * @return
	 */
	private static int rand01p() {
		double p=0.83;
		return Math.random()<p?0:1;
	}

}
