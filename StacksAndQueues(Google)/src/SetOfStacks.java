import java.util.ArrayList;


public class SetOfStacks {

	private int capacityOfEach;
	private ArrayList<Stack> stacks;
	
	
	public SetOfStacks(int capacityOfEach) {
		this.capacityOfEach = capacityOfEach;
		stacks = new ArrayList<Stack>();
	}
	
	public void push(int value) throws Exception {
		if (stacks.isEmpty() || stacks.get(stacks.size() - 1).isFull()) {
			Stack stack = new Stack(capacityOfEach);
			stack.push(value);
			stacks.add(stack);
		} else {
			stacks.get(stacks.size() - 1).push(value);
		}
	}
	
	public int pop() throws Exception {
		if (!stacks.isEmpty()) {
			int value = stacks.get(stacks.size() - 1).pop();
			if (stacks.get(stacks.size() - 1).isEmpty()) {
				stacks.remove(stacks.size() - 1);
			}
			return value;
		} else {
			throw new Exception("Stacks are empty.");
		}
	}
	
	public int peek() throws Exception {
		if (!stacks.isEmpty()) {
			return stacks.get(stacks.size() - 1).peek();
		} else {
			throw new Exception("Stacks are empty.");
		}
	}
	
}
