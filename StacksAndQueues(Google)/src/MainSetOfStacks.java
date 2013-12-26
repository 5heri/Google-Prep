
public class MainSetOfStacks {

	public static void main(String[] args) throws Exception {
		
		SetOfStacks ss = new SetOfStacks(3);
		
		ss.push(1);
		ss.push(2);
		ss.push(3);
		
		ss.push(10);
		ss.push(20);
		ss.push(30);
		
		ss.push(100);
		ss.push(200);
		ss.push(300);
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());

	}

}
