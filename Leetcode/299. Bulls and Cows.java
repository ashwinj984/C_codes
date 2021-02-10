//Easy Approach

class Solution {
    public String getHint(String secret, String guess) {
        int[] secretNumber = new int[10];
        int[] guessNumber = new int[10];
        
        int bullsCount = 0;
        int cowsCount = 0;
        for(int i = 0; i < secret.length(); i++){
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            
            if(ch1 == ch2){
                bullsCount++;
            }else{
                secretNumber[secret.charAt(i) - '0']++;
                guessNumber[guess.charAt(i) - '0']++;
            }
        }
        
        for(int i = 0; i < 10; i++){
            cowsCount += Math.min(secretNumber[i], guessNumber[i]);
        }
        return bullsCount + "A" + cowsCount + "B";
    }
}

// Using HashMap
class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        
        int bullsCount = 0;
        int cowsCount = 0;
        for(int i = 0; i < secret.length(); i++){
            int ch = Integer.valueOf(secret.charAt(i));
            int ch1 = Integer.valueOf(guess.charAt(i));
            
            if(ch == ch1){
                bullsCount++;
            }else{
                map.put(ch,map.getOrDefault(ch,0) + 1);
                map1.put(ch1,map1.getOrDefault(ch1, 0) + 1);
            }
        }
        
        for(var x  : map.keySet()){
            for(var y : map1.keySet()){
                if(x == y){
                    cowsCount += Math.min(map.get(x),map1.get(y));
                }
            }
        }
        return bullsCount + "A" + cowsCount + "B";
    }
}
