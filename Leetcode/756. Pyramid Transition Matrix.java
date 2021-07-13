class Solution {
    ]// backtracking problems
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // creating all possible conditions
        for(String s : allowed){
            String s1 = s.substring(0, 2);
            String s2 = s.substring(2);
            if(map.containsKey(s1)){
                map.get(s1).add(s2);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(s2);
                map.put(s1, list);
            }
        }
        //System.out.println(map);
        return find(bottom, allowed, map);
        //return false;
    }
    // trying all possible levels and if at some time we got single letter we got the ans or false....
    public boolean find(String s, List<String> arr,  HashMap<String, ArrayList<String>> map){
         if(s.length() == 1){
             return true;
         }
        // checking if the required substring is possible or not 
        // if not return false
        for(int i = 0; i < s.length() - 1; i++){
            String str = constructPair(i, s);
            if(map.containsKey(str) == false){
                return false;
            }
        }
        
        // creating all possible uplevels for this particular level
        List<String> allPossibleCombinations = new ArrayList<>();
        constructAllPossibilities(s, allPossibleCombinations, map, 0, new StringBuilder());
        
        // travelling on all possible levels
        for(String nextLevel : allPossibleCombinations){
            if(find(nextLevel, arr, map)){
                return true;
            }
        }
        return false;
    }
    
    // constructing all possible uplevels
    public void constructAllPossibilities(String s, List<String> list, HashMap<String, ArrayList<String>> map, int idx, StringBuilder sb){
        // base condition
        if(idx == s.length() - 1){
            list.add(sb.toString());
            return;
        }
        
        // first find for initial index and with the help of recursion find all possible strings
        String str = constructPair(idx, s);
        for(String res : map.get(str)){
            // append the possible value
            sb.append(res);
            constructAllPossibilities(s, list, map, idx + 1, sb);
            // remove here because next time for same string if anyother value is possible can be replaced so that we get al possible strings for a particular level
            sb.deleteCharAt(sb.length() - 1);
        }
    }   
    
    // constructing pairs which we have to check before processing that is it present in map or not
    // or if there is a possible value for it or not.....
    public String constructPair(int idx, String s){
        char ch1 = s.charAt(idx);
        char ch2 = s.charAt(idx + 1);
        String str = String.valueOf(ch1) + String.valueOf(ch2);
        return str;
    }
    
}
