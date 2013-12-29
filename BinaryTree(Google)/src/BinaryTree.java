
public class BinaryTree {
	
	private Node root;
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public BinaryTree() {
		this.root = null;
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
	
	public void preOrderDisplay() {
		preOrderDisplay(root);
	}
	
	public void inOrderDisplay() {
		inOrderDisplay(root);
	}
	
	public void postOrderDisplay() {
		postOrderDisplay(root);
	}
	
	private void preOrderDisplay(Node node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			preOrderDisplay(node.getLeft());
			preOrderDisplay(node.getRight());
		}
	}
	
	private void inOrderDisplay(Node node) {
		if (node != null) {
			inOrderDisplay(node.getLeft());
			System.out.print(node.getValue() + " ");
			inOrderDisplay(node.getRight());
		}
	}
	
	private void postOrderDisplay(Node node) {
		if (node != null) {
			postOrderDisplay(node.getLeft());
			postOrderDisplay(node.getRight());
			System.out.print(node.getValue() + " ");
		}
	}
}
