import java.util.HashSet;
import java.util.Set;


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
		
		//deleteCurrent(n5);
		
		root = n1;
		while (root != null) {
			System.out.print(root.getValue() + " ");
			root = root.getNext();
		}
		System.out.println();
		
		root = partitionAround(n1, 5);
		while (root != null) {
			System.out.print(root.getValue() + " ");
			root = root.getNext();
		}
		System.out.println();
		
		

	}
	
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
