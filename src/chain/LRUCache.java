package chain;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class LinkedNode{
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
        public LinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
        public LinkedNode(){}
    }
    private Map<Integer,LinkedNode> cache=new HashMap<>();
    private LinkedNode head;
    private LinkedNode tail;
    private int size;
    private int capacity=10;
    public LRUCache(int cap){
        head=new LinkedNode();
        tail=new LinkedNode();
        head.next=tail;
        tail.pre=head;
        this.capacity=cap;
    }
    public void add(int key,int value){
       LinkedNode node= this.cache.get(key);
        if(node==null){
            LinkedNode newNode=new LinkedNode(key,value);
            cache.put(key,newNode);
            addHead(newNode);
            this.size++;
            if(size>capacity){
                LinkedNode tobeDelete=removeTail();
                cache.remove(tobeDelete.key);
                size--;
            }
        }else{
            node.value=value;
            modeToHead(node);
        }
    }
    private LinkedNode removeTail(){
    	LinkedNode node=tail.pre;
    	node.pre.next=tail;
        return node;
       
    }
    private void modeToHead(LinkedNode node){
        
    }
    private void addHead(LinkedNode node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    public void removeNode(LinkedNode node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
}
