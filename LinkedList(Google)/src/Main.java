import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Main {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(11);
		Node n3 = new Node(1);
		Node n4 = new Node(9);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(16);
		Node n8 = new Node(4);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		
		//Node root = n1;
		
		
		
		//removeDup(n1);
		Node root = n1;
		
		while (root != null) {
			System.out.print(root.getValue() + " ");
			root = root.getNext();
		}
		System.out.println();
		
		Node x = findKtoLast(n1, 2);
		System.out.println(x.getValue());
		
		/* deleteCurrent(n5);
		
		root = n1;
		while (root != null) {
			System.out.print(root.getValue() + " ");
			root = root.getNext();
		}
		System.out.println(); */
		
		root = partitionAround(n1, 5);
		while (root != null) {
			System.out.print(root.getValue() + " ");
			root = root.getNext();
		}
		System.out.println();
		
		Node test1 = new Node(7);
		Node test2 = new Node(1);
		Node test3 = new Node(6);
		test1.setNext(test2);
		test2.setNext(test3);
		
		
		Node test4 = new Node(5);
		Node test5 = new Node(9);
		Node test6 = new Node(2);
		test4.setNext(test5);
		test5.setNext(test6);
		
		Node added = addLists(test1, test4);
		while (added != null) {
			System.out.print(added.getValue() + " ");
			added = added.getNext();
		}
		System.out.println();
		
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(3);
		Node node5 = new Node(2);
		Node node6 = new Node(1);
		Node midNode = new Node(10);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(midNode);
		midNode.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		
		boolean isPalin = isPalindrome(node1);
		
		while (node1 != null) {
			System.out.print(node1.getValue() + " ");
			node1 = node1.getNext();
		}
		System.out.println();
		System.out.println(isPalin);
		
		
	}
	
	private static boolean isPalindrome(Node node) {
		if (node == null) {
			return true;
		}
		Node fast = node;
		Node slow = node;

		Stack<Node> stack = new Stack<Node>();
		
		while (fast != null && fast.getNext() != null) {
			stack.push(slow);
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		// In even fast = null
		// In odd fast.next = null
		if (fast != null) {
			slow = slow.getNext();
		}
		while (slow != null) {
			if (!slow.equals(stack.pop())) {
				return false;
			}
			slow = slow.getNext();
		}
		return true;
	}
	
	// All lists are in reverse order of the answers.
	private static Node addLists(Node node1, Node node2) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		while (node1 != null) {
			sb1.append(node1.getValue());
			node1 = node1.getNext();
		}
		
		while (node2 != null) {
			sb2.append(node2.getValue());
			node2 = node2.getNext();
		}
		sb1.reverse();
		sb2.reverse();
		
		int sum = Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString());
		
		sb1 = new StringBuffer();
		sb1.append(sum);
		Node head = null;
		for (int i = 0; i < sb1.length(); i++) {
			Node newNode = new Node(Character.getNumericValue(sb1.charAt(i)));
			if (head == null) {
				head = newNode;
			} else {
				newNode.setNext(head);
				head = newNode;
			}
		}
		return head;
	}
	
	//REMINDER: the first element in the 2nd list is not the pivot
	private static Node partitionAround(Node node, int x) {
		Node headFst = null;
		Node tailFst = null;
		Node headSnd = null;
		Node tailSnd = null;
		
		while (node != null) {
			
			Node next = node.getNext();
			node.setNext(null);
			if (node.getValue() < x) {
				if (headFst == null) {
					headFst = node;
					tailFst = headFst;
				} else {
					tailFst.setNext(node);
					tailFst = tailFst.getNext();
				}
			} else {
				if (headSnd == null) {
					headSnd = node;
					tailSnd = headSnd;
				} else {
					tailSnd.setNext(node);
					tailSnd = tailSnd.getNext();
				}
			}
			node = next;
		}
		tailFst.setNext(headSnd);
		return headFst;
	}
	
	// Will not work if last element is to be deleted.
	private static boolean deleteCurrent(Node node) {
		if (node == null || node.getNext() == null) {
			return false;
		}
		node.setValue(node.getNext().getValue());
		node.setNext(node.getNext().getNext());
		return true;
	}
	
	private static Node findKtoLast(Node node, int k) {
		Node fst = node;
		Node snd = node;
		
		if (node == null) {
			return null;
		}
		
		for (int i = 1; i <= k; i++) {
			fst = fst.getNext();
		}
		
		while (fst.getNext() != null) {
			fst = fst.getNext();
			snd = snd.getNext();
		}
		
		return snd;
		
	}
	
	private static void removeDup(Node node) {
		Set<Node> tracker = new HashSet<Node>();
		Node prev = null;
		
		while (node != null) {
			if (tracker.contains(node)) {
				prev.setNext(node.getNext());
			} else {
				tracker.add(node);
				prev = node;
			}
			node = node.getNext();
		}
	}

}
