package colletion;

import java.util.ArrayList;


/**
 * 两个线程  对arraylist分别循环10次，问size是多少   可能会发生数组越界因为扩容的时候线程不安全
 * @author Administrator
 *2018年7月10日
 */
public class ArrayListTTest {
	static ArrayList<Integer> alist=new ArrayList<>();
	
	public static void main(String[] args) {
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				alist.add(i);
				System.out.println("线程1-----"+i);
			}
		}).start();
		
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				alist.add(i);
				System.out.println("线程2-------------"+i);
			}
		}).start();
		
		try {
		Thread.sleep(1000);
			System.out.println(alist.size());
		} catch (Exception e) {
		}	// TODO: handle exception
	}
}
