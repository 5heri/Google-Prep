
public class MainMyQueue {

	public static void main(String[] args) throws Exception {
		
		MyQueue mq = new MyQueue();
		mq.enqueue(10);
		mq.enqueue(20);
		mq.enqueue(30);
		System.out.println(mq.dequeue());
		mq.enqueue(40);
		
		System.out.println("POP");
		
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		System.out.println(mq.dequeue());
		//System.out.println(mq.dequeue());
		
	}

}
