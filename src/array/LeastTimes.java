package array;
import java.util.Scanner; 
/**
 * 删除字符串中出现最小次数的字符，打印剩下的。
 * @author Administrator
 *2018年9月29日
 */
public class LeastTimes {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {			
			int min = 21; 			
			int[] a = new int[256]; 			
			String s = sc.nextLine(); 			
			for (int i = 0; i < s.length(); i++) {				
				int x = s.charAt(i);
				a[x]++;			
			} 			
			for (int i = 0; i < s.length(); i++) {				
				int x = s.charAt(i);				
				if (a[x] < min) {					
					min = a[x];				
					}			
				} 			
			for (int i = 0; i < s.length(); i++) {				
				int x = s.charAt(i);				
				if (a[x] != min) {					
					System.out.print(s.charAt(i));				
					}			
				}			
			System.out.println(); 		
			}	
		}
	}

