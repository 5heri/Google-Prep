import java.util.HashSet;
import java.util.Set;


public class Main {

	public static void main(String[] args) {
		
		String str = "abcdefgha";
		boolean bool = isUnique(str);
		System.out.println("Is the String(" + str + ") Unique: " + bool);
		
		String firstDuplicateRemoved = removeFirstDuplicate(str);
		System.out.println("Without first duplicate: " + firstDuplicateRemoved);
		String lastDuplicateRemoved = removeLastDuplicate(str);
		System.out.println("Without last duplicate: " + lastDuplicateRemoved);
		// Order is not preserved as a set is used.
		String allDuplicatesRemoved = removeAllDuplicates(str);
		System.out.println("Without all duplicates: " + allDuplicatesRemoved);
		
		System.out.println();
		
		String s1 = "abcdefg";
		String s2 = "gfedcab";
		boolean isPerm = isPerm(s1, s2);
		System.out.println("Is it a permutation: "+ isPerm);
		
		String x = "Mr John Smith    ";
		char[] y = x.toCharArray();
		
		String replacedSpaces = replaceWhiteSpaces(y, 13);
		System.out.println(replacedSpaces);
		
		System.out.println();
		
		compress("aabcccccaaa");
		
		

	}
	
	private static void compress(String str) {
		
		StringBuffer sb = new StringBuffer();
		char currentChar = str.charAt(0);
		int count = 1;
		
		for (int i = 1; i < str.length(); i++) {
			if (currentChar == str.charAt(i)) {
				count++;
			} else {
				sb.append(currentChar);
				sb.append(count);
				currentChar = str.charAt(i);
				count = 1;
			}
		}
		sb.append(currentChar);
		sb.append(count);
		
		//To check which string should be printed, just compare the lengths.
		System.out.println(sb);
		
	}
	
	private static String replaceWhiteSpaces(char[] str, int strLength) {
		int pointerX = strLength - 1;
		int pointerY = str.length - 1;
		
		while (pointerX >= 0) {
			if (str[pointerX] != ' ') {
				char tmp = str[pointerY];
				str[pointerY] = str[pointerX];
				str[pointerX] = tmp;
				pointerY--;
			} else {
				str[pointerY] = '0';
				pointerY--;
				str[pointerY] = '2';
				pointerY--;
				str[pointerY] = '%';
				pointerY--;
				
			}
			pointerX--;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		return sb.toString();	
	}
	
	
	private static boolean isPerm(String str1, String str2) {
		int[] ascii_set = new int[256];
		
		if (str1.length() != str2.length()) {
			return false;
		}
		
		for (int i = 0; i < str1.length(); i++) {
			ascii_set[str1.charAt(i)]++;
			ascii_set[str2.charAt(i)]--;
		}
		
		for (int i = 0; i < ascii_set.length; i++) {
			if (ascii_set[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	private static String removeAllDuplicates(String str) {
		Set<Character> withoutDup = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			withoutDup.add(str.charAt(i));
		}
		
		
		//String concatenation is O(n^2) therefore use string buffer.
		String out = "";
		for (Character c : withoutDup) {
			out += c;
		}
		
		return out;
	}
	
	private static String removeFirstDuplicate(String str) {
		StringBuffer sb = new StringBuffer(str);
		int[] ascii_chars = new int[256];
		for (int i = 0; i < sb.length(); i++) {
			if (ascii_chars[sb.charAt(i)] != 0) {
				sb.deleteCharAt(i);
			} else {
				ascii_chars[sb.charAt(i)]++;
			}
		}
		String out = sb.toString();
		return out;
	}
	
	private static String removeLastDuplicate(String str) {
		StringBuffer sb = new StringBuffer(str);
		int[] ascii_chars = new int[256];
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (ascii_chars[sb.charAt(i)] != 0) {
				sb.deleteCharAt(i);
			} else {
				ascii_chars[sb.charAt(i)]++;
			}
		}
		String out = sb.toString();
		return out;
	}
	
	private static boolean isUnique(String str) {
		
		int[] ascii_values = new int[256];
		for (int i = 0; i < str.length(); i++) {
			
			if (ascii_values[str.charAt(i)] != 0) {
				return false;
			}
			ascii_values[str.charAt(i)]++;
		}
		return true;
	}
}
