
public class StackSort {
	
	public void sort(Stack stack) throws Exception {
		Stack helperStack = new Stack();
		
		while (!stack.isEmpty()) {
			if (helperStack.isEmpty() || helperStack.peek() >= stack.peek()) {
				helperStack.push(stack.pop());
			} else {
				int topValue = stack.pop();
				while (!helperStack.isEmpty()) {
					stack.push(helperStack.pop());
				}
				helperStack.push(topValue);
			}
		}
		
		while (!helperStack.isEmpty()) {
			stack.push(helperStack.pop());
		}
	}

}
