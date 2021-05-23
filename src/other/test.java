package other;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		int[] income=new int[num];
		for (int i=0;i<num;i++) {
			income[i]=in.nextInt();
		}
		Arrays.sort(income);
		System.out.println(Arrays.toString(income));
	}
	
	
	
	List<Integer> salaryFrequency(int num , Integer[] salaries){
		Arrays.sort(salaries);
		return Arrays.asList(salaries);
	}
}
