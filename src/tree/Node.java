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
	
}
