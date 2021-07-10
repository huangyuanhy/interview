package array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 新希望笔试题 求二维数组种的一个点到另外一个点的路径
 * @author pc
 *2021年6月17日
 */
public class NewHopeThree {
	private static List<List<Integer>> allResult=new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		// 测试
		int[][] array= {{1,2,3},{4,5,6}};
		int start=1;
		int end=6;
		solution(array, start, end);
		
	}

	public static void solution(int[][] array, int start, int end) {
		int col = array[0].length - 1;
		int row = array.length - 1;

		boolean flag = true;
		int startRow = 0;
		int startCol = 0;

		int endRow = 0;
		int endCol = 0;
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= col; j++) {
				if (array[i][j] == start && flag) {
					startRow = i;
					startCol = j;
					flag = false;
				}
				if (array[i][j] == end) {
					endRow = i;
					endCol = j;
				}
			}
		}
		List<Integer> list=new ArrayList<>();
		list.add(array[startRow][startCol]);
		find(list, array, startRow, endRow, startCol, endCol);
		// 起始点坐标: 5,7
		// 结束点坐标: 9,8
		// 总路径数: 5
		// 所有路径:

		System.out.println("起始点坐标: " + startRow + "," + startCol);
		System.out.println("结束点坐标: " + endRow + "," + endCol);
		System.out.println("总路径数: " + allResult.size());
		System.out.println("所有路径: ");
		for (List<Integer> res : allResult) {
			String record = res.stream().map(data -> String.valueOf(data)).collect(Collectors.joining("->"));
			System.out.println(record);
		}

	}

	public static void find(List<Integer> res, int[][] array, int startRow, int endRow, int startCol, int endCol) {
		if (startRow == endRow && startCol == endCol) {
			allResult.add(new ArrayList<>(res));
			return;
		}
		
		if (endRow<startRow || endCol <startCol
				|| (startRow + 1 >= array.length && startCol + 1 >= array[0].length)) {
			return;
		}
		
		if (startRow + 1 < array.length ) {
			res.add(array[startRow + 1][startCol]);
			find(res, array, startRow + 1, endRow, startCol, endCol);
			res.remove(res.size() - 1);
		}
		if (startCol + 1 < array[0].length) {
			res.add(array[startRow][startCol + 1]);
			find(res, array, startRow, endRow, startCol + 1, endCol);
			res.remove(res.size() - 1);
		}
	}

}
