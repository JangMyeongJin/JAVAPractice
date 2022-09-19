package practice;

import java.util.ArrayList;
import java.util.List;

public class PalindromeTest {
	static int resultCount = 0;

	public static void main(String[] args) {
		String input = "abdabbcaba";
		ArrayList<String> inputList = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			inputList.add(input.substring(i, i + 1));
		}
		ArrayList<String> resultList = new ArrayList<>();

		
		 if(countPalindrome(inputList)) {
			 resultList = inputList;
			 System.out.println(resultList + "  " + resultCount + "¹ø"); 
		 }else {
			 resultList = checkListRemove(inputList);
			 System.out.println(resultList + "  " + resultCount + "¹ø"); 
		 }
		 

	}

	public static boolean countPalindrome(ArrayList<String> list) {
		int count = 0;
		int sizeNum = 1;
		for (int i = 0; i < list.size(); i++) {
			String first = list.get(i);
			String last = list.get(list.size() - sizeNum);
			if (first.equals(last)) {
				count++;
			}
			sizeNum++;
		}
		if(list.size()/2 == count/2) {
			return true;
		}else {
			return false;
		}
	}

	public static ArrayList<String> checkListRemove(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String word = list.get(i);
			list.remove(i);
			if (countPalindrome(list)) {
				return list;
			} else {
				list.add(i, word);
			}
		}
		return list;
	}

}
