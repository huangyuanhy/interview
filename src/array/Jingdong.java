package array;

import java.util.Scanner;

public class Jingdong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			int num=Integer.parseInt(scanner.nextLine());
			
			long[][] arr=new long[num][3];
			//初始化
			for (int i = 0; i < num; i++) {	
				String[] split = scanner.nextLine().split(" ");
				for (int j = 0; j < 3; j++) {						
					arr[i][j]=Integer.parseInt(split[j]);
					
				}
			}										
			int count=0;
			int left=0;
			int right=1;
			while (left<num-1) {// 0 1
				right=left+1; //1 2
				while (right<num) {
					long flag1=(arr[left][0]-arr[right][0])*(arr[left][1]-arr[right][1]);
					long flag2=(arr[left][0]-arr[right][0])*(arr[left][2]-arr[right][2]);
					if (flag1>0&&flag2>0) {
						count++;
					}
					right++;
				}
				left++;
			}

			System.out.println(count);
		}
	}

}
