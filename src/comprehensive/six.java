package comprehensive;
/**
 * 字符串转成整数
 * @author Administrator
 *2018年11月25日
 */
public class six {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println('0'-'7');
		System.out.println('b'-'d');
	}
	
	private static int convert(String str) throws Exception{
		if (str==null||str.equals("")) {
			return 0;
		}
		if (!isValid(str)) {
			return 0;
		}
		
		boolean flag=str.charAt(0)=='-'?false:true;
		int a=Integer.MAX_VALUE/10;//214748364
		int b=Integer.MIN_VALUE%10;//-8
		
		int res=0;
		int cur=0;
		for(int i=flag?0:1;i<str.length();i++) {
			cur='0'-str.charAt(i);
			if (res<a||(res==a&&cur<b)) {
				return 0;
			}
			res=res*10+cur;
		}
		if (flag&&res==Integer.MIN_VALUE) {
			return 0;
			
		}
		return flag?-res:res;
	}

/**
 * 先检查字符串是否有效
 * @param str
 * @param index
 * @return
 */
	private static boolean isValid(String str) {
		if (str.charAt(0)=='-') {
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(0)>='0'||str.charAt(0)<='9') {
					return true;
				}else {
					return false;
				}
			}
			return false;
		}else {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(0)>='0'||str.charAt(0)<='9') {
					return true;
				}else {
					return false;
				}
			}
			return false;
		}

	}
	/*
	 * 自己瞎写的
	 */
	private static void name(String str) {
		boolean flag=str.charAt(0)=='-'?true:false;
		int res=0;
		int cur=0;
		for (int i = flag?1:0; i < str.length(); i++) {
			if (flag) {
				res=10*res+('0'-str.charAt(i));//负的
			}else {
				res=10*res+(str.charAt(i)-'0');
			}
			
		}
	}
}
