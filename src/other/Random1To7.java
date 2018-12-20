package other;
/**
 * 由随机函数Random1To5生成 1到7 的函数
 * @author Administrator
 *2018年12月6日
 */
public class Random1To7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Random1To5());
	}
	private static int Random1To7() {
		int num=(Random1To5()-1)*5+Random1To5()-1;//生成0-24随机数
		//生成0-20的随机数
		while (num>20) {
			num=(Random1To5()-1)*5+Random1To5()-1;
		}
		return num%7+1;
	}
	
	private static int Random1To5() {
		return (int)(Math.random()*5)+1;
	}
}
