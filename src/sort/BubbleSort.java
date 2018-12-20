package sort;

/**
 * ð�������㷨
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] num= {3,5,1,3,5,2,7,4,7};
		Sort(num);
		StringBuilder sBuilder=new StringBuilder();
		for(int i=0;i<num.length;i++)
			System.out.print(num[i]);
	}

	static void Sort(int[] num) {
		for(int j =0;j<num.length-1;j++) {
			for(int i=0;i<num.length-j-1;i++) {

				if(num[i]>num[i+1]) {
					int flag=num[i+1];
					num[i+1]=num[i];
					num[i]=flag;
				}
			}
		}
	}
}
