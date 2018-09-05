package array;

import java.util.Scanner;

public class ScannerRead {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String line=null;
		/**
		 * line=scanner.nextLine()每调用一次 就读取一行，不需要额外的字符来标记输入结束，十分方便
		 * 也可以在整个循环中，每次读取一个 scanner.nextInt();
		 */
		
		/*Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {
			int n = cin.nextInt();          // n 个学生
			int[] arr = new int [n+1];
			for (int i = 1; i <=n ; i++) {
				arr[i] = cin.nextInt();
			}
			int K = cin.nextInt();            // 选出K个
			int d = cin.nextInt();   
		}*/
		
		while(scanner.hasNext()) {//读入第一行
			line=scanner.nextLine().trim();
			int n=Integer.parseInt(line);
			String second=scanner.nextLine();//读入第二行
			String[] split = second.trim().split(" ");
			int[] num=new int[n];
			for(int i=0;i<n;i++) {
				num[i]=Integer.parseInt(split[i]);
				
			}
			String third=scanner.nextLine();//读入第三行
			String[] s = third.trim().split(" ");
			int k=Integer.parseInt(s[0]);
			int d=Integer.parseInt(s[1]);

			System.out.println(n);
			System.out.println(num);
			System.out.println(k+d);
		}
	}
}
