package practice;

import java.util.*;


public class ReportTest {
	static HashMap<String,Integer> hash = new HashMap<String,Integer>();
	static HashMap<String,String> hashid = new HashMap<String,String>();
	static ArrayList<Integer> resultList = new ArrayList<>();
	static int limits = 2;

	public static void main(String[] args) {
		String[] id = {"con", "ryan"};
		String[] list = {"ryan con", "ryan con", "ryan con", "ryan con"};
		
		for(String word : list) {
			String[] wordList = word.split(" ");
			String chk = hashid.get(wordList[0]);
			if(chk != null && chk.indexOf(wordList[0]) > -1) {
				
			}else {
				if(hash.containsKey(wordList[1])) {
					hash.put(wordList[1], hash.get(wordList[1]) +1);
				}else {
					hash.put(wordList[1], 1);
				}
			}
					
				
				if(hashid.containsKey(wordList[0])) {
					if(hashid.get(wordList[0]).contains(wordList[1])) {
						
					}else {
						hashid.put(wordList[0], hashid.get(wordList[0]) + "," + wordList[1]);
					}
					
				}else {
					hashid.put(wordList[0], wordList[1]);
				}
			
		}
		
		System.out.println(hash);
		for(String word : id) {
			if(hashid.containsKey(word)) {
				String reportID = hashid.get(word);
				if(reportID.contains(",")) {
					String[] reportIDList = reportID.split(",");
					reportCount(reportIDList);
				}else {
					reportCount(reportID);
				}
			}else {
				resultList.add(0);
			}
			
		}

		System.out.println(resultList);
	}
	public static void reportCount(String reportID) {
		int count = hash.get(reportID);
		if(count>=limits) {
			resultList.add(1);
		}else {
			resultList.add(0);
		}
	}
	public static void reportCount(String[] reportIDList) {
		int reportCount=0;
		for(String reportIDCount: reportIDList) {
			int count = hash.get(reportIDCount);
			if(count>=limits) {
				reportCount++;
			}
			
		}
		System.out.println(reportCount);
		resultList.add(reportCount);
	}

}
