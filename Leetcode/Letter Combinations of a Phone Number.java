class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == ""){
            ArrayList<String> res = new ArrayList<String>();
           // res.add("");
            return res;
        }
        if(digits.length() == 0){
            ArrayList<String> res = new ArrayList<String>();
            res.add("");
            return res;
        }
        
        char ch = digits.charAt(0);
        String ros = digits.substring(1);
        List<String> rr = letterCombinations(ros);
        ArrayList<String> res = new ArrayList<String>();
        String seq = getChoice(ch);
        for(String k : rr){
            for(int i = 0; i < seq.length(); i++){
                String m = seq.charAt(i) + k;
                res.add(m);
            }
        }
        return res;
        
        
    }
    public static String getChoice(char key) {
		if (key == '1') {
			return "";
		}
		if (key == '2') {
			return "abc";
		}
		if (key == '3') {
			return "def";
		}
		if (key == '4') {
			return "ghi";
		}
		if (key == '5') {
			return "jkl";
		}
		if (key == '6') {
			return "mno";
		}
		if (key == '7') {
			return "pqrs";
		}
		if (key == '8') {
			return "tuv";
		}
		if (key == '9') {
			return "wxyz";
		}
		if (key == '0') {
			return " ";
		}
		return "";
	}
    
}

// For more info refer to : https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
