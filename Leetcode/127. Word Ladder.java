class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while(queue.size() > 0){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                String currentword = queue.poll();
                if(currentword.equals(endWord)){
                    return level;
                }
                
                List<String> neighbor = neighbor(currentword);
                for(String neigh : neighbor){
                    if(set.contains(neigh)){
                        set.remove(neigh);
                        queue.add(neigh);
                    }  
                }
            }
        }
        return 0;
    }
    
    public List<String> neighbor(String s){
        char[] ch = s.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < ch.length; i++){
            char temp = ch[i];
            for(char ch1 = 'a'; ch1 <= 'z' ; ch1++){
                ch[i] = ch1;
                String neighbor = new String(ch);
                result.add(neighbor);
            }
            ch[i] = temp;
        }
        return result;
    }
}
