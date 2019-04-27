package chain;
public class Chain {
	Chain next=null;
	int value=0;
	Chain(int value){
		this.value=value;
	}
	Chain(int value,Chain node){
		this.value=value;
		this.next=node;
	}
	public static Chain init(int[] arr) {
		Chain top=null;

		for(int i=0;i<arr.length;i++) {
			top=new Chain(arr[i],top);
		}
		return top;
	}
}

