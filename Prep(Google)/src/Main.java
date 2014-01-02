import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int[] array = { 1, 5, 7, 8, 19, 21 };
		//int indexRec = BSrecursive(array, 7);
		//int indexIte = BSiterative(array, 7);
		//System.out.println(indexRec);
		//System.out.println(indexIte);

		//int n = findKthMax(
		//		Arrays.asList(new Integer[] { 21, 5, 23, 7, 19, 24 }), 2);
		//System.out.println(n);
		int[] arrayX = { 21, 5, 23, 7, 19, 24 };
		//int index = findNthLargest(arrayX, 2);
		//System.out.println(arrayX[index]);
		//System.out.println(findNthLargestSorting(arrayX, 2));
		
		char[] stringX = "abcd".toCharArray();
		char[] stringY = "abcde".toCharArray();
		//reverse(stringX, 0, stringX.length - 1);
		//reverse(stringY, 0, stringY.length - 1);
		//System.out.println(stringX);
		//System.out.println(stringY);
		
		char[] arrayC = {'a','b','c',' ', 'd', 'e', 'f', 'g'};
		char[] arrayD = {'a','b','c',' ', 'd', 'e', 'f', 'g', ' ', 'h', 'i', 'j', 'k', 'l'};
		//reverseWords(arrayC);
		//System.out.println(arrayC);
		//reverseWords(arrayD);
		//System.out.println(arrayD);
		
		System.out.println("/*******************");
		int[] arrayInt = {1,2,2,2,2};
		deleteDuplicate(arrayInt);
		
	}
	
	private static void deleteDuplicate(int[] inputArray) {
		boolean[] present_set = new boolean[256];
		List<Integer> listOfInt = new ArrayList<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			if (!present_set[inputArray[i]]) {
				listOfInt.add(inputArray[i]);
				present_set[inputArray[i]] = true;
			}
		}
		for (Integer n : listOfInt) {
			System.out.print(n + " ");
		}
	}
	
	private static void reverseWords(char[] string) {
		
		int currentStart = 0;
		int currentEnd = -1;
		
		for (int i = 0; i < string.length; i++) {
			if (string[i] != ' ') {
				currentEnd++;
			} else {
				//System.out.println(string[currentStart] + " | " + string[currentEnd]);
				reverse(string, currentStart, currentEnd);
				currentEnd++;
				currentStart = currentEnd;
				currentStart++;
			}
		}
		//System.out.println(string[currentStart] + " | " + string[currentEnd]);
		reverse(string, currentStart, currentEnd);
	}
	
	private static void reverse(char[] string, int start, int end) {
		int mid = start + ((end - start) / 2);
		for (int i = start; i <= mid; i++) {
			char tmp = string[end];
			string[end] = string[i];
			string[i] = tmp;
			end--;
		}
	}
	
	private static int findNthLargestSorting(int[] inputArray, int n) {
		//removing duplicates
		Set<Integer> int_set = new HashSet<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			int_set.add(inputArray[i]);
		}
		List<Integer> list = new ArrayList<Integer>(int_set);
		Collections.sort(list);
		return list.get(list.size() - n);
	}
	
	private static int findNthSmallest(int[] inputArray, int n) {
		return find(inputArray, 0, inputArray.length - 1, n);
	}
	
	private static int findNthLargest(int[] inputArray, int n) {
		return find(inputArray, 0, inputArray.length - 1, inputArray.length - n + 1);
	}
	
	private static int find(int[] inputArray, int left, int right, int n) {
		if (left == right)
			return inputArray[left];
		int pivotIndex = RandomizedPartition(inputArray, left, right);
		int k = pivotIndex - left + 1;
		if (n == k) {
			return pivotIndex; // Pivot is the required value
		} else if (n < k)
			return find(inputArray, left, pivotIndex - 1, n);
		else
			return find(inputArray, pivotIndex + 1, right, n - k);
	}

	private static int RandomizedPartition(int[] inputArray, int left, int right) {
		int randomIndex = left + (int) (Math.random() * ((right - left) + 1));
		// Exchange rightmost element with randomIndex element
		swap(inputArray, right, randomIndex);
		return partition(inputArray, left, right);
	}

	// Selects a Pivot
	private static int partition(int[] inputArray, int left, int right) {
		int x = inputArray[right]; // Store the rightmost value
		int i = left - 1;
		// Swap all values in inputArray such that lesser are on left and bigger
		// are on right
		for (int j = left; j <= right - 1; j++) {
			if (inputArray[j] <= x) {
				i++;
				swap(inputArray, i, j);
			}
		}
		swap(inputArray, i + 1, right);
		return i + 1;
	}

	private static void swap(int[] inputArray, int index1, int index2) {
		int temp = inputArray[index1];
		inputArray[index1] = inputArray[index2];
		inputArray[index2] = temp;
	}

	// Crashes when MAX element is not at the last index
	private static int findKthMax(List<Integer> input, int k) {
		if (input != null && input.size() > 0 && k <= input.size()) {
			int element = input.get(0);
			List<Integer> largerThanElement = new ArrayList<Integer>();
			List<Integer> smallerThanElement = new ArrayList<Integer>();

			for (int i = 1; i < input.size(); i++) {
				if (element < input.get(i)) {
					largerThanElement.add(input.get(i));
				} else {
					smallerThanElement.add(input.get(i));
				}
			}

			if (largerThanElement.size() == k - 1) {
				return element;
			} else if (largerThanElement.size() < k - 1) {
				return findKthMax(largerThanElement,
						k - largerThanElement.size() - 1);
			} else /* if (largerThanElement.size() >= k) */{
				return findKthMax(largerThanElement, k);
			}
			// return element;
		} else {
			throw new IllegalArgumentException("Not Cool");
		}
	}

	private static int BSrecursive(int[] array, int value) {
		return BSrecursive(array, value, 0, array.length - 1);
	}

	private static int BSrecursive(int[] array, int value, int start, int end) {
		if (end < start) {
			return -1;
		} else {
			// prevent Integer overflow.
			int mid = start + ((end - start) / 2);
			if (value < array[mid]) {
				return BSrecursive(array, value, start, mid - 1);
			} else if (value > array[mid]) {
				return BSrecursive(array, value, mid + 1, end);
			} else {
				return mid;
			}
		}
	}

	private static int BSiterative(int[] array, int value) {
		return BSiterative(array, value, 0, array.length);
	}

	private static int BSiterative(int[] array, int value, int start, int end) {
		while (end >= start) {
			int mid = start + ((end - start) / 2);
			if (array[mid] == value) {
				return mid;
			} else if (value < array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
