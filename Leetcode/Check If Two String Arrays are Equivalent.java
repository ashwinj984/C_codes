class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < word1.length; i++){
            str.append(word1[i]);
        }
        
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < word2.length;i++){
            s.append(word2[i]);
        }
        
        String s1 = str.toString();
        String s2 = s.toString();
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
}
