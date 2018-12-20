package chain;



public class Node {
	
		Node next=null;
		  int value=0;
		Node(int value){
			 
			this.value=value;
		}
		Node(int value,Node node){
			this.value=value;
			this.next=node;
		}
		
		public static Node init(int[] arr) {
			Node top=null;
			
			for(int i=0;i<arr.length;i++) {
				top=new Node(arr[i],top);
			}
			return top;
		}
	}

