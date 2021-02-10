class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }
        
        int find = 0;
        int haveTofind = t.length();
        int i = -1;
        int j = -1;
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;    
            
            while(i < s.length() - 1 && find < haveTofind){
                i++;
                char ch = s.charAt(i);
                map2.put(ch,map2.getOrDefault(ch, 0) + 1);
                if(map2.get(ch) <= map.getOrDefault(ch, 0)){
                    find++;
                }
                f1 = true;
            }
            
            while(j < i && find == haveTofind){
                String pans = s.substring(j + 1, i + 1);
                if(ans.length() == 0 || pans.length() < ans.length()){
                    ans = pans;
                }
                
                j++;
                char ch = s.charAt(j);
                if(map2.get(ch) == 1){
                    map2.remove(ch);
                } else{
                    map2.put(ch, map2.get(ch) - 1);
                }
                
                if(map2.getOrDefault(ch, 0) < map.getOrDefault(ch, 0)){
                    find--;
                }
                f2 = true;
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }
}
