class Solution {
    public List<String> letterCasePermutation(String s) {
        if(s.length() == 0){
            return new ArrayList<String>();
        }
        char[] ch = s.toCharArray();
        List<String> list = new ArrayList<>();
        
        solution(ch, list, 0);
        
        return list;
    }
    
    public void solution(char[] ch, List<String> list, int index){
        if(index == ch.length){
            
            list.add(new String(ch));
            return;
        }
        
        if(ch[index] >= '0' && ch[index] <= '9'){
            solution(ch, list, index + 1);
        }else{
            
            ch[index] = Character.toUpperCase(ch[index]);
            solution(ch, list, index + 1);
            
            ch[index] = Character.toLowerCase(ch[index]);
            solution(ch, list, index + 1);
        }
    }
}
