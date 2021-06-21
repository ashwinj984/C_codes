class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(j < chars.length){
            while(j < chars.length && chars[i] == chars[j]){
                j++;
            }
            int len = j-i;
            if(len == 1){
                sb.append(chars[i]);
            }else{
                sb.append(chars[i]);
                sb.append(j - i);
            }
             i = j;
             j++;
        }
        if(i<chars.length && j-i == 1){
            sb.append(chars[i]);
        }
       
        for(int k=0;k<sb.length();k++){
            chars[k] = sb.charAt(k);
        }
        return sb.length();
    }
}
