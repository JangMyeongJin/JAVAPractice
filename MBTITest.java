package practice;

import java.util.*;

public class MBTITest {
	public static void main(String[] args) {
		HashMap<String, Integer> hash = new HashMap<>();
		String[] typeList = {"TR", "CF", "JM", "AN"};
		String answer = "";
		
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 4, 2, 7, 5};
		
		for(int i=0; i<survey.length; i++){
            String[] type = survey[i].split("");
            int num = choices[i];
            
            int type0Num = (num < 4) ? 4-num : 0;
            int type1Num = (num > 4) ? num-4 : 0;
            
            if(hash.containsKey(type[0]) && hash.containsKey(type[1])) {
            	hash.put(type[0], type0Num + hash.get(type[0]));
                hash.put(type[1], type1Num + hash.get(type[1]));
            }else {
            	hash.put(type[0], type0Num);
                hash.put(type[1], type1Num);
            }
        }
		
		for(int i=0; i<typeList.length; i++) {
			String[] type = typeList[i].split("");
			
			int type0Num = (hash.get(type[0]) != null) ? hash.get(type[0]) : 0;
			int type1Num = (hash.get(type[1]) != null) ? hash.get(type[1]) : 0;
			
			answer += (type1Num > type0Num) ? type[1] : type[0];
			
		}
		System.out.println(answer);
	}

}
