package practice;

public class BinaryTest {

	public static void main(String[] args) {

		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		String[] answer= new String[arr1.length];
		
		for(int i=0; i<arr1.length; i++) {
			int num1 = Integer.parseInt(Integer.toBinaryString(arr1[i]));
			int num2 = Integer.parseInt(Integer.toBinaryString(arr2[i]));
			
			String sum = Integer.toString(num1+num2).length() < arr1.length ? " " + Integer.toString(num1+num2) : Integer.toString(num1+num2);
			String emp = "";
			for(int j=0; j<sum.length(); j++) {
				//if(sum.length() < arr1.length && emp.length() == 0) emp+=" ";
				if(sum.substring(j, j+1).equals("1") || sum.substring(j, j+1).equals("2")) {
					emp += "#";
				}else {
					emp += " ";
				}
			}
			answer[i] = emp;
			System.out.println("emp  : " + emp);
		}
		
		
		
		
	}

}
