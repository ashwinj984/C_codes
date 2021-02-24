class Solution {
    public class Pair{
        int idx;
        int occu;
        Pair(int idx, int occu){
            this.idx = idx;
            this.occu = occu;
        }
    }
    public int firstUniqChar(String s) {
        HashMap<Character, Pair> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                Pair rem = map.get(s.charAt(i));
                rem.occu++;
                map.put(s.charAt(i), rem);
            }else{
                Pair rem = new Pair(i, 1);
                map.put(s.charAt(i), rem);
            }
        }
        
        int ansidx = Integer.MAX_VALUE;
        for(var ele : map.keySet()){
            Pair rem = map.get(ele);
            
            if(rem.occu == 1){
                if(rem.idx < ansidx){
                    ansidx = rem.idx;
                }
            }
        }
        if(ansidx == Integer.MAX_VALUE){
            return -1;
        }
        return ansidx;
    }
}
