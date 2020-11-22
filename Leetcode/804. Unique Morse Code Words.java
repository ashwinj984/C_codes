class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
        "...-",".--","-..-","-.--","--.."};
        Set<String> st = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            char[] ch = words[i].toCharArray();
            StringBuilder sb = new StringBuilder("");
            for(int j = 0; j < ch.length;j++){
                sb.append(morse[ch[j] - 97]);
            }
            st.add(sb.toString());
        }
        return st.size();
    }
}
