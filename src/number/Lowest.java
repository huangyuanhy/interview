package number;

import org.junit.Test;

//��n!�ж����Ʊ�ʾ���λ1��λ��
public class Lowest {
	@Test
	public void test() {
		int count=number(4);
		System.out.println("n!��������Ʊ�ʾ���λ1��λ��"+count);
	}
	
	public int  number(int num) {
		int count=0;
		while (num !=0) {
		
				num>>=1;
				count+=num;
			
		}

		return count;
	}
}
