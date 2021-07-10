package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class YueSeFu {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int total = scanner.nextInt();//总人数
	        int num = scanner.nextInt();//幸运数
	        //将所有人加入集合数组
	        ArrayList<Integer> list = new ArrayList<>();
	        for (int j=1;j<=total;j++) {
	            list.add(j);
	        }
	        int[] res = solution(list, num);
	        //遍历幸运者数组，找到队尾者的序号（下标）
	        for(int i=0;i<res.length;i++){
	            if (res[i]==total) {
	                System.out.println(i+1);
	            }
	        }
	    }
	    public static int[] solution(List<Integer> list,int num) {
	        //定义返回结果
	        int[] luck=new int[list.size()];
	        int i=0;
	        int index=0;
	        while (list.size()!=0) {//队列不为空，就一直循环报数
	             for(int j=1;j<num;j++){
	                 //如果幸运数num=4，当j=3，即循环3次，index=3，list[3]指向下一个人（幸运者）
	                 //判断：如果是最后一个人报数了，将index=0,即下次由第一个人list[0]报数
	                 index=index==list.size()-1?0:index+1;
	             }
	             //j=4，将幸运者加入luck[],并去掉此人
	            luck[i++]=list.remove(index);
	             //如果队列中最后一个人是幸运者，将index=0，从头开始
	             index=index>=list.size()?0:index;
	        }
	        return luck;
	    }
}
