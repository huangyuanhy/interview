/**
 * 
 */
package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *2018年7月23日 
 *数组中超过一半的元素
 */
public class BeyondHalf {
	public static void main(String[] args) {
		int[] a=new int[]{1,1,2,2,2,3};
		int count=0;
		Map<Integer, Integer> map=new HashMap();
		for(int i=0;i<a.length;i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i])+1);
			}else {
				map.put(a[i], 1);
			}
			if (map.get(a[i])>=(Math.ceil((a.length/2)+(a.length%2)))) {
				System.out.println(a[i]);
			}
		}
	}
}
