/**
 * 
 */
package sort;


/**
 * @author Administrator
 *2018��3��20��
 */
public class QuickSort2 {
	public static void main(String[] args) {
	}
	public static void quickSort(int[] arr, int L, int R) {
	    int i = L;
	    int j = R;

	    //֧��
	    int pivot = arr[(L + R) / 2];

	    //�������˽���ɨ�裬ֻҪ���˻�û�н��棬��һֱɨ��
	    while (i <= j) {

	        //Ѱ��ֱ����֧������
	        while (pivot > arr[i])
	            i++;

	        //Ѱ��ֱ����֧��С����
	        while (pivot < arr[j])
	            j--;

	        //��ʱ�Ѿ��ֱ��ҵ��˱�֧��С����(�ұ�)����֧������(���)�����ǽ��н���
	        if (i <= j) {
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	            i++;
	            j--;
	        }
	    }
	    //����һ��while��֤�˵�һ������֧�����߱�֧��С��֧����ұ߱�֧����ˡ�


	    //����ߡ���������ֱ�����ʣ��һ����(�ݹ����)
	    if (L < j)
	        quickSort(arr, L, j);

	    //���ұߡ���������ֱ���ұ�ʣ��һ����(�ݹ����)
	    if (i < R)
	        quickSort(arr, i, R);
	}
	
}
