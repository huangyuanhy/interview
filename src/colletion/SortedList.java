package colletion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 一道简单的面试题 考察List集合、排序、二叉搜索、以及算法优化
 * 向集合添加元素，保证集合里的元素有序排列
 * @author Administrator
 *2019年4月12日
 */

public class SortedList {
	private static List<Integer> sortList=new LinkedList<>();
	public static void main(String[] args) {
		addElement1(3);
		addElement1(2);
		addElement1(7);
		addElement(5);
		addElement(3);
		addElement(4);
		System.out.println(Arrays.toString(sortList.toArray()));
	} 
	/**
	 * 第一种方式：遍历
	 * @param e
	 */
	public static void addElement(int e) {
		int index=0;
		for (int j : sortList) {
			if (e<=j) {
				sortList.add(index, e);
				break;
			}
			index++;
		}
		if (index>sortList.size()-1||sortList.isEmpty()) {
			sortList.add(index, e);
		}
	}
	/**
	 * 第二种方式：二叉搜索法 效率高
	 * @param e
	 */
	public static void addElement1(int e) {
		int index=find(sortList, e, 0, sortList.size()-1);
		sortList.add(index, e);
	}

	private static int find(List<Integer> list,int e,int start,int end) {
		if (list.isEmpty()) {
			return 0;
		}
		end=end>=list.size()?list.size()-1:end;//end 大于集合大小
		if (end<=start) {//递归出口
			if (list.get(end)>e) {
				return end;
			}else {
				return end+1;
			}
		}	
		int mid=(start+end)/2;
		if (list.get(mid)<=e) {
			return find(list, e, mid+1, end);
		}
		return find(list, e, start, mid);
	}
}
