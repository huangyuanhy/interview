package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	private static int MAX=30;
	private static Semaphore semaphore=new Semaphore(10);
	private static ExecutorService executorService=Executors.newFixedThreadPool(MAX);
	public static void main(String[] args) {
		for(int i=0;i<MAX;i++) {
			executorService.execute(()->{
			try {
				semaphore.acquire();
				System.out.println("save data");
				semaphore.release();
			}catch (Exception e) {
				// TODO: handle exception
			}
			});
		}
		executorService.shutdown();
	}
}
