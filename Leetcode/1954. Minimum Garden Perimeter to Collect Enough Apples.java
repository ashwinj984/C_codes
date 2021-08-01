class Solution {
    public long minimumPerimeter(long neededApples) {
      long i = 0;
      long sum = 0;
        while(sum < neededApples){
            sum += 12 * i * i;
            i++;
        }
        return (i - 1) * 8;
    }
}
