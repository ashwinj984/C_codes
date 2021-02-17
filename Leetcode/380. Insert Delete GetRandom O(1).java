class RandomizedSet {

    private Map<Integer, Integer> valueIdx;
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueIdx = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valueIdx.containsKey(val)){
            return false;
        }
        
        valueIdx.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer idx = valueIdx.get(val);
        if(idx == null){
            return false;
        }
        int lastValue = list.get(list.size() - 1);
        if(idx < list.size() - 1){
            valueIdx.put(lastValue, idx);
            list.set(idx, lastValue);
        }
        
        valueIdx.remove(val);
        list.remove(list.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(valueIdx.size());
        int val = list.get(idx);
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
