package sort;

import java.util.Arrays;

import org.junit.Test;

public class Insert {
@Test
public void test() {
	int[] arrays= {2,5,3,7,1,4};
	  //��ʱ����
    int temp;

    //���ѭ��������Ҫ���������(��1��ʼ��Ϊ����0λ��������������)
    for (int i = 1; i < arrays.length; i++) {

        temp = arrays[i];

        //���ǰһλ(�����������)�ȵ�ǰ����Ҫ����ô�ͽ���ѭ���Ƚ�[�ο��ڶ�������]
        while (i >= 1 && arrays[i - 1] > temp) {

            //������һ��λ�ã��õ�ǰ������֮ǰǰλ���бȽ�
            arrays[i] = arrays[i - 1];

            //������ǰ��ֱ���˳�ѭ��
            i--;

        }

        //�˳���ѭ��˵���ҵ��˺��ʵ�λ���ˣ�����ǰ���ݲ�����ʵ�λ����
        arrays[i] = temp;

    }
    System.out.println(Arrays.toString(arrays));
}

}
