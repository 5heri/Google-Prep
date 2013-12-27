
public class MyQueue {

	private Stack helperStack;
	private Stack finalStack;
	
	public MyQueue() {
		helperStack = new Stack();
		finalStack = new Stack();
	}
	
	public void enqueue(int value) throws Exception {
		
		while (!finalStack.isEmpty()) { 
			helperStack.push(finalStack.pop());
		}
		finalStack.push(value);
		while (!helperStack.isEmpty()) {
			finalStack.push(helperStack.pop());
		}
	}
	
	public int dequeue() throws Exception {
		return finalStack.pop();
	}
	
	public int peek() throws Exception {
		return finalStack.peek();
	}
	
	public int size() {
		return finalStack.size();
	}
}
