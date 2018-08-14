package colletion;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Collectiondsf {
	public static void  main(String srgs[]) {
		System.out.println("请输入字符串");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Map<String, Integer> map=new HashMap<>();
		if(str!=null) {
			for(int i=0;i<str.length();i++) {
				String key=str.charAt(i)+"";
				if(map.containsKey(key)) {
					map.put(key, map.get(key)+1);
				}else {
					map.put(key, 1);
				}
		}
		}
		
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			Integer integer = map.get(key);
			System.out.println(key+"---"+integer);
		
			//统计最高次数
			Collection<Integer> values = map.values();
			Integer max = Collections.max(values);
			if(integer==max)
			System.out.println("最多次数为"+key+"-----"+max);
		}
		
	}
}
