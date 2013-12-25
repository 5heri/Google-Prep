
public class ArrayStack {

	// TODO: Remove magic numbers and perhaps use switch statements.
	
	private Node[] arrayStacks;
	private int pointToFirst;
	private int pointToSecond;
	private int pointToThird;
	
	
	public ArrayStack() {
		this.arrayStacks = new Node[300];
		this.pointToFirst = -1;
		this.pointToSecond = 99;
		this.pointToThird = 199;
	}
	
	public void push(int value, int stackNumber) throws Exception {
		Node newNode = new Node(value);
		if (stackNumber == 1) {
			if (pointToFirst < 99) {
				arrayStacks[pointToFirst + 1] = newNode;
				pointToFirst++;				
			} else throw new Exception("Stack is full");
		} else if (stackNumber == 2) {
			if (pointToSecond < 199) {
				arrayStacks[pointToSecond + 1] = newNode;
				pointToSecond++;
			} else throw new Exception("Stack is full");
		} else if (stackNumber == 3) {
			if (pointToThird < 299) {
				arrayStacks[pointToThird + 1] = newNode;
				pointToThird++;
			} else throw new Exception("Stack is full");
		} else throw new IndexOutOfBoundsException("There are 3 stacks."); 
	}
	
	public int peek(int stackNumber) throws Exception {
		if (stackNumber == 1) {
			return arrayStacks[pointToFirst].getValue();
		} else if (stackNumber == 2) {
			return arrayStacks[pointToSecond].getValue();
		} else if (stackNumber == 3) {
			return arrayStacks[pointToThird].getValue();
		} else throw new IndexOutOfBoundsException("There are 3 stacks.");
	}
	
	public int pop(int stackNumber) throws Exception {
		if (stackNumber == 1) {
			if (pointToFirst >= 0) {
				int value = arrayStacks[pointToFirst].getValue();
				pointToFirst--;
				return value;
			} else throw new Exception("Stack is empty");
		} else if (stackNumber == 2) {
			if (pointToSecond >= 100) {
				int value = arrayStacks[pointToSecond].getValue();
				pointToSecond--;
				return value;
			} else throw new Exception("Stack is empty");
		} else if (stackNumber == 3) {
			if (pointToThird >= 200) {
				int value = arrayStacks[pointToThird].getValue();
				pointToThird--;
				return value;
			} else throw new Exception("Stack is empty");
		} else throw new IndexOutOfBoundsException("There are 3 stacks.");
	}
}
