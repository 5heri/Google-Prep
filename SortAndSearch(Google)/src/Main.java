import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
