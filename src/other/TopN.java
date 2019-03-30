/**
 * 
 */
package other;

import java.util.HashMap;
import java.util.Map.Entry;


/**
 * @author Administrator
 *2018年12月20日
 *topN代码 统计字符串出现的前N次次数
 *这个案例特别好
 */
public class TopN {
	
	public static void main(String[] args) {
		String[] string= {"1","1","2","1","2","3","3","5"};
		new TopN().print(string, 4);
	}
	
	
	public void print(String[] arr,int K) {
		HashMap<String, Integer> map = getMap(arr);
		Node[] heap=new Node[K];
		int index=0;
		
		for (Entry<String, Integer>entry:map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			Node node=new Node(key, value);
			
			if (index!=K) {
				heap[index]=node;
				heapInsert(heap, index++);
			}else {
				if (heap[0].times<node.times) {
					heap[0]=node;
					heapify(heap, 0, K);
				}
			}
		}
		//从大到小排序
		for (int i =index-1;i!=0;i--) {
			
			swap(heap, 0, i);
			heapify(heap, 0, i);
		}
		//打印
		for (int i = 0; i < heap.length; i++) {
			if (heap[i]==null) {
				break;
			}else {
				System.out.print("no."+(i+1)+":");
				System.out.println(heap[i].string+",times:"+heap[i].times);
			}
		}
	}


	/**
	 * @param arr
	 * 遍历字符生产hash表
	 */
	private HashMap<String, Integer> getMap(String[] arr) {
		HashMap<String,Integer> hashMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			String cur=arr[i];
			if (!hashMap.containsKey(cur)) {
				hashMap.put(cur, 1);
			}else {
				hashMap.put(cur, hashMap.get(cur)+1);
			}
		}
		return hashMap;
	}
	/**
	 * 从下往上调整
	 * @param heap
	 * @param index
	 */
	
	public void heapInsert(Node[] heap,int index) {
		while (index!=0) {
			int parent=(index-1)/2;
			if (heap[index].times<heap[parent].times) {
				swap(heap, index, parent);
				index=parent;
			}else {
				break;
			}
		}
	}
	/**
	 * 从上往下调整
	 * @param heap
	 * @param index
	 * @param size
	 */
	public void heapify(Node[] heap,int index,int size) {
		int left=index*2+1;
		int right=left+1;
		
		int smallest=index;
		while (left<size) {
			if (heap[smallest].times>heap[left].times) {
				smallest=left;
			}
			if (right<size&&heap[right].times<heap[smallest].times) {
				smallest=right;
			}
			if (smallest!=index) {
				swap(heap,smallest,index);
			}else {
				break;
			}
			index=smallest;
			left=index*2+1;
			right=left+1;
		}
	}
	public void swap(Node[] heap,int smallest,int index) {
		Node tmp=heap[smallest];
		heap[smallest]=heap[index];
		heap[index]=tmp;
	}
}
class Node{
	public String string;//字符串
	public int times;//相应的次数
	public Node(String string, int times) {
		this.string=string;
		this.times=times;
	}
}
