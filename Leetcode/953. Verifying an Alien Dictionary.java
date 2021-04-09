1//1st approach
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character, Integer> map = new HashMap<>();
        int weight = 1;
        
        for(var val : order.toCharArray()){
            map.put(val, weight);
            weight++;
        }
        
        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i + 1];
            if(!helper(s1, s2, map)){
                return false;
            }
        }
        return true;
        
    }
    
    public boolean helper(String s1, String s2, Map<Character, Integer> map){
        
        int it1 = 0;
        int it2 = 0;
        
        while(it1 < s1.length() && it2 < s2.length()){
            if(s1.charAt(it1) != s2.charAt(it2)){
                if(map.get(s1.charAt(it1)) < map.get(s2.charAt(it2))){
                    return true;
                }else{
                    return false;
                }
            }
            
            it1++;
            it2++;
        }
        
        if(s1.length() > s2.length()){
            return false;
        }
        
        return true;
    }
}

// 2nd Approach
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for(int i = 0; i < order.length(); i++){
            map[order.charAt(i) - 'a'] = i;
        }
        
        
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                if(j >= words[i + 1].length()){
                    return false;
                }
                if(words[i].charAt(j) != words[i + 1].charAt(j)){
                    int one = words[i].charAt(j) - 'a';
                    int two = words[i + 1].charAt(j) - 'a';

                    if(map[one] > map[two]){
                        return false;
                    }else{
                        break;
                    }    
                }
            }
        }
        
        return true;
    }
}
