class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println(map);
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                if(map.get(t.charAt(i)) == 0){
                    map.remove(t.charAt(i));
                }
            }else{
                    return t.charAt(i);
            }
        }
        return 'a';
    }
}

// Better Code

class Solution {
    public char findTheDifference(String s, String t) {
            int s1 = 0;
            int s2 = 0;

            for (int i = 0; i < s.length(); i++) {
              s1 += (int) s.charAt(i);
            }

            for (int i = 0; i < t.length(); i++) {
              s2 += (int) t.charAt(i); 
            }

            int diff = s2 - s1;
            return (char)diff;
    }
}
