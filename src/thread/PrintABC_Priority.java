package thread;


public class PrintABC_Priority {
	static PrintABC_Priority printABC_Priority=new PrintABC_Priority();
	private static volatile int state=0;
	private static final int COUNT=10;
	
	public static void main(String[] args) {
		Object lock=new Object();
		
		Thread aThread=new Thread(printABC_Priority.new MyThread(0, 1, 'A', lock));
		Thread bThread=new Thread(printABC_Priority.new MyThread(1, 2, 'B', lock));
		Thread cThread=new Thread(printABC_Priority.new MyThread(2,0, 'C', lock));
		
		aThread.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		bThread.start();try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		cThread.start();
	}
	
	
	
	
	
	class MyThread implements Runnable{

		private int flag; 
		private int nextflag;
		
		private char printChar;//打印字符
		private final Object lock;

		public MyThread(int flag, int nextflag, char printChar, Object lock) {
			super();
			this.flag = flag;
			this.nextflag = nextflag;
			this.printChar = printChar;
			this.lock = lock;
		}

		@Override
		public void run() {
			synchronized (lock) {
				for(int i=0;i<COUNT;i++) {
					while (state!=flag) {
						try {
							lock.wait();
						} catch (Exception e) {
						}
					}
					System.out.print(printChar);
					state=nextflag;
					lock.notifyAll();
				}
			}
		}
		
	}
}
