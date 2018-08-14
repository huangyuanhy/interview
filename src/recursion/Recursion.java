package recursion;
/**
 * 递归算法   实例
 * @author Administrator
 *
 */

import java.io.File;

import org.junit.Test;



public class Recursion {
	public static void main(String args[]) {
	/*	//------递归求和----------------------
		long before = System.currentTimeMillis();
		System.out.println(test1(10));
		long after=System.currentTimeMillis();
		System.out.println(after-before);
		//-------利用数组求和-------------------
		System.out.println(test2(10));*/
		
		//--------------------文件夹递归----------
		test3(new File("E:\\Java相关资料\\文档"));
	}		
	//--------------计算裴波纳契数列 1 1 2 3 5 8 13-----------
	@Test
	public static Integer test1(int n) {
		if(n==1||n==2) {
			return 1;
		}
		else {
			return test1(n-1)+test1(n-2);
		}
	}
//---------------for循环计算上面的数列----------------
	public static Integer test2(int n) {
		int num1=1;
		int num2=1;
		int num3=0;
		for(int i=3;i<n+1;i++) {
			num3=num1+num2;
			
			num1=num2;
			num2=num3;
			
		}
		return num3;
	}
//---------------------树的遍历---文件夹遍历的递归算法---------------------------
	public static void test3(File f) {
		File[] file=f.listFiles();
		for(int i=0;i<file.length;i++) {
			if(file[i].isFile()) {
				
				System.out.println("文件如下："+file[i]);
			}
			else {
				test3(file[i]);
			}
		}
	}
}









