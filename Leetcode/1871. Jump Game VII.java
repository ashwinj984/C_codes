// TLE
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.length() == 0 || s.charAt(s.length() - 1) == 0){
            return false;
        }
        
        boolean[] check = new boolean[s.length()];
        check[0] = true;
        Queue<Integer> q  = new ArrayDeque<>();
        q.add(0);
        while(!q.isEmpty()){
            int j = q.remove();
            for(int i = j + minJump ; i <= Math.min((j + maxJump), s.length() - 1) && i < s.length(); i++){
                if(s.charAt(i) == '0' && check[i] == false){
                    check[i] = true;
                    q.add(i);
                }
            }
        }
                return check[s.length() - 1];
    }
}
// Accepted
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] check = new boolean[n];
        check[0] = true;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '0'){
                for(int j = i - minJump; j >= 0 && j >= i - maxJump; j--){
                    if(check[j]){
                        check[i] = true;
                        break;
                    }
                }
            }
        }
        return check[n - 1];
    }
}
