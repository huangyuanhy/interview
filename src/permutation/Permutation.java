/**
 * 
 */
package permutation;

/**
 * ���ֵ�ȫ��������               ���õݹ��㷨
 * @author Administrator
 *
 */
public class Permutation {
	public static void main(String[] args) {
		int[] arr= {1,2,3};
		new Permutation().Perm(arr, 0, 2);
	}
	static int count=0;
	public void Perm(int[] arr,int k,int m) { // k����ʼ���е����֣�m�������һ�����е�����
		if (m==k) {
			for(int i=0;i<=m;i++) {
				System.out.print(arr[i]);
			}
			count++;
			
			System.out.println();
			System.out.println(count);
		}else {
			for(int i=k;i<=m;i++) {
				//�ӹ̶��������һ�����ν���
				Swap(arr,k,i);
				Perm(arr,k+1,m);
				Swap(arr,k,i);
			}
		}
	}

	private void Swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		  int t = arr[i];
	        arr[i] = arr[j];
	        arr[j] = t;
	}
}
