/**
 * 
 */
package sort;

/**
 * ------���������㷨
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
			 Sort(num,start,index-1);//���������
			 Sort(num,index+1,end);//�ұ�����
			
		 }
		
	}
	//-------������Ĵ���-------------
	static int SortUnit(int[] num ,int start, int end) {																											
		int flag=num[start];//���
		int i=start; 
		int j=end; 
		while(i!=j) {
			while(i<j) {
				if(num[j]<flag) { //���ұߵ����ȱ��С�Ļ�������i
					num[i]=num[j];
					break;
				}
				j--;
			}
			while(i<j) {
				if(num[i]>=flag) {
					//��߱ȱ�˴����������j
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
