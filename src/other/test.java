package other;

import java.util.Scanner;

public class test {
//�����еĺͣ���һ��Ϊn���Ժ�ÿ��Ϊǰһ���ƽ������mΪһ��������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		while (in.hasNext()) {
			double n=in.nextDouble();
			int m=in.nextInt();
			double x=0.0;
			for (int i = 0; i < m; i++) {
				x=x+n;
				n=Math .sqrt(n);
			}
			System.out.printf("%.3f",x);
			System.out.println();
		}
	}

}
