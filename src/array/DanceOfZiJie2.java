package array;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//输入
//n：总用户数
//m：m对关注关系
//2*m个数字：代表m对关注关系
//若某个用户被n个人直接或间接关注，则可视为抖音红人
//"1", "2", "2", "1", "3", "2", "4", "2"
public class DanceOfZiJie2 {
	static HashMap<Integer, Integer> count=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ConcurrentHashMap<Integer, Integer> map=new ConcurrentHashMap<>();
		
		ConcurrentHashMap<Integer, Integer> mutual = mutualFocus(map);
		
		Set<Entry<Integer, Integer>> entrySet = mutual.entrySet();
		for(Entry<Integer, Integer> item:entrySet) {
			Integer value = item.getValue();
			Integer key = item.getKey();
			if (map.containsKey(value)) {
				
				
			}
		}
	}
	public static void solution(ConcurrentHashMap<Integer, Integer> map,int key,int value) {
		
		count.put(value, 0);//初始化此人的粉丝数为1  因为自己也间接关注自己了，起码有一个
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> item:entrySet) {
			if (item.getValue()==value) {//说明此value直接被人关注
				Integer num = count.get(value);
				count.put(value,num++);
			}else {//考察此人value是否被间接关注 把key作为value
				solution(map, value, key);
			}
		}
	}
	/**
	 * 
	 * @param map
	 * @return map中包含的数据就是相互关注的人
	 */
	public static ConcurrentHashMap<Integer, Integer> mutualFocus(ConcurrentHashMap<Integer, Integer> map) {
		ConcurrentHashMap<Integer, Integer> res=new ConcurrentHashMap<>();
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> item:entrySet) {
			Integer value = item.getValue();
			Integer key = item.getKey();
			if (map.containsKey(value)&&map.get(value)==key) {
				map.remove(value);//防止重复遍历
				res.put(key, value);
			}
		}
		return res;
	}
}