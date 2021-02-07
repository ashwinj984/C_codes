
//https://leetcode.com/contest/weekly-contest-227/problems/largest-merge-of-two-strings/
import java.util.*;

public class LargestMergeOfTwoStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String word1 = scn.next();
		String word2 = scn.next();

//		findAns(word1, word2, "", 0, 0);
//		Collections.sort(merges);
//		System.out.println(merges.get(merges.size() - 1));
		
		
		// This approach is the best I was able to think
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = 0;
		
		while(i < word1.length() && j < word2.length()) {
			if((word1.charAt(i) > word2.charAt(j) || word1.charAt(i) == word2.charAt(j)) && word1.substring(i).compareTo(word2.substring(j)) > 0) {
				sb.append(word1.charAt(i++));
			}else {
				sb.append(word2.charAt(j++));
			}
		}
		
		while(i < word1.length()){
			sb.append(word1.charAt(i++));
		}
		
		while(j < word2.length()){
			sb.append(word2.charAt(j++));
		}
		
		System.out.println(sb.toString());
		
		

	}
//	This approach is very inefficient 
//  It will take a hell lot of time to solve an easy problem.
	static ArrayList<String> merges = new ArrayList<>();

	public static void findAns(String word1, String word2, String asf, int idx1, int idx2) {
		if (word1.length() == idx1 && word2.length() == idx2) {
			merges.add(asf);
			return;
		}

		if (idx1 < word1.length()) {
			findAns(word1, word2, asf + word1.charAt(idx1), idx1 + 1, idx2);
		}
		if (idx2 < word2.length()) {
			findAns(word1, word2, asf + word2.charAt(idx2), idx1, idx2 + 1);
		}
	}

}
