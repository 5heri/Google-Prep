public class PascalIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pascalTriangleIt(5);

	}

	private static void pascalTriangleIt(int rows) {
		int r = 0;
		int value = 1;

		for (int i = 0; i < rows; i++) {
			r = i + 1; // this is the row
		//	value = 1; // we start from col=1
			for (int c = 0; c <= i; c++) {
				// special case, cannot divide by 0
				if (c > 0) {
					value = value * (r - c) / c;
				}
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

}
