package array;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author 黄渊
 * 2018年8月12日
 * 3 3
 * 0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
 * exit
 */
public class ThoughtWorks {
    public static void main(String[] args) {        
        ThoughtWorks tWorks=new ThoughtWorks();
        String[] para =tWorks.initialParameter();//para[0]尺寸，para[1]连通性定义

        String[] dimensions = para[0].split(" ");
        String[] connetion = para[1].split(";");

        String[][] a =tWorks.mazeSize(dimensions);//迷宫大小            
        HashMap<Integer, LinkedList<Integer>> map =tWorks.createConnetion(connetion,a);//联通性参数解析


        tWorks.mazeSolution(a, map);//根据相关参数打通道路-->[R]
        tWorks.print(a);
    }
    /**
     * 联通性实现
     * @param a 迷宫大小 数组表示
     * @param map 参数封装
     */
    private void mazeSolution(String[][] a, HashMap<Integer, LinkedList<Integer>> map) {
        if (a!=null&&a.length!=0&&map!=null) {
            for(int i=0;i<map.size();i++) {
                LinkedList<Integer> linkedList = map.get(i);
                if (linkedList.size()!=4) {
                    throw new RuntimeException("Incorrect command format");
                }
                //将list中的四个元素取出来，
                Integer row_1 = linkedList.get(0);
                Integer col_1 = linkedList.get(1);
                Integer row_2 = linkedList.get(2);
                Integer col_2 = linkedList.get(3);

                a[row_1][col_1]="[R]";//第一、二个下标的元素
                a[row_2][col_2]="[R]";//第三、四个下标的元素
                Integer row_mid=0;
                Integer col_mid=0;
                if (row_1==row_2) {//如果在同一行上
                    col_mid=(col_2+col_1)>>1;//找到两个坐标的中间位置 也将其置为[R]
                    a[row_1][col_mid]="[R]";
                }else if (col_1==col_2) {//如果在同一列上          
                    row_mid= (row_2+row_1)>>1;//找到两个坐标的中间位置 也将其置为[R]
                    a[row_mid][col_1]="[R]";
                }else {//二者不联通 抛出异常
                    throw new RuntimeException("Maze format error");
                }
            }
        }else {
            throw new RuntimeException("Incorrect command format");
        }
    }
    /**
     * 迷宫大小
     * @param dimensions
     * @return
     */
    private String[][] mazeSize(String[] dimensions) {
        if (dimensions.length!=2||null==dimensions) {
            throw new RuntimeException("Incorrect command format");
        }
        int row;
        int col;
        try {
            row = Integer.parseInt(dimensions[0]);
            col = Integer.parseInt(dimensions[1]);
        } catch (Exception e) {
            throw new RuntimeException("Invalid number format");
        }
        String[][] a=new String[2*row+1][2*col+1];//实际的数组大小->道路网格加上渲染网格
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                a[i][j]="[W]";//数组显示初始化

            }           
        }
        return a;
    }
    /**
     * @param connetion
     * @return 连通性参数
     * 
     */
    private HashMap<Integer, LinkedList<Integer>> createConnetion(String[] connetion,String[][] arrays) {

        int length = connetion.length;//9
        HashMap<Integer, LinkedList<Integer>> map=new HashMap<>();
        LinkedList<Integer> list=null;
        for(int i=0;i<length;i++) {
            list=new LinkedList<>();    
            int len = connetion[i].length();//总长度包括数字、符号、空格 --->如第一个分号内容为0,1 0,2   其长度为7
            int k=0;
            int count=0;//记录是第几次循环
            while(k<len) {  
                count++;//如果count为奇数说明此下标为行下标,否则为列下标
                int tmp;
                try {//下面将每个分号里的数字找出来 即下标为 0,2,4,6                  
                    tmp = Integer.parseInt(connetion[i].substring(k, k + 1));//对指定位置进行截取  输入负数或者大于10的数字将报错，
                } catch (Exception e) {
                    throw new RuntimeException("Invalid number format");
                }
                //对tmp做合法性校验

                if (tmp<0) {
                    throw new RuntimeException("Number out of range");

                }else if(tmp==0){
                    //将截取出来的数字进行扩展成 实际的（即道路网格加上渲染网格）数组下标
                    tmp=1;

                }else {
                    //将截取出来的数字进行扩展成 实际的渲染网格-->数组下标
                    tmp=2*tmp+1;
                    if (((count&0x1)==0&&tmp>=arrays.length-1)//第偶数次循环得到的是列下标数字  不能越界
                            || ((count&0x1)!=0&&tmp>=arrays[1].length-1)) {//第奇数次循环得到的是行下标数字  不能越界
                        throw new RuntimeException("Number out of range");
                    }

            }

                list.add(tmp);//集合有序的存放两组下标
                k=k+2;
            }   
            map.put(i, list);//将每组list按序存入map中  参数解析完毕
        }
        return map;
    }
    /**
     * 从控制台接收参数
     * @return 两行参数
     */
    public String[] initialParameter() {

        Scanner scanner=new Scanner(System.in);
        String dimensions=null;
        String connetion=null;      

        while(scanner.hasNextLine()) {          
            dimensions=scanner.nextLine();          
            connetion= scanner.nextLine();
            if ("exit".equals(scanner.nextLine())) {
                break;
            }else {
                throw new RuntimeException("Incorrect command format");
            }
        }
        String[] para= {dimensions,connetion};
        return para;
    }
    /**
     * 打印二维数组
     * @param array
     */
    public void print(String[][] array) {
        for(int i=0;i<array.length;i++) {

            for(int j=0;j<array[i].length;j++) {

                System.out.print(array[i][j]+"  ");
            }
            System.out.println();
            System.out.println();


        }
    }
}