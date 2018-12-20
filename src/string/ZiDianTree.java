package string;

import java.util.Scanner;
/**
 * 5
bytedance       b
toutiaohao      toutiaoh
toutiaoapp       toutiaoa
iesaweme        iesa
iestiktok      iest


 * @param str
 * @return
 */
public class ZiDianTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int num = scanner.nextInt();
		String[] strings=new String[num];
		int d=0;
		while(num>0) {
			strings[d++]=scanner.nextLine();
			num--;
		}
		tree createtree = createtree(strings);
		PreOrder(createtree);

	}

	public static tree createtree(String[] str) {
		
		tree head=new tree('#');
		for (int i = 0; i < str.length; i++) {
			String s=str[i];
			insertintotree(head, s);
		}
		return head;
	}
	public static void insertintotree(tree root,String str){
		if(root==null || str.length()==0){
			return ;
		}
		for(int i=0;i<str.length();i++){
			//只是考虑小写字母
			if(str.charAt(i)>='a' && str.charAt(i)<='z'){
				if(root.childs[str.charAt(i)-'a']==null){
					tree node=new tree(str.charAt(i));
					root.childs[str.charAt(i)-'a']=node;
					root.childcount++;
					root=node;
				}else{
					root=root.childs[str.charAt(i)-'a'];
				}
			}
		}
		root.flag=true;
	}
	public static void PreOrder(tree root){
		if(root!=null){
			System.out.print(root.data);
			if(root.childcount!=0){
				for(int i=0;i<26;i++){
					PreOrder(root.childs[i]);
				}
			}else{
				System.out.println();
			}
		}
	}
	public static boolean Search_intree(tree root,String str){
		if(root==null || str.length()==0){
			return false;
		}else{
			int i=0;
			for(i=0;i<str.length();i++){
				//只是考虑小写字母
				if(root.childs[str.charAt(i)-'a']!=null){
					root=root.childs[str.charAt(i)-'a'];
				}else{
					break;
				}
			}
			if(i!=str.length()){
				return false;
			}else{
				if(root.flag==true){
					return true;
				}else{
					return true;
				}
			}
		}
	}
}
 class tree{
	char data;
	tree []childs;
	int childcount=0;
	boolean flag;//其中有的前缀也许是一个单独的单词，所以标记是否到该节点组成一个已有的字符串
	tree(char d){
		data=d;
		childs=new tree[26];
		childcount=0;
		flag=false;
	}


}
