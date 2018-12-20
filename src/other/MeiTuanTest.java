package other;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * 5 3 2
  3 1 1 1 2
 * @author Administrator
 *2018年9月7日
 */
public class MeiTuanTest {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);		
			int n=scanner.nextInt();
			int k=scanner.nextInt();
			int t=scanner.nextInt();
			int[] a=new int[n];
			int i=0;
			while (n>0) {
				a[i++]=scanner.nextInt();
				n--;
			}
			int count=0;
			
			int l=0;//左边
			int r=0;//右边
			HashMap<Integer, Integer> map=new HashMap<>();
			while (l<a.length+1-k) {				
				r=k-1+l;
				for(int j=l;j<=r;j++) {					
					if (map.containsKey(a[j])) {
						map.put(a[j], map.get(a[j])+1);
					}else {
						map.put(a[j], 1);
					}
				}				
				for(Map.Entry<Integer,Integer> item:map.entrySet()) {
					if (item.getValue()>=t) {
						count++;
					}
				}
				map.clear();
				l++;
			}
			System.out.println(count);
	}
}
