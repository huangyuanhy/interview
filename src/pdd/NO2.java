/**
 * 
 */
package pdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author huangyuan
 * @date 2018年11月13日下午8:09:41
 * @Description
 * 输入一个字符串比如{[(2+3)*(1-3)] + 4}*(14-3)，分析它的括号使用是否正确
括号有三种，小括号()，中括号[]，大括号{}
 */
public class NO2 {
	public static void main(String[] args) {
		String string="{[(2+3)*(1-3)] + 4}*(14-3)";
		System.out.println(isMatch(string));
	}

	public static boolean isMatch(String s){
		Map<Character, Character> pair = new HashMap<Character, Character>();
		pair.put(')', '(');
		pair.put('}', '{');
		pair.put(']', '[');

		Stack<Character> sc = new Stack<Character>();
		for (int i = 0; i < s.length(); i++){
			Character ch = s.charAt(i);
			if (pair.containsValue(ch)){
				// 如果是左括号，放入栈中
				sc.push(ch);
			} else if (pair.containsKey(ch)) {// 如果是右括号
				if (sc.empty()) {
					// 栈为空，栈头没有字符与右括号匹配              
					return false;
				}
				// 栈不为空，栈头字符与右括号匹配
				if (sc.peek() == pair.get(ch)){
					sc.pop();
				} else{ // 栈不为空，栈头字符不与右括号匹配
					return false;
				}
			}

		}

		return sc.empty() ? true : false;
	}


}
