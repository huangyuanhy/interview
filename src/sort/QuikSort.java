/**
 * 
 */
package sort;

/**
 * ------快速排序算法
 * @author Administrator
 *
 */
public class QuikSort {
	public static void main(String args[]) {
		int[] num= {5,3,7,6,1,0,4,7};
		 Sort(num,0,num.length-1);
		 for(int k:num) {
			 System.out.println(k);
		 }
	}
	static void Sort(int[] num ,int start, int end) {
		
		 if(start<end) { 
			 int index = SortUnit(num ,start, end);
			 Sort(num,start,index-1);//左边再排序
			 Sort(num,index+1,end);//右边排序
			
		 }
		
	}
	//-------排序核心代码-------------
	static int SortUnit(int[] num ,int start, int end) {																											
		int flag=num[start];//标杆
		int i=start; 
		int j=end; 
		while(i!=j) {
			while(i<j) {
				if(num[j]<flag) { //最右边的数比标杆小的话，传给i
					num[i]=num[j];
					break;
				}
				j--;
			}
			while(i<j) {
				if(num[i]>=flag) {
					//左边比标杆大的数，传给j
					num[j]=num[i];
					break;
				} 
				i++;
			}
		}
		num[i]=flag;
		return i;
	}
}
