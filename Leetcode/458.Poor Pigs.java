class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
       
        int attempts = minutesToTest / minutesToDie;
        int states = attempts + 1;
        return (int)Math.ceil(Math.log(buckets) / Math.log(states));
        
    }
}

// Bhai first of all and develop your own logic for it because this question is really tough
