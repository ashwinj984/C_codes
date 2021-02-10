class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> map = new HashSet<>();
        
        for(int i = 0; i <= s.length() - 10; i++){
            String str = s.substring(i, i + 10);
            if(set.contains(str)){
                map.add(str);
            }else{
                set.add(str);
            }
        }
        
        List<String> ans = new ArrayList<String>();
        for(var val : map){
            ans.add(val);
        }
        return ans;
    }
}
