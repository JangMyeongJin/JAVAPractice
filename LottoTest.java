package practice;


public class LottoTest {

	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int win_count = 0;
		int zero_count = 0;
		
		for(int num : lottos) {
			if(chkNum(num, win_nums)) {
				win_count++;
			}
			if(num == 0) {
				zero_count++;
			}
		}
		System.out.println(win_count + "    " + zero_count);
		int high = rankChk(win_count + zero_count);
		int row = rankChk(win_count);
		
		System.out.println(high + "    " + row);
	}
	public static boolean chkNum(int num, int[] numList) {
		boolean chk = false;
		for(int nums : numList) {
			if(num == nums) {
				chk = true;
			}
		}
		return chk;
	}
	public static int rankChk(int count) {
		int rank = 0;
		if(count==0 || count==1) {
			rank = 6;
		}else if(count==2) {
			rank = 5;
		}else if(count==3) {
			rank = 4;
		}else if(count==4) {
			rank = 3;
		}else if(count==5) {
			rank = 2;
		}else if(count==6) {
			rank = 1;
		}else {
			
		}
		return rank;
	}

}
