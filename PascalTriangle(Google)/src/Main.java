
public class Main {

	public static void main(String[] args) {
		
		printPascalRecursion1(5);
		
		System.out.println("********************************");
		
		printPascalRecursion2(5);
		
		//System.out.println(pascalNumber1(2,1));
		//System.out.println(pascalNumber2(2,1));

	}
	
	private static int pascalNumber2(int rows, int cols) {
		if (rows == 0 || cols == 0 || rows == cols) {
			return 1;
		}
		return pascalNumber2(rows - 1, cols - 1) + pascalNumber2(rows - 1, cols);
	}
	
	private static void printPascalRecursion2(int rows) {
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(pascalNumber2(i, j) + " ");
			}
			System.out.println();
		}
	}
	
	private static int pascalNumber1(int rows, int cols) {
		if (rows == 0 || cols == 0 || rows == cols + 1) {
			return 1;
		}
		return pascalNumber1(rows - 1, cols - 1) + pascalNumber1(rows - 1, cols);
	}
	
	private static void printPascalRecursion1(int maxRows)
	{
        for (int i = 1; i <= maxRows; i++)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print(pascalNumber1(i, j) + " ");
            }
            System.out.println();
        }
    }


}
