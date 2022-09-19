package practice;

public class KeypadTest {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		int leftHand = 0;
		int rightHand = 0;
		String answer = "";
		
		for(int num : numbers) {
			if(num==1 || num==4 || num==7) {
				leftHand = num;
				answer += "L";
			}else if(num==3 || num==6 || num==9) {
				rightHand = num;
				answer += "R";
			}else if(num==2) {
				if(leftHand==1);
			}
		}

	}

}
