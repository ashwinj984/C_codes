class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int start = timeInMinutes(startTime);
        int end = timeInMinutes(finishTime);
        if(end < start){
            end += 24 * 60;
        }
        if(start % 15 != 0){
            start += 15 - (start % 15);
        }
        if(end % 15 != 0){
            end -= end  % 15;
        }
        if(end < start){
            return 0;
        }else{
            return (end - start)/15;
        }
    }
    
    public int  timeInMinutes(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3));
        return h*60+m;
    }
}
