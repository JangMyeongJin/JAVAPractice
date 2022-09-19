package practice;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int num1 = 0;
		int num2 = 1;
		int count = 1;
		
		while(count < input) {
			if(count % 2 == 0) {
				num2 = num1 + num2;
			}else {
				num1 = num1 + num2;
			}
			//System.out.println(num1 + "   " + num2);
			count++;
		}
		
		if(input % 2 ==0) {
			System.out.println(num1);
		}else {
			System.out.println(num2);
		}

	}

}
