package dynamic;

public class subArray {

	    public static int dynaticMethod(int[] A){
	        int maxResult = A[0];   
	        int maxTemp = 0;
	        for(int i = 0;i < A.length;i++){
	            if(maxTemp >= 0)
	                maxTemp += A[i];
	            else
	                maxTemp = A[i];
	            if(maxTemp > maxResult)
	                maxResult = maxTemp;
	        }
	        return maxResult;
	    }
	    
	    public static void main(String[] args){
	        
	        int[] A = {-3,-2,3,10,-4,7};
	        System.out.println("ʹ�ö�̬�滮���������A����������������Ϊ��"+dynaticMethod(A));
	    
	    }
}
