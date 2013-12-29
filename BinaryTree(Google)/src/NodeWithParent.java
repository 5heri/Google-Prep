
public class NodeWithParent {
	
	private int value;
	private NodeWithParent parent;
	private NodeWithParent left;
	private NodeWithParent right;
	
	public NodeWithParent(int value, NodeWithParent parent) {
		this.value = value;
		this.parent = parent;
		this.left = null;
		this.right = null;
	}
	
	public NodeWithParent(int value, NodeWithParent left, NodeWithParent right) {
		this.value = value;
		this.parent = null;
		this.left = left;
		this.right = right;
	}
	
	public void setParent(NodeWithParent parent) {
		this.parent = parent;
	}
	
	public NodeWithParent getParent() {
		return parent;
	}
	
	public void setValue(int newValue) {
		this.value = newValue;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setLeft(NodeWithParent newLeft) {
		this.left = newLeft;
	}
	
	public NodeWithParent getLeft() {
		return left;
	}
	
	public void setRight(NodeWithParent newRight) {
		this.right = newRight;
	}
	
	public NodeWithParent getRight() {
		return right;
	}

}
