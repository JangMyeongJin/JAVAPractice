package practice;

import java.util.*;

public class SameNumberTest {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i : arr) {
			list.add(i);
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == list.get(i+1)) {
				list.remove(i);
			}
		}
		System.out.println(list);

	}

}
