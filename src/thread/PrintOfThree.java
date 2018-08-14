/**
 * 
 */
package thread;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 
  然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20.
 * @author Administrator
 *2018年8月13日
 */
public class PrintOfThree {
	public static void main(String[] args) {
		Object obj = new Object();
		for(int i=1;i<=3;i++){//传入对象锁 和 i值
			
			new Thread(new MyThread2(obj,i), "线程"+i).start();
		}
	}
}
class MyThread2 implements Runnable{
	private static int i = 0;//打印的值 1-75
	private static int count=0;//计数 三次一轮回
	private Object obj;
	private int n;//接参 i值
	public MyThread2(Object obj,int n) {
		this.obj=obj;
		this.n = n;
	}
	
 
	@Override
	public void run() {
		synchronized (obj) {
			while(i<75){//i++ 在代码块 所以到74就可以了
				
				obj.notifyAll();//唤醒所有线程
				
				if(count%3!=(n-1)){ //找出下一个线程  不正确的线程等待
					
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				i++;
				System.out.println(Thread.currentThread().getName()+": "+i);
				if(i%5 == 0){ //打印了五次后 此线程让出资源，等待
					try {
						count++; //count是static修饰 ，为了共享
						System.out.println();
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
