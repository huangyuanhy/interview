package thread;

/**
 * 实例化三个线程，一个线程打印a，一个线程打印b，一个线程打印c，三个线程同时执行，要求打印出10个连着的abc。  这种方法容易死锁
 * @author Administrator
 *2018年8月13日
 */
public class PrintABC {
	
	public static void main(String[] args) {
		Object obj = new Object();
		for(int i =0;i<3;i++){
			new Thread(new myThreads(obj,""+(char)(i+65),i)).start();
		}
	}
}
class myThreads implements Runnable{
	private Object obj;
	private String name;
	private int i;
	
	private static int count = 0;
	
	public myThreads(Object obj,String name, int i) {
		this.obj = obj;
		this.name = name;
		this.i = i;
	}
 
	@Override
	public void run() {
		synchronized (obj) {
			for(int n=0;n<10;n++){
				obj.notifyAll();
				if((count%3)!=i){
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.print(name);
				count++;
				try {
					//等待下一次循环打印
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
