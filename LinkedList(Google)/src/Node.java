
public class Node {
	
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	public void setValue(int newValue) {
		value = newValue;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setNext(Node newNode) {
		next = newNode;
	}
	
	public Node getNext() {
		return next;
	}

}
