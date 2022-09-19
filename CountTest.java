package practice;

import java.util.*;

public class CountTest {
	static int hit = 8;
	
	static List<Integer> numList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
	
	static List<Integer> sumList = new ArrayList<Integer>();
	
	static List<List> resultList = new ArrayList<List>();

	public static void main(String[] args) {
		numCount(numList);
		
		
	}
	
	public static void numCount (List<Integer> inputList) {	
		
		for(int i : inputList) {
			if(inputList.contains(hit - i)) {
				hit = hit - i;
				System.out.println(hit + "    " + i);
				if(hit == 0) {
					resultList.add(sumList);
				}else {
					sumList.add(i);
					numList.remove(i);
					numCount(inputList);
				}
				
				
			}
			
		}
	}

}
