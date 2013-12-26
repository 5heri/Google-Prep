
public class MainStackMin {

	public static void main(String[] args) throws Exception {
		StackWithMin sm = new StackWithMin();
		sm.push(5);
		sm.displayMins();
		System.out.println("current min: " + sm.checkCurrentMin());
		sm.push(6);
		sm.displayMins();
		System.out.println("current min: " + sm.checkCurrentMin());
		sm.push(3);
		sm.displayMins();
		System.out.println("current min: " + sm.checkCurrentMin());
		sm.push(7);
		sm.displayMins();
		System.out.println("current min: " + sm.checkCurrentMin());
		
		System.out.println("POP");
			
		sm.pop();
		System.out.println("current min: " + sm.checkCurrentMin());
		sm.pop();
		System.out.println("current min: " + sm.checkCurrentMin());
		sm.pop();
		System.out.println("current min: " + sm.checkCurrentMin());
		sm.pop();
		//System.out.println("current min: " + sm.checkCurrentMin());
	}
}
