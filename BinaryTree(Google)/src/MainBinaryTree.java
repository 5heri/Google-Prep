
public class MainBinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(4);
		bt.insert(6);
		bt.insert(3);
		bt.insert(5);
		bt.insert(2);
		bt.insert(1);
		bt.insert(7);
		
		bt.inOrderDisplay();
		System.out.println();
		Node root = bt.getRoot();
		System.out.println(getHeight(root));
		System.out.println(isBalanced(root));

	}
	
	private static boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		} else {
			int heightDiff = Math.abs(getHeight(node.getLeft()) - getHeight(node.getRight()));
			if (heightDiff > 1) {
				return false;
			} else {
				return isBalanced(node.getLeft()) && isBalanced(node.getRight());
			}
		}
	}
	
	private static int getHeight(Node node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
		}
	}
	
	

}
