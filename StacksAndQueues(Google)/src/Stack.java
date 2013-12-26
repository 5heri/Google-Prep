
public class Stack {
	
	private Node top;
	private int size;
	private int capacity;
	
	public Stack(int capacity) {
		this.top = null;
		this.size = 0;
		this.capacity = capacity;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public void push(int value) throws Exception {
		if (!isFull()) {
			Node newNode = new Node(value);
			if (top == null) {
				top = newNode;
			} else {
				newNode.setNext(top);
				top = newNode;
			}
			size++;
		} else {
			throw new Exception("Stack is full.");
		}
	}
	
	public int pop() throws Exception {
		if (top != null) {
			int value = top.getValue();
			top = top.getNext();
			size--;
			return value;
		} else {
			throw new Exception("Stack is empty.");
		}
	}
	
	public int peek() throws Exception {
		if (top != null) {
			return top.getValue();
		} else {
			throw new Exception("Stack is empty.");
		}
	}

}
