package array;

import java.util.Scanner;

public class JumpRiver {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		while(scanner.hasNext()) {
			int n=scanner.nextInt();//读入第一行
			int[] num=new int[n];
			for(int i=0;i<n;i++) {
				num[i]=scanner.nextInt();

			}
			System.out.println(dtgh(n,num));
	    }
	}
	    /*
	     * 在数组后增加一位，最终目的是跳到这一位置
	     * 那么只要该位前面的某一位i能跳跃的距离超过最后一位，就一定能过河
	     * 所以，求整体的最优变成求能跳到i的最优，以此类推
	     */
	    public static int dtgh(int n,int[] arr) {//动态规划
	    	int[]res = new int[n+1];//用于存储跳到指定位置的最佳跳跃次数
	    	res[0] = 0;
	    	for(int k=1;k<=n;k++) {
	    		int temp = Integer.MAX_VALUE;
		    	for(int i=0;i<k;i++) {
		    		if(arr[i]+i>=k && res[i]+1<temp) {
	    				res[k] = res[i]+1;
	    				temp = res[k];
	    			}
		    	}
	    	} 
	    	//System.out.println(Arrays.toString(res));
	    	for(int i=1;i<=n;i++) {//除了第一位，其它出现0，说明掉河里了
	    		if(res[i]==0)
	    			res[n]=-1;
	    	}
	    	return res[n];
	    }


			/*int count=0;
			for(int i=0;i<num.length;i++) {
				for(int j=i+1;j<i+num[i]&&j<num.length;j++) {
					if (num[i]==0) {
						continue;
					}
					int tmp=num[j];
					tmp=Math.max(tmp, num[j+1]);
					if (tmp==num[j]) {
						count++;
						i=j;
					}
				}
			}
			System.out.println(count);*/
		
	}

