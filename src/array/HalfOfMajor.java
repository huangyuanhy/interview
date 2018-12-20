/**
 * 
 */
package array;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 *2018年8月20日
 *大于数组长度一半的元素  
 */
public class HalfOfMajor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,3,3,1};
		halfOfK(a, 3);
	}
	/**
	 * 数组中出现次数大于N/K的元素
	 * @param a
	 */
	public static void halfOfK(int[] a,int K) {
		//第一个循环结束后集合里的元素是留下来的元素，可能是满足要求的元素
		ConcurrentHashMap<Integer, Integer> map=new ConcurrentHashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i])+1);
			}else {
				map.put(a[i], 1);
			}
			if (map.size()==K) {
				//集合里的元素等于K个数了，就把其次数减一
				for(Map.Entry<Integer,Integer> item:map.entrySet()) {
					Integer value = item.getValue();
					if (--value==0) {
						map.remove(item.getKey());
					}
				}
			}
		}
		//再用一个map来计算上个一个map中的元素在数组中出现的次数
		HashMap<Integer, Integer> map2=new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				if (map2.containsKey(a[i])) {
					map2.put(a[i], map2.get(a[i])+1);
				}else {
					map2.put(a[i], 1);
				}
			}
		}
		//判断集合中的元素次数是否满足要求
		for(Map.Entry<Integer,Integer> item:map2.entrySet()) {
			if (item.getValue()>(a.length/K)) {
				System.out.println(item.getKey());
			}
		}
	}


/**
 * 这个算法很牛逼  大于数组长度一半的元素  
 * @param a
 */
public static void printHalf(int[] a) {
	int cand=0;
	int times=0;
	for (int i = 0; i < a.length; i++) {
		if (times==0) {
			cand=a[i];
			times=1;

		}else if (a[i]==cand) {
			times++;

		}else {
			times--;
		}
	}
	System.out.println(cand);
	//cand是最后留下来的那个数，但是不一定就是次数超过一半的数，下面统计cand出现的次数 所以下面的步骤必不可少。
	times=0;
	for (int i = 0; i < a.length; i++) {
		if (a[i]==cand) {
			times++;
		}
	}
	if (times>a.length/2) {
		System.out.println(cand);
	}else {
		System.err.println("error");
	}
}

}
