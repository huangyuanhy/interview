package sort;

import java.util.Arrays;

public class Dui {
	public static void main(String[] args) {

	    int[] arrays = {6, 3, 8, 7, 5, 1, 2, 23, 4321, 432, 3,2,34234,2134,1234,5,132423, 234, 4, 2, 4, 1, 5, 2, 5};

	    for (int i = 0; i < arrays.length; i++) {

	        //ÿ���һ�ν��ѾͿ����ų�һ��Ԫ����
	        maxHeapify(arrays, arrays.length - i);

	        //����
	        int temp = arrays[0];
	        arrays[0] = arrays[(arrays.length - 1) - i];
	        arrays[(arrays.length - 1) - i] = temp;

	    }

	    System.out.println(Arrays.toString(arrays));


	}

	/**
	 * ���һ�ν��ѣ����ֵ�ڶѵĶ���(���ڵ�)
	 */
	public static void maxHeapify(int[] arrays, int size) {

	    for (int i = size - 1; i >= 0; i--) {
	        heapify(arrays, i, size);
	    }

	}


	/**
	 * ����
	 *
	 * @param arrays          ��������ȫ������
	 * @param currentRootNode ��ǰ���ڵ�λ��
	 * @param size            �ڵ�����
	 */
	public static void heapify(int[] arrays, int currentRootNode, int size) {

	    if (currentRootNode < size) {
	        //����������������λ��
	        int left = 2 * currentRootNode + 1;
	        int right = 2 * currentRootNode + 2;

	        //�ѵ�ǰ���ڵ�λ�ÿ���������
	        int max = currentRootNode;

	        if (left < size) {
	            //����ȵ�ǰ��Ԫ��Ҫ�󣬼�¼����λ��
	            if (arrays[max] < arrays[left]) {
	                max = left;
	            }
	        }
	        if (right < size) {
	            //����ȵ�ǰ��Ԫ��Ҫ�󣬼�¼����λ��
	            if (arrays[max] < arrays[right]) {
	                max = right;
	            }
	        }
	        //������Ĳ��Ǹ�Ԫ��λ�ã���ô�ͽ���
	        if (max != currentRootNode) {
	            int temp = arrays[max];
	            arrays[max] = arrays[currentRootNode];
	            arrays[currentRootNode] = temp;

	            //�����Ƚϣ�ֱ�����һ�ν���
	           heapify(arrays, max, size);
	        }
	    }
	}
	
}
