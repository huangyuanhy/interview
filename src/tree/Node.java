package tree;
public class Node {
	Integer value;
	Node left;
	Node right;
	public Node(Integer value, Node left, Node right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public Node(Integer value) {
		this.value=value;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Node initNode(){
		Node head = new Node(1);
		Node two = new Node(2);
		Node thr = new Node(3);
		Node fou = new Node(4);
		Node fiv = new Node(5);
		Node six = new Node(6);
		Node sev = new Node(7);
		head.left=two;head.right=thr;
		two.left=fou;two.right=fiv;
		thr.left=six;thr.right=sev;
		
		return head;
	}
	
}
