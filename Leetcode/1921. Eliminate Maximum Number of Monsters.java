// More intuitive
// 19ms
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
      // time array
        double[] d = new double[n];
        for(int i = 0; i < dist.length; i++){
            d[i] = (dist[i] * 1.0) / speed[i];
        }
        Arrays.sort(d);
        int count = 0;
        int time = 0;
        for(double temp : d){
            if(temp > time){
                time++;
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}

// More efficient
// 18ms
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] d = new int[n];
        for(int i = 0; i < n; i++){
            d[i] = (int) Math.ceil(dist[i] * 1.0 / speed[i]);
        }
        Arrays.sort(d);
        int count = 0;
        int time = 0;
        for(int temp : d){
            if(temp > time){
                count++;
                time++;
            }else{
                break;
            }
        }
        return count;
    }
}
// using PriorityuQueue
// 65ms
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(dist[i] * 1.0/speed[i]);
        }
        
        int count = 0;
        int time = 0;
        while(pq.size() > 0 && pq.poll() > time){
            count++;
            time++;
        }
        return count;
    }
}
// another using priorityQueue
// 57ms
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add((int) Math.ceil(dist[i] * 1.0/speed[i]));
        }
        
        int count = 0;
        int time = 0;
        while(pq.size() > 0 && pq.poll() > time){
            count++;
            time++;
        }
        return count;
    }
}
