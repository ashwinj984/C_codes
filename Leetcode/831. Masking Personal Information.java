// Ye Likha maine faaltu mai itna lamba code

class Solution {
    public String maskPII(String s) {
        if((s.charAt(0) >= 97 && s.charAt(0) <= 126) || (s.charAt(0) >= 65 && s.charAt(0) <= 90)) {
			String k  = "";
			int i = 1;
			while(i < s.length() && s.charAt(i) != '@') {
				i++;
			}
			if(s.charAt(0) >= 65 && s.charAt(0) <= 90) {
				k += (char) (s.charAt(0) + 32);
			}else {
				k += s.charAt(0);
			}
			 
			k += "*****";
			
			if(s.charAt(i - 1) >= 65 && s.charAt(i - 1) <= 90) {
				k += (char) (s.charAt(i - 1) + 32);
			}else {
				k += s.charAt(i - 1);
			}
			k += '@';
			//k += s.charAt(0) + "*****" + s.charAt(i - 1);
			String ros = s.substring(i + 1);
			int j = 0;
			while(j  < ros.length()) {
				String one = "";
				while(j != '.' && j < ros.length()) {
					one += ros.charAt(j);
					j++;
				}
				
				k += one.toLowerCase();
			}
			return k;
		}else {
//			if (s.length() >= 10 && s.length() <= 13) {
//				if (s.length() == 10) {
//					String k = "";
//					k += "***-***-" + s.substring(6);
//					System.out.println(k);
//				}
//			}
			ArrayList<Character> arr = new ArrayList<>();
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) >= 48 && s.charAt(i) <= 57) {
					arr.add(s.charAt(i));
				}
			}
			ArrayList<Character> a = new ArrayList<>();
			for(int  i = arr.size() - 1 ; i > arr.size() - 5; i--){
				a.add(arr.get(i));
			}
			Collections.reverse(a);
			//System.out.println(a);
			String m = "";
			for(int i = 0; i < a.size(); i++) {
				m += "" + a.get(i);
			}
			String k = "";
			if(arr.size() == 10) {
				
				k += "***-***-" + m;
			}else if(arr.size() == 11){
				k += "+*-***-***-" + m;
			}else if(arr.size() == 12){
				k += "+**-***-***-" + m;
			}else {
				k += "+***-***-***-" + m;
			}
		    return k;
		}
    }
}


// Good and precise code

class Solution {
    public String maskPII(String S) {
        if (S.contains("@")) {
            String[] tokens = S.split("@");
            return Character.toLowerCase(tokens[0].charAt(0)) + "*".repeat(5) + Character.toLowerCase(tokens[0].charAt(tokens[0].length() - 1)) + "@" + tokens[1].toLowerCase();
        }
        else {
            S = S.replaceAll("\\+|-|[()]| ", "");
            return ((S.length() > 10) ? "+" + "*".repeat(S.length() - 10) + "-" : "") + "*".repeat(3) + "-" + "*".repeat(3) + "-" + S.substring(S.length() - 4);
        }
    }
}
