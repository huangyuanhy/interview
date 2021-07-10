package thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 * @author pc
 *2019年5月28日
 *打印a-z 字符，其中一个线程打印元音字符，一个线程打印辅音字符
 */
public class PrintChar {
	ReentrantLock lock=new ReentrantLock();
	private Condition conditionA = lock.newCondition();   
	private Condition conditionB = lock.newCondition();  

	private static char c='a';
	private static List<Character> list;
	static {
		list=Arrays.asList('a','e','i','o','u');
	}
	public static void main(String[] args) {
		PrintChar printChar = new PrintChar();
		new Thread(printChar.new MyThreadA()).start();
		new Thread(printChar.new MyThreadB()).start();

	}

	class MyThreadA implements Runnable{//打印辅音
		@Override
		public void run() {
			while (c<='z') {
				lock.lock();
				try {
					while (list.contains(c)) {//当前是元音字母
						try {
							conditionA.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+":"+c++);
					conditionB.signal();
				} finally {
					lock.unlock();
				}
			}
		}
	}
	class MyThreadB implements Runnable{//打印元音
		@Override
		public void run() {
			while (c<='z') {
				lock.lock();
				try {
					while (!list.contains(c)) {//当前是辅音字母
						try {
							conditionB.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName()+":"+c++);
					conditionA.signal();
				} finally {
					lock.unlock();
				}
			}
		}
	}
}