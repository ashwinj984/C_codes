class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String str = "";
            if(i%3 == 0){
                str+="Fizz";
            }
            if(i%5 == 0){
                str+="Buzz";
            }
            if(str == ""){
                String s = Integer.toString(i);
                ans.add(s);
            }
            else{
                ans.add(str);
            }
        }
        return ans;
    }
}
