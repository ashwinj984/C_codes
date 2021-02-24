class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int longestPalindrome = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                longestPalindrome += 2;
            } else set.add(c);
        }

        return set.size() > 0 ? longestPalindrome + 1 : longestPalindrome;
    }
}
