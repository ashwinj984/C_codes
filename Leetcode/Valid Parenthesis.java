class Solution {
		public boolean isValid(String s) {
			Stack<Character> p = new Stack<>();
			char[] cArr = s.toCharArray();
			for (char c : cArr) {
				if (p.isEmpty() || !validPar(p.peek(), c)) {
					p.push(c);
				} else {
					p.pop();
				}
			}
			return p.isEmpty();
		}

		private static boolean validPar(char c, char currC) {
			if ((c == '(' && currC == ')')

					|| (c == '[' && currC == ']') || (c == '{' && currC == '}')) {
				return true;
			}
			return false;
		}
	}
