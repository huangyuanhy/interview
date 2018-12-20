package dynamic;

import java.util.Scanner;

public class Beike {
/**
 * 3
1 1 0
0 1 0
0 1 1
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stubs
		/*Scanner scanner=new Scanner(System.in);
		int num = scanner.nextInt();
		int[][] arr=new int[num][num];
		int i=0;
		while (i<num) {
			int j=0;
			while (j<num) {
				arr[i][j]=scanner.nextInt();				
				j++;
			}
			i++;
		}
		solution(arr);*/
		String str1="ad";
		String str2="abcde";
		name(str1, str2);

	}
	public static void name(String str1,String str2) {
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int count=c1.length;
		int num=0;
		int i=0;int j=0;
		while( i<c1.length) {
			while(j<c2.length) {
				if (c1[i]==c2[j]) {
					num++;
					j++;
					break;
				}
				j++;				
			}
			i++;
		}
		if (num==count) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
	}
	public static void solution(int[][] arr) {
		int len=arr.length;
		int[][] res=new int[len][len];
		res[0][0]=arr[0][0];
		for (int i = 1; i < res.length; i++) {
			res[0][i]=res[0][i-1]+arr[0][i];
		}
		for (int i = 1; i < res.length; i++) {
			res[i][0]=res[i-1][0]+arr[i][0];
		}
		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res.length; j++) {
				res[i][j]=Math.max(res[i][j-1], res[i-1][j])+arr[i][j];
			}
		}
		System.out.println(res[len-1][len-1]);
	}

}
