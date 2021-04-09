// BackTrack Approach
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        helper(result, new ArrayList<>(), s, 0);
        
        return result;
    }
    
    public void helper(List<List<String>> result, ArrayList<String> list, String s, int index){
        if(index == s.length()){
            result.add(new ArrayList(list));
            return;
        }
        
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                list.add(s.substring(index, i + 1));
                helper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}
