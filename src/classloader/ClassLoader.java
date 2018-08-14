package classloader;

import org.junit.Test;

public class ClassLoader {
	@Test
	public void test() {
		java.lang.ClassLoader classLoader = ClassLoader.class.getClassLoader();
		System.out.println("calssloader is:"+classLoader.toString());
		System.out.println("calssloader's parent is:"+classLoader.getParent().toString());
		//ExtClassLoader的parent为null,但是其父加载器是bootstrapclassloader 因为它是由c++语言写的，所有程序中不能直接调用
		System.out.println("calssloader's parent's parent is:"+classLoader.getParent().getParent().toString());
		System.out.println("calssloader is:"+String.class.getClassLoader());
		
	}
}
