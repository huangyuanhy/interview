package array;

import java.util.ArrayList;
import java.util.LinkedList;

public class N_sum3 {
	static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    static LinkedList <Integer> fuck = new LinkedList<>();

    public static void main(String[] args) {
        int arr[] = new int[100];
        for(int i=0;i<100;i++){
            arr[i] = i+1;
        }
        //100是查找和为100的数字，0是数组开始位置，arr.length-1是数组结束位置
        findList(100,arr,0,arr.length-1);
        for(ArrayList list :lists){
            System.out.println(list);
        }
    }
//sun要找的和为定值的数，arr数组是找数的范围，start是标记当前递归的下标，end是用来跟start判断的如果小于start就结束递归
    public static void findList(int sum, int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if (sum == arr[start]) {
            ArrayList<Integer> list = new ArrayList<>();
            for(Integer num :fuck){
                list.add(num);
            }
            list.add(arr[start]);
            lists.add(list);
        } else {
            if (sum > arr[start]) {
                fuck.add(arr[start]);
                findList(sum - arr[start], arr, start + 1, end);
                fuck.remove(fuck.size()-1);
            }
            findList(sum, arr, start + 1, end);
        }
    }
}
