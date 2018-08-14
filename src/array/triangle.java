package array;

import org.junit.Test;

public class triangle {
	public static void  main(String[] srgs) {
		for(int k=1;k<10;k++) {
			for(int i=1;i<10;i++) {
				for(int j=1;j<10;j++) {
					int s=(10*k+i)*(10*k+i);
					if (s==100*j+(10*k+i)) {
						System.out.println(i+"-----"+j+"-----"+k);
					}
				}
				}
			}
		
	}
	//打印一正个三角形
	@Test
	public static void test1(int n) {
		/*for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}*/
/*		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if (!(i==j)) {
					
					System.out.print(" ");
				}else {
					
					System.out.print("*");
				}
			}
			System.out.println();
		}*/
	}
	
}
