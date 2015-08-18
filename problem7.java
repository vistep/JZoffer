package JZoffer;
import java.util.*;
public class problem7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<Character> queue = new MyQueue<Character>();
		queue.addTail(Character.valueOf('a'));
		queue.addTail(Character.valueOf('b'));
		queue.addTail(Character.valueOf('c'));
		System.out.println(queue.pophead());
		System.out.println(queue.pophead());
		queue.addTail(Character.valueOf('d'));
		System.out.println(queue.pophead());
		System.out.println(queue.pophead());
		System.out.println(queue.pophead());
	}

}

class MyQueue<T> {
	List<T> stack1;
	List<T> stack2;
	public MyQueue() {
		stack1 = new ArrayList<T>();
		stack2 = new ArrayList<T>();
	}
	public void addTail(T e) {
		stack1.add(e);
	}
	public T pophead() {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			System.out.println("Quere is empty!");
			return null;
		} else {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					T tmp = stack1.get(stack1.size() - 1);
					stack1.remove(stack1.size() - 1);
					stack2.add(tmp);
				}
				T tmp = stack2.get(stack2.size() - 1);
				stack2.remove(stack2.size() - 1);
				return tmp;
			} else {
				T tmp = stack2.get(stack2.size() - 1);
				stack2.remove(stack2.size() - 1);
				return tmp;
			}
		}
	}
}
