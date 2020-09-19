class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            int num = i;
            int next = i;
            
            while(num<=high && next < 10){
                if(num >= low){
                        res.add(num);                  
                }
                next++;
                num = num * 10 + next;
            }
        }
        Collections.sort(res);
        return res;
    }
}

There can be different approach but these beats 100% of java submission
