package number;

import org.junit.Test;

//求n!中二进制表示最低位1的位置
public class Lowest {
	@Test
	public void test() {
		int count=number(4);
		System.out.println("n!结果二进制表示最低位1的位置"+count);
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
