package practice;
import java.util.*;

public class test {
	static int cnt = 0;
	static int zcnt = 0;

	public static void main(String[] args) {
		String a = "110010101001";
		int b = 0;
		
		int[] answer = new int[2];
		
		delZero(a);
		
		System.out.println(cnt+" , " +zcnt);
	}
	public static void delZero(String a) {
		String test = "";
		cnt ++;
		String[] list = a.split("");
		
		for(String b : list) {
			if(b.equals("1")) {
				test += "1";
			}else {
				zcnt ++;
			}
		}
		
		String num = (test.length() == 0) ? "1" : Integer.toBinaryString(test.length());
		
		//System.out.print(num);
		
		if(!num.equals("1")) {
			System.out.println("d");
			delZero(num);
		}
		
	}

}
