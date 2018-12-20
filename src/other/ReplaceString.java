package other;


import java.util.Scanner;
public class ReplaceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String nextLine=scanner.nextLine();
		String[] split = nextLine.split(" ");
		String res="";
		for (int i = 0; i < split.length; i++) {
			res=res+split[i]+"$50";
		}
		res=res.substring(0,res.lastIndexOf("$"));
		System.out.println(res);
		
		replaceString(nextLine);
	}

	/**
	 * @param nextLine
	 */
	private static void replaceString(String nextLine) {
		int count=0;
		for (int i = 0; i < nextLine.length(); i++) {
			if (nextLine.charAt(i)==' ') {
				count++;
			}
		}
		char[] cs=new char[nextLine.length()+2*count];
		int index1=nextLine.length()-1;
		int index2=cs.length-1;
		while (index2>=0&&index1>=0) {
			if (nextLine.charAt(index1)==' ') {
				cs[index2--]='0';
				cs[index2--]='5';
				cs[index2--]='$';
			}
			else {
				cs[index2--]=nextLine.charAt(index1);
			}
			index1--;
		}
		System.out.println(new String(cs));
	}

}
