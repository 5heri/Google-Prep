
public class BinaryTree {
	
	private Node root;
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public int getRootElem() {
		return root.getValue();
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	private Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value);
		} else if (node.getValue() >= value) {
			node.setLeft(insert(node.getLeft(), value));
		} else {
			node.setRight(insert(node.getRight(), value));
		}
		return node;
	}
	
	
	

}
