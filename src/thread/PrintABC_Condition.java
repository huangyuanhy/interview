package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PrintABC_Condition {
	Lock lock=new ReentrantLock();
	private Condition conditionA = lock.newCondition();   
	private Condition conditionB = lock.newCondition();   
	private Condition conditionC = lock.newCondition();  

	private volatile String name="A";//打印名称
	private volatile int count=0;
	
	public static void main(String[] args) {
		PrintABC_Condition pCondition=new PrintABC_Condition();
		ExecutorService pool = Executors.newFixedThreadPool(3);
		pool.execute(pCondition.new ThreadA());
		pool.execute(pCondition.new ThreadB());
		pool.execute(pCondition.new ThreadC());
		pool.shutdown();
	}
	class ThreadA implements Runnable{

		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				lock.lock();
				try {
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
					conditionB.signal();
				} finally {

					lock.unlock();
				}
			} 
		}	
	}
	class ThreadC implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				lock.lock();
				try {
					if (name!= "C") {
						try {
							conditionC.await();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					System.out.println("线程C:------C"+count);

					name="A";
					count++;
					conditionA.signal();
				} finally {

					lock.unlock();
				}
			} 

		}	
	}
	class ThreadB implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				lock.lock();
				try {
					if (name!= "B") {
						try {
							conditionB.await();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					System.out.println("线程B:------B"+count);
					name="C";
					count++;
					conditionC.signal();
				}  finally {

					lock.unlock();
				}
			}

		}	
	}
}
