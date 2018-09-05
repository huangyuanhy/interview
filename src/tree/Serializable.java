/**
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Administrator
 *2018年8月22日
 *二叉树的序列化
 */
public class Serializable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node one = new Node(1);
		Node two = new Node(2);
		Node thr = new Node(3);
		one.left=two;one.right=thr;
		String serialHierarchy = serialHierarchy(one);
		System.out.println(serialHierarchy);
		Node head = deSerialHierarchy(serialHierarchy);
		System.out.println(head);

		/*		String serial = serialInOrder(one);
		System.out.println(serial);*/
		//Node deSerial = deSerial(serial);
		//System.out.println(deSerial);
		/*String serial = serial(one);
		System.out.println(serial);
		Node deSerial = deSerial(serial);
		System.out.println(deSerial);*/
	}
	/**
	 * 层次反序列化
	 * @param string
	 * @return
	 */
	public static Node deSerialHierarchy(String string) {
		String[] str = string.split("!");
		int index=0;
		Node head = generateNodeByString(str[index++]);
		Queue<Node> queue=new LinkedList<>();
		queue.offer(head);
		Node n=null;
		while (queue.size()!=0) {
			n=queue.poll();

			n.left=generateNodeByString(str[index++]);
			n.right=generateNodeByString(str[index++]);
			if (n.left!=null) {

				queue.offer(n.left);
			}
			if (n.right!=null) {
				queue.offer(n.right);

			}

		}
		return head;

	}
	public static Node generateNodeByString(String str){
		if ("#".equals(str)) {
			return null;
		}else {
			return new Node(Integer.valueOf(str));
		}
	}
	/**
	 * 层次序列化
	 * @param head
	 * @return
	 */
	public static String serialHierarchy(Node head) {
		if (null==head) {
			return "#!";
		}
		String string=head.value+"!";
		Queue<Node> queue=new LinkedList<>();
		queue.offer(head);
		while (queue.size()!=0) {
			Node n = queue.poll();
			if (n.left!=null) {
				queue.add(head.left);
				string+=head.left.value+"!";
			}else {
				string+="#!";
			}
			if (n.right!=null) {
				queue.add(head.right);
				string+=head.right.value+"!";
			}else {
				string+="#!";
			}
		}
		return string;
	}
	/**
	 * 中序序列化
	 * @param head
	 * @return
	 */
	public static String serialInOrder(Node head) {
		if (head==null) {
			return "#!";
		}
		String res="";
		res+=serialInOrder(head.left);
		res+=head.value+"!";
		res+=serialInOrder(head.right);
		return res;
	}
	/**
	 * 先序序列化
	 * @param head
	 * @return
	 */
	public static String serial(Node head) {
		if (head==null) {
			return "#!";
		}
		String res=head.value+"!";
		res+=serial(head.left);
		res+=serial(head.right);
		return res;
	}

	public static Node deSerial(String string) {
		String[] str = string.split("!");
		Queue<String> queue=new LinkedList<>();
		for (int i = 0; i < str.length; i++) {
			queue.add(str[i]);
		}
		return solution(queue);
	}
	/**
	 * 中序反序列化    尼玛好像不能反序列化
	 * @param string
	 * @return
	 */
	public static Node solutionInOrder(Queue<String> queue) {
		String string = queue.poll();
		while (string.equals("#")) {
			//return null;
			string=queue.poll();
		}
		Node head=null;

		head.left=solution(queue);
		head=new Node(Integer.valueOf(string));
		head.right=solution(queue);
		return head;
	}
	/**
	 * 先序反序列化
	 * @param string
	 * @return
	 */
	public static Node solution(Queue<String> queue) {
		String string = queue.poll();
		if (string.equals("#")) {
			return null;
		}
		Node head=new Node(Integer.valueOf(string));
		head.left=solution(queue);
		head.right=solution(queue);
		return head;
	}

}
