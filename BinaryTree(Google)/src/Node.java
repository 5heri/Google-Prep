
public class Node {

	private int value;
	private Node left;
	private Node right;
	
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public void setValue(int newValue) {
		this.value = newValue;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setLeft(Node newLeft) {
		this.left = newLeft;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setRight(Node newRight) {
		this.right = newRight;
	}
	
	public Node getRight() {
		return right;
	}
}
