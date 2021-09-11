package queue;
import java.util.Stack;

/**
 * 最小栈
 */
public class AntMinStack {
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    /**
     * push 放入元素
     * @param data
     */
    public void push(int data) {
        stack.push(data);
        if (minStack.empty()) {
            minStack.push(data);
        } else {
            Integer min = minStack.peek();
            if (min != null && min.intValue() > data) {
                minStack.push(data);
            }
        }
    }

    /**
     * pop 推出元素
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        Integer data =  stack.pop();
        if (data != null && !minStack.empty() 
        		&& data.intValue() == minStack.peek()) {
            minStack.pop();
        }
        return data;
    }

    /**
     * min 最小函数，调用该函数，可直接返回当前AntMinStack的栈的最小值
     *
     * @return
     * @throws Exception
     */
    public int min() throws Exception {
        return minStack.peek();
    }

}
