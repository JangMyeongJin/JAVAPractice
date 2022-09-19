package practice;

import java.util.*;

public class NumberTest {

	public static void main(String[] args) {

		int[] arr = {1,1,3,3,0,1,1};
		ArrayList<Integer> removeList = new ArrayList<>();
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				removeList.add(i);
			}
		}
		ArrayList<Integer> answer = new ArrayList<>();
		
		int cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(i != removeList.get(cnt)) {
				answer.add(arr[i]);
			}else {
				cnt++;
			}
		}
		System.out.println(answer);
		
	}

}
