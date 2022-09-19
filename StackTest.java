package practice;

import java.util.*;

public class StackTest {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		Queue<Integer> dateCount = new LinkedList<>();
		
		for(int i=0; i<progresses.length; i++) {
			int count = (100 - progresses[i]) % speeds[i] > 0 ? (100 - progresses[i]) / speeds[i] + 1 : (100 - progresses[i]) / speeds[i];
			dateCount.offer(count);
		}
		int count = dateCount.peek();
		boolean chk = false;
		while(!dateCount.isEmpty()) {
			if(!chk) {
				System.out.println("!!!!");
				chk = true;
				
			}
			
		}
		

		System.out.println(count);
	}

}
