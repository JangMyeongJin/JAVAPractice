package practice;

import java.util.*;

public class PhoneTest {

	public static void main(String[] args) {
		String[] phone_book = {"123","456","789"};
		ArrayList<String> phone_array = new ArrayList<String>();
		
		for(String phone : phone_book) {
			phone_array.add(phone);
		}
		
        boolean answer = true;
        
        for(int i=0; i<phone_array.size(); i++) {
        	String phone = phone_array.get(i);
        	phone_array.remove(phone);
        	answer = chekPhone(phone_array, phone, answer);
        	phone_array.add(phone);
        	if(!answer)  break ; 
        }
       
        System.out.println(answer);

	}
	public static boolean chekPhone(ArrayList<String> list, String phone, boolean answer) {
		
		for(String phone_list : list) {
			if(phone_list.indexOf(phone) > -1) {
				answer = false;
				break;
			}
		}
		return answer;
	}

}
