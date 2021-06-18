class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set =  new HashSet<>();
        for(String s : deadends){
            set.add(s);
        }
        String s  = "0000";
        if(target.equals(s)){
            return 0;
        }
        if(set.contains("0000")){
            return -1;
        }
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> q  = new LinkedList<>();
        q.add(s);
        int count = 1;
        while(q.isEmpty() == false){
            int size = q.size();
            for(int j = 0; j < size; j++){
                 String curr = q.poll();
                 
                
                for(int i = 0; i < 4; i++){
                    char[] down = curr.toCharArray();
                    char[] up = curr.toCharArray();
                    
                    down[i] = (char)((down[i] -'0' + 1) % 10 + '0');
                    up[i] = (char)((up[i] -'0' + 9) % 10 + '0');
                    
                    String s1 = new String(down);
                    String s2 = new String(up);
                    if(s1.equals(target) || s2.equals(target)){
                        return count;
                    }
                    if(!set.contains(s1) && visited.contains(s1) == false){
                        q.add(s1);
                    }
                    visited.add(s1);
                    if(!set.contains(s2) && visited.contains(s2) == false){
                        q.add(s2);
                    }
                    visited.add(s2);
                    
                } 
            }
            count++;
        }
        return -1;
    }
}
