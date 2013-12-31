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
		
		Node n3 = new Node(3);
		Node n6 = new Node(6);
		
		System.out.println("Common ancestor of ("+ n3 + ") and (" + n6 + "): " 
				+ comAns(newRoot, n3, n6));
		
		//System.out.println(isBST(newRoot));
		
		/*
		NodeWithParent node1 = new NodeWithParent(15, null);
		NodeWithParent node2 = new NodeWithParent(7, node1);
		NodeWithParent node3 = new NodeWithParent(3, node2);
		NodeWithParent node4 = new NodeWithParent(13, node2);
		NodeWithParent node5 = new NodeWithParent(2, node3);
		NodeWithParent node6 = new NodeWithParent(4, node3);
		NodeWithParent node7 = new NodeWithParent(10, node4);
		NodeWithParent node8 = new NodeWithParent(14, node4);
		NodeWithParent node9 = new NodeWithParent(1, node5);
		NodeWithParent node10 = new NodeWithParent(8, node7);
		NodeWithParent node11 = new NodeWithParent(9, node10);
		
		node1.setLeft(node2);
		node2.setLeft(node3);
		node2.setRight(node4);
		node3.setLeft(node5);
		node3.setRight(node6);
		node4.setLeft(node7);
		node4.setRight(node8);
		node5.setLeft(node9);
		node7.setLeft(node10);
		node10.setRight(node11);
		
		System.out.println("Succ: " + nextNode(node2).getValue());
		System.out.println("Succ: " + nextNode(node9).getValue());
		System.out.println("Succ: " + nextNode(node8).getValue());
		System.out.println("Succ: " + nextNode(node4).getValue());
		*/
		
		newRoot.getLeft().getLeft().setLeft(new Node(-4));
		newRoot.getRight().getRight().setRight(new Node(-13));
		newRoot.getRight().getRight().setLeft(new Node(1));
		newRoot.getRight().getRight().getLeft().setLeft(new Node(-14));
		newRoot.getRight().getLeft().setRight(new Node(-2));
		newRoot.getRight().getLeft().getRight().setLeft(new Node(-3));
		newRoot.getRight().getLeft().getRight().getLeft().setLeft(new Node(9));
		
		lists = createLists(newRoot);
		displayLists(lists);
		
		findPaths(newRoot, 4);
		System.out.println();
		System.out.println("*************************");
		
		int[] testNotSorted = {5, 4, 2, 7, 1, 6, 12, 2, 13};
		int[] testSorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node notSorted = balancedBT(testNotSorted);
		Node sorted = balancedBT(testSorted);
		System.out.println("Not Sorted: " + isBalanced(notSorted));
		System.out.println("Sorted: " + isBalanced(sorted));
		
		
		Node nt1 = new Node(8);
		Node nt2 = new Node(3);
		Node nt3 = new Node(12);
		Node nt4 = new Node(2);
		Node nt5 = new Node(6);
		Node nt6 = new Node(10);
		Node nt7 = new Node(15);
		Node nt8 = new Node(4);

		nt1.setLeft(nt2);
		nt1.setRight(nt3);
		nt2.setLeft(nt4);
		nt2.setRight(nt5);
		nt3.setLeft(nt6);
		nt3.setRight(nt7);
		nt5.setLeft(nt8);
		
		displayLists(createLists(nt1));
		
		System.out.println(findCeil(nt1, 13));
		System.out.println(findCeil(nt1, 4));
		System.out.println(findCeil(nt1, 8));
		
		System.out.println("END");
	}
	
	/****************************************************/
	
	private static int findCeil(Node node, int key) {
		return findCeil(node, key, Integer.MIN_VALUE);
	}
	
	private static int findCeil(Node node, int key, int currentCeil) {
		if (node == null) {
			return currentCeil;
		} else {
			if (key >= node.getValue()) {
				return findCeil(node.getRight(), key, currentCeil);
			} else {
				return findCeil(node.getLeft(), key, node.getValue());
			}
		}
	}
	
	private static Node balancedBT(int[] array) {
		return balancedBT(array, 0, array.length - 1);
	}
	
	private static Node balancedBT(int[] array, int min, int max) {
		if (max < min) {
			return null;
		}
		
		int mid = (min + max)/2;
		Node node = new Node(array[mid]);
		node.setLeft(balancedBT(array, min, mid - 1));
		node.setRight(balancedBT(array, mid + 1, max));
		
		return node; 
	}
	/****************************************************/

	
	private static void findPaths(Node node, int sum) {
		if (node == null) {
			return;
		}
		ArrayList<Node> path = new ArrayList<Node>();
		findPaths(node, sum, 0, path);
		findPaths(node.getLeft(), sum);
		findPaths(node.getRight(), sum);
	}
	
	private static void findPaths(Node node, int sum, int currentSum, ArrayList<Node> path) {
		if (node == null) {
			return;
		}
		currentSum += node.getValue();
		path.add(node);
		if (sum == currentSum) {
			System.out.print("Path to sum(" + sum + "): ");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < path.size() - 1; i++) {
				sb.append(path.get(i).getValue());
				sb.append("->");
			}
			System.out.print(sb);
			System.out.print(path.get(path.size() - 1));
			System.out.println();
			
		} 
		ArrayList<Node> pathLeft = new ArrayList<Node>(path);
		ArrayList<Node> pathRight = new ArrayList<Node>(path);

		findPaths(node.getLeft(), sum, currentSum, pathLeft);
		findPaths(node.getRight(), sum, currentSum, pathRight);
	}
	
	private static Node comAns(Node node, Node p, Node q) {
		if (p.equals(q)) {
			return p;
		}
		if ((node.equals(p) && contains(node, q)) || (node.equals(q) && contains(node, p))) {
			return node;
		}
		if (contains(node.getLeft(), p) && contains(node.getRight(), q)
				|| contains(node.getLeft(), q) && contains(node.getRight(), p)) {
			return node;
		}
		if (contains(node.getLeft(), p) && contains(node.getLeft(), q)) {
			return comAns(node.getLeft(), p, q);
		}
		if (contains(node.getRight(), p) && contains(node.getRight(), q)) {
			return comAns(node.getRight(), p, q);
		}
		return null;
	}
	
	private static boolean contains(Node node, Node elem) {
		if (node == null) {
			return false;
		}
		if (node.equals(elem)) {
			return true;
		} else {
			return false || contains(node.getLeft(), elem) || contains(node.getRight(), elem);
		}
	}
	 
	private static NodeWithParent nextNode(NodeWithParent node) {
		if (node == null) {
			return null;
		} 
		if (node.getRight() != null) {
			return findLeftMost(node.getRight());
		}
		NodeWithParent parent = node.getParent();
		while (parent != null && parent.getRight() == node) {
			node = parent;
			parent = parent.getParent();
		}
		return node.getParent();
	}
	
	private static NodeWithParent findLeftMost(NodeWithParent node) {
		if (node == null) {
			return null;
		}
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
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
