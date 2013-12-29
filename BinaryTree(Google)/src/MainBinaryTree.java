import java.util.ArrayList;
import java.util.LinkedList;


public class MainBinaryTree {

	public static void main(String[] args) {
		/*BinaryTree bt = new BinaryTree();
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
		System.out.println(isBalanced(root));*/
		
		int[] array = {2,2,3,4,5,6,7};
		Node newRoot = minBST(array);
		//System.out.println(isBalanced(newRoot));
		ArrayList<LinkedList<Node>> lists = createLists(newRoot);
		displayLists(lists);
		
		System.out.println(isBST(newRoot));
		
		System.out.println("END");

	}
	
	private static boolean isBST(Node node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		
		if (node.getValue() > min && node.getValue() <= max
				&& isBST(node.getLeft(), min, node.getValue())
				&& isBST(node.getRight(), node.getValue(), max)) {
			return true;
		}
		return false;
	}
	
	private static ArrayList<LinkedList<Node>> createLists(Node node) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		int numOfLists = getHeight(node) + 1;
		for (int i = 0; i < numOfLists; i++) {
			lists.add(new LinkedList<Node>());
		}
		fillLists(node, lists, 0);
		return lists;
	}
	
	private static void fillLists(Node node, ArrayList<LinkedList<Node>> lists, int depth) {
		if (node != null) {
			lists.get(depth).add(node);
			fillLists(node.getLeft(), lists, depth + 1);
			fillLists(node.getRight(), lists, depth + 1);
		} else {
			return;
		}
	}
	
	private static void displayLists(ArrayList<LinkedList<Node>> lists) {
		for (LinkedList<Node> list : lists) {
			StringBuffer sb = new StringBuffer();
			for (Node node : list) {
				sb.append(node.getValue());
				sb.append(" ");
			}
			System.out.println(sb);
			System.out.println("---------------");
		}
	}
	
	private static Node minBST(int[] array) {
		return minBST(array, 0, array.length - 1);
	}
	
	private static Node minBST(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node newNode = new Node(array[mid]);
		newNode.setLeft(minBST(array, start, mid - 1));
		newNode.setRight(minBST(array, mid + 1, end));
		return newNode;
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
