import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Main {

	public static void main(String[] args) {
		int[] a = {1, 2, 7, 11, 12, 19, 0, 0, 0, 0}; //6
		int[] b = {-1, 3, 5, 12}; //4
		
		mergeLists(a, b, 6);
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		String[] strings = { "abcd", "race", "bdac", "cera", "bana", "jana", "naab", "naaj", "erac" };
		pairAnagram(strings);
		
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + " ");
		}
		System.out.println();
		
		int[] c = {5,6,2,-1,7,5,6,2,9,4};
		mergeSort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		int[] d = {5,6,2,-1,7,5,6,2,9,4};
		quickSort(d);
		for (int i = 0; i < d.length; i++) {
			System.out.print(d[i] + " ");
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//queue.

	}
	
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {
			quickSort(array, left, index - 1);
		}
		if (index < right) {
			quickSort(array, index, right);
		}
	}
	
	private static int partition(int[] array, int left, int right) {
		int pivot = array[left + ((right - left) / 2)];
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	private static void swap(int[] array, int index1, int index2) {
		int tmp = array[index2];
		array[index2] = array[index1];
		array[index1] = tmp;
	}
	
	private static void mergeSort(int[] array) {
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length - 1);
	}
	
	private static void mergeSort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			// To prevent overflow
			int mid = low + ((high - low) / 2);
			mergeSort(array, helper, low, mid);
			mergeSort(array, helper, mid + 1, high);
			merge(array, helper, low, mid, high);
		}
	}
	
	private static void merge(int[] array, int[] helper, int low, int mid, int high) {
		
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;
		
		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
	
	private static void pairAnagram(String[] strings) {

		List<String> stringHolder = Arrays.asList(strings);
		HashMap<String, ArrayList<String>> anagramHolder = new HashMap<String, ArrayList<String>>();
		
		for (String s : stringHolder) {
			if (!anagramHolder.containsKey(s)) {
				anagramHolder.put(s, new ArrayList<String>());
			}
			for (String str : stringHolder) {
				if (isAnagram(s, str)) {
					anagramHolder.get(s).add(str);		
					stringHolder.set(stringHolder.indexOf(str), "");
				}
			}
		}
		
		Set<String> keys = anagramHolder.keySet();
		ArrayList<String> result = new ArrayList<String>();
		for (String key : keys) {
			if (key.equals("")) {
				continue;
			}
			ArrayList<String> anagrams = anagramHolder.get(key);
			result.addAll(anagrams);
		}
		
		for (int i = 0; i < strings.length; i++) {
			strings[i] = result.get(i);
		}
	}
	
	
	private static boolean isAnagram(String str1, String str2) {
		
		if (str1.length() != str2.length()) {
			return false;
		}
		
		int[] char_count = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			char_count[str1.charAt(i)]++;
			char_count[str2.charAt(i)]--;
		}
		
		for (int i = 0; i < char_count.length; i++) {
			if (char_count[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void mergeLists(int[] a, int[] b, int lengthA) {
		 int lastA = lengthA - 1;
		 int lastB = b.length - 1;
		 int mergeIndex = a.length - 1;
		 
		 while (lastA >= 0 && lastB >= 0) {
			 if (a[lastA] > b[lastB]) {
				 a[mergeIndex] = a[lastA];
				 lastA--;
			 } else {
				 a[mergeIndex] = b[lastB];
				 lastB--;
			 }
			 mergeIndex--;
		 }
		 
		 while (lastB >= 0) {
			 a[mergeIndex] = b[lastB];
			 mergeIndex--;
			 lastB--;
		 } 
	}

}
