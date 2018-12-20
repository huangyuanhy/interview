package array;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DanceOfZiJie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNext()) {
			String nextLine = scanner.nextLine();
			char[] c = nextLine.toCharArray();
			if (c==null||c.length==0) {
				return ;
			}
			int left=0;
			int right=1;

			HashMap<Character, Integer> map=new HashMap<>();
			map.put(c[left], 1);
			int len=1;
			while (right<c.length) {
				Set<Character> key = map.keySet();
				if (key.contains(c[right])) {
					left=right;
					map.clear();
					map.put(c[right], 1);
					right++;
				}else {
					map.put(c[right], 1);
					len=Math.max(len, map.size());
					right++;
				}
			}
			System.out.println(len);
		}

	}
}
