package array;

import java.util.Scanner;

public class ExamOfBuisnessBank {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		scanner.useDelimiter("\\n|\\,");
		int x=scanner.nextInt();	
		int y=scanner.nextInt();
		int x1=scanner.nextInt();
		int y1=scanner.nextInt();
		int x2=scanner.nextInt();
		int y2=scanner.nextInt();
		int x3=scanner.nextInt();
		int y3=scanner.nextInt();
		int x4=scanner.nextInt();
		int y4=scanner.nextInt();
		boolean inside = isInside(x1, y1, x2, y2, x3, y3, x4, y4, x, y);
		System.out.println(inside);
	}
	public static boolean isInside(int x1,int y1,int x2,int y2,
			int x3,int y3,int x4,int y4,int x,int y) {
		if (y1==y2) {
			return isInside1(x1, y1, x4, y4, x, y);
		}
		int l=Math.abs(y4-y3);
		int k=Math.abs(x4-x3);
		int s=(int)Math.sqrt(k*k+l*l);
		int sin=l/s;
		int cos=k/s;
		int x1R=cos*x1+sin*y1;
		int y1R=-x1*sin+y1*cos;
		int x4R=cos*x4+sin*y4;
		int y4R=-sin*x4+cos*y4;
		int xR=cos*x+sin*y;
		int yR=-sin*x+cos*y;
		return isInside1(x1R, y1R, x4R, y4R, xR, yR);
	}
	private static boolean isInside1(int x1,int y1,int x4,int y4,
			int x,int y) {
		if (x<=x1) {
			return false;
		}
		if (x>=x4) {
			return false;
		}
		if (y>=y1) {
			return false;
		}
		if (y<=y1) {
			return false;
		}
		return true;

	}
}
