package other;

public class InitTest extends fu{
	static {
		System.out.println("子类初始化");
	}
	public static void main(String[] args) {
		System.out.println(InitTest.name);
		System.out.println("-------------------------");
		System.out.println(InitTest.name2);//常量直接访问，都不初始化，因为在编译时候就已经确定了
		System.out.println("-------------------------");
		fu[] arr=new fu[10];//这是一个数组对象。不是父类对象，属于间接引用
		System.out.println("-------------------------");
		InitTest[] arr1=new InitTest[10];//子类也不会被初始化
	}
}
class fu{
	public static  String name="huangyuan";
	public static final String name2="guowenjing";
	static {
		System.out.println("父类初始化");
	}
}
