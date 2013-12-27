
public class MainStackSort {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(5);
		s.push(2);
		s.push(12);
		s.push(5);
		s.push(3);
		s.push(9);
		
		StackSort stackSorter = new StackSort();
		
		stackSorter.sort(s);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		System.out.println("END");
	}

}
