package practice;

import java.util.*;

public class QueueTest {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		ArrayList<Queue> queueList = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int answer = 0;
		
		for(int i=0; i<board.length; i++) {
			Queue<Integer> queue = new LinkedList<>();
			for(int j=0; j<board.length; j++) {
				if(board[j][i] != 0) queue.add(board[j][i]);
			}
			queueList.add(queue);
		}
		
		for(int i=0; i<moves.length; i++) {
			int cnt = moves[i] - 1;
			Queue<Integer> queue = queueList.get(cnt);
			if(queue.peek() != null) {
				 int num = queue.poll();
				 
				 if(stack.size() == 0) {
					 stack.add(num);
				 }else if(stack.peek() == num) {
					 answer += 2;
					 stack.pop();
				 }else {
					 stack.add(num);
				 }
			}
			 
			 
			
		}
		

	}

}
