import java.util.HashSet;
import java.util.Set;


public class Main {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(4);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		
		//Node root = n1;
		
		
		
		removeDup(n1);
		Node root = n1;
		
		while (root != null) {
			System.out.print(root.getValue() + " ");
			root = root.getNext();
		}
		

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
