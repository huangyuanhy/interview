package number;
//n!�����0�ĸ���

import org.junit.Test;

public class Factorial {
	@Test
	public void test() {
		int count=number(15);
		System.out.println("n!����й���"+count +"��0");
	}
	
	public int  number(int num) {
		int count=0;
		for(int j=1;j<=num;j++) {
			int k=j;
			while(k%5==0) {
				count++;
				k/=5;
			}
		}
		return count;
	}
}
