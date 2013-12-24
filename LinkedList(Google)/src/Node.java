
public class Node {
	
	private int value;
	private Node next;
	
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
	
	// Need to override these methods so that access methods in collections 
	// work the way we want them to.

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Node compare = (Node) obj;
		return this.getValue() == compare.getValue();
	}
	
	

}
