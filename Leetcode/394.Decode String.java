//Best Approach

class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                count.push(num);
                stack.push(cur);
                num = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = stack.pop();
                int counts = count.pop();
                while (counts-- > 0) {
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}

//My approach

class Solution {
    public static String decodeString(String s) {
    	StringBuilder currStr = new StringBuilder("");
    	Stack<StringBuilder> stackString = new Stack<>();
    	Stack<Integer> numStack = new Stack<>();
    	int i = 0;
        while(i < s.length()) {
        	if(Character.isDigit(s.charAt(i))){
        		StringBuilder num = new StringBuilder();
        		num.append(s.charAt(i));
        		while(Character.isDigit(s.charAt(++i))) {
        			num.append(s.charAt(i));
        		}
        		int currNum = Integer.parseInt(num.toString());
        		stackString.push(currStr);
        		numStack.push(currNum);
        		currStr = new StringBuilder("");
        	}
        	else if (s.charAt(i) == ']'){
        		StringBuilder currStrOld = stackString.pop();
        		int numRepeat = numStack.pop();
        		for(int j =0; j < numRepeat; j++) {
        			currStrOld.append(currStr);
        		}
        		currStr = currStrOld;
        	}
        	else {
        		currStr.append(s.charAt(i));
        	}
        	i++;
        }
        return currStr.toString();
    }
}
