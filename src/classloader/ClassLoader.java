package classloader;

import org.junit.Test;

public class ClassLoader {
	@Test
	public void test() {
		java.lang.ClassLoader classLoader = ClassLoader.class.getClassLoader();
		System.out.println("calssloader is:"+classLoader.toString());
		System.out.println("calssloader's parent is:"+classLoader.getParent().toString());
		//ExtClassLoader��parentΪnull,�����丸��������bootstrapclassloader ��Ϊ������c++����д�ģ����г����в���ֱ�ӵ���
		System.out.println("calssloader's parent's parent is:"+classLoader.getParent().getParent().toString());
		System.out.println("calssloader is:"+String.class.getClassLoader());
		
	}
}
