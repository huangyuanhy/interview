package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ["xyz", "yxz", "zxy", "ate", "eat", "abc"] 输出: [["xyz", "yxz","zxy"],
 * ["ate","eat"],["abc"]]
 * 
 * @author pc 2021年7月30日
 */

public class Meituan {

	public static void main(String[] args) {
		List<List<String>> solution = new Meituan().solution(Arrays.asList("xyz", "yxz", "zxy", "ate", "eat", "abc"));
		System.out.print(solution);
	}

	public static List<List<String>> solution(List<String> input) {
		List<List<String>> res = new ArrayList<List<String>>();
		res.add(Arrays.asList(input.get(0)));
		for (int k = 1; k < input.size(); k++) {
			String str = input.get(k);
			Iterator<List<String>> iterator = res.iterator();
			while (iterator.hasNext()) {
				List<String> data = iterator.next();
				if (belongto(data.get(0), str)) {
					data.add(str);
				} else {
					res.add(Arrays.asList(str));
				}
			}
		}
		return res;

	}

	/**
	 * 字符串是否完全匹配
	 * 
	 * @param origin
	 * @param str
	 * @return
	 */
	private static boolean belongto(String origin, String str) {
		List<Character> list = new LinkedList<>();
		for (int i = 0; i < origin.length(); i++) {
			list.add(origin.charAt(i));
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Character value = Character.valueOf(c);
			if (list.contains(value)) {
				list.remove(value);
			}
		}

		return list.size() == 0;
	}

}
