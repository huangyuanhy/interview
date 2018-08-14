package array;

import java.util.Arrays;
/**
 * 和并两个有序数组
 * @author 黄渊
 *2018年8月9日
 */
public class Merge {
	public static void main(String[] args) {
		int[] a= {3,4,6,8};
		int[] b= {1,2,3,4,8};
		int[] merger = merger(a, b);
		System.out.println(Arrays.toString(merger));
	}
	public static int[] merger(int[] a,int[] b) {
		
		if (a==null||a.length==0) {//参数校验
			return b;
		}
		if (b==null||b.length==0) {//参数校验
			return a;
		}
		int res[] = new int[a.length+b.length];
		 	int i=0;
	        int j=0;
	        int k=0;
	        
	    if (a[a.length-1]<=b[0]||b[b.length-1]<=a[0])   {  //此处是极端情况的优化算法
	    	
	    	return res = optimization(a, b,res);
	    }
		   
	        while(i<a.length&&j<b.length){
	            if(a[i]<=b[j]){
	                res[k++]=a[i++];
	                
	            }else{
	                res[k++]=b[j++];             
	            
	            }
	        }
	        //下面的循环只有一个会执行
	        while(i<a.length) {
	        	 res[k++]=a[i++];
	        }
	        while(i<b.length) {  
	        	 res[k++]=b[i++];
	        }
	        //res = distinct(res);//数组去除最后的0元素	        
	        return res;
	    }
	
	private static int[] distinct(int[] res) {
		int count=0;//如果数组中有重复的元素  去除数组最后的0
		for(int h=res.length-1;h>=0;h--) {
			if (res[h]==0) {
				count++;
			}
			else {
				break;
			}
		}
		if (count!=0) {
			res=Arrays.copyOfRange(res, 0, res.length-count);
		}
		return res;
	}
	/**
	 * @param a
	 * @param b
	 * @param res 返回的数组
	 * @return 极端情况进行优化合并 
	 */
	private static int[] optimization(int[] a, int[] b,int[] res) {
		
		if (a[a.length-1]<=b[0]) {//a的最大值都比b的最小值小  
			res = copy(a,b,res);			
		}
		if (b[b.length-1]<=a[0]) {//b的最大值都比a的最小值小  
			res=copy(b, a,res);
			
		}
		return res;
	}
	private static int[] copy(int[] a,int[] b,int[] res) {
		int k = 0;
		int i=0;
		int j=0;
		while(i<a.length) {
			res[k++]=a[i++];
		}
		while(j<b.length) {				
			res[k++]=b[j++];
		}
		return res;
	}
}

