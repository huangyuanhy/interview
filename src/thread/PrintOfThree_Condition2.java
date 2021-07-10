package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PrintOfThree_Condition2 {
	Lock lock=new ReentrantLock();
	private Condition conditionA = lock.newCondition();   
	private Condition conditionB = lock.newCondition();   
	private Condition conditionC = lock.newCondition();  

	private volatile String name="A";//打印名称
	private volatile int count=1;
	private volatile int end=75;

	public static void main(String[] args) {
		PrintOfThree_Condition2 pCondition=new PrintOfThree_Condition2();
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(pCondition.new ThreadA());
		pool.execute(pCondition.new ThreadB());
		pool.execute(pCondition.new ThreadC());
		pool.shutdown();
	}
	class ThreadA implements Runnable{

		@Override
		public void run() {
			if (count<=end) {
				lock.lock();
				try {
					for(int i=0;i<5;i++) {
						if (name != "A") {
							try {
								conditionA.await();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						System.out.println("线程A:------A"+count);

						name="B";
						count++;
					} 
					conditionB.signal();
				}
				finally {

					lock.unlock();
				} 
			}
		}	
	}
	class ThreadB implements Runnable{
		@Override
		public void run() {
			if (count<=end) {
				lock.lock();
				try {
					for(int i=0;i<5;i++) {
						if (name != "B") {
							try {
								conditionB.await();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						System.out.println("线程B:------"+count);

						name="C";
						count++;
					} 
					conditionC.signal();
				}
				finally {

					lock.unlock();
				} 
			}

		}	
	}
	class ThreadC implements Runnable{
		@Override
		public void run() {
			if (count<=end) {
				lock.lock();
				try {
					for(int i=0;i<5;i++) {
						if (name != "C") {
							try {
								conditionC.await();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						System.out.println("线程C:------"+count);

						name="A";
						count++;
					} 
					conditionA.signal();
				}
				finally {

					lock.unlock();
				} 
			}	}
	}
}
