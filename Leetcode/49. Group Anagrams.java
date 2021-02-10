class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }else{
                List<String> list = map.get(key);
                list.add(str);
                map.put(key,list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(var x : map.values()){
            ans.add(x);
        }
        return ans;
    }
}
