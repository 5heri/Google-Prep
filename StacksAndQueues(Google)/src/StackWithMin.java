import java.util.ArrayList;


public class StackWithMin {
	
	private Node top;
	private ArrayList<Integer> minTracker;
	
	public StackWithMin() { 
		this.top = null;
		this.minTracker = new ArrayList<Integer>();
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(int value) {
		int currentMin = Math.min(value, checkMin());
		minTracker.add(currentMin);
		Node newNode = new Node(value);
		if (top == null) {
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}
	}
	
	public int peek() throws Exception {
		if (top != null) {
			return top.getValue();
		} else {
			throw new Exception("Stack is empty");
		}
	}
	
	public int pop() throws Exception {
		if (top != null) {
			int value = top.getValue();
			top = top.getNext();
			getMin();
			return value;
		} else {
			throw new Exception("Stack is empty");
		}
	}
	
	private int getMin() {
		if (minTracker.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minTracker.remove(minTracker.size() - 1);
		}
	}
	
	private int checkMin() {
		if (minTracker.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minTracker.get(minTracker.size() - 1);
		}
	}
	
	public int checkCurrentMin() throws Exception {
		if (minTracker.isEmpty()) {
			throw new Exception("Stack is empty");
		} else {
			return minTracker.get(minTracker.size() - 1);
		}
	}
	
	public void displayMins() {
		for (int i = 0; i < minTracker.size(); i++) {
			System.out.print(minTracker.get(i) + " ");
		}
		System.out.println();
	}

}
