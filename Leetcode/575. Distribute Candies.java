class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int limit = candyType.length / 2;
        
        for (int t : candyType) {
            set.add(t);
            if (set.size() == limit) {
                return limit;
            }
        }
        
        return Math.min(limit, set.size());
    }
}
