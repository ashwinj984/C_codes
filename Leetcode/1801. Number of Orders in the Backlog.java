class Solution {
    int mod = 1000000007;
    public int getNumberOfBacklogOrders(int[][] orders) {
        
        TreeMap<Integer, Integer> buy = new TreeMap<>(Collections.reverseOrder());
        
        TreeMap<Integer, Integer> sell = new TreeMap<>();
        
        for(int[] order : orders){
            
            if(order[2] == 0){
                
                boolean flag = true;
                
                while(flag){
                    
                    if(sell.isEmpty() == false && sell.firstKey() <= order[0]){
                        
                        int lowPrice = sell.firstKey();
                        
                        int lowAmount = sell.getOrDefault(lowPrice, 0);
                        
                        if(lowAmount == order[1]){
                            sell.remove(lowPrice);
                            flag = false;
                        }
                        
                        else if(lowAmount > order[1]){
                            sell.put(lowPrice, lowAmount - order[1]);
                            flag = false;
                        }
                        
                        else{
                            sell.remove(lowPrice);
                            order[1] = order[1] - lowAmount;
                        }
                    }
                    
                    else{
                        buy.put(order[0], buy.getOrDefault(order[0], 0) + order[1]);
                        flag = false;
                    }
                }
            }
            
            else{
                
                boolean flag = true;
                
                while(flag){
                    
                    if(buy.isEmpty() == false && buy.firstKey() >= order[0]){
                        
                        int highPrice = buy.firstKey();
                        
                        int highAmount = buy.getOrDefault(highPrice, 0);

                        if(highAmount == order[1]){
                            buy.remove(highPrice);
                            flag = false;
                        }

                        else if(highAmount > order[1]){
                            buy.put(highPrice, highAmount - order[1]);
                            flag = false;
                        }

                        else{
                            buy.remove(highPrice);
                            order[1] = order[1] - highAmount;
                        }
                    }

                    else{
                        sell.put(order[0], sell.getOrDefault(order[0], 0) + order[1]);
                        flag = false;
                    }
                }
            }
        }
        
        int ans = 0;
        for(int value : sell.values()){
            ans = (ans + value) % mod;
        }
        
        for(int value : buy.values()){
            ans = (ans + value) % mod;
        }
        
        return ans % mod;
    }
}
