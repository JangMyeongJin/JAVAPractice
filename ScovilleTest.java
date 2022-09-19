package practice;

import java.util.Arrays;

public class ScovilleTest {
	static int sumCount = 0;
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		countScoville(scoville, K);
        System.out.println(sumCount);

	}
	public static void countScoville(int[] list, int K) {
		sumCount++;
		Arrays.sort(list);
		int[] listEmpt = new int[list.length-1];
		for(int i=0; i<list.length; i++) {
			int count = list[i] + list[i+1] * 2;
			if(count>K) {
				break;
			}else {
				list[i+1] = count;
				System.arraycopy(list, 1, listEmpt, 0, listEmpt.length);
				countScoville(listEmpt, K);
				
			}
		}
	}

}
