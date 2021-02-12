class Solution {
    public String fractionToDecimal(int num, int den) {
        if(num == 0){
            return "0";
        }
         StringBuilder ans = new StringBuilder();
        if((num < 0 && den < 0)|| (num > 0 && den > 0)){
            
        }else{
            ans.append("-");
        }
        long q = num / den;
        long r = num % den;
        q = Math.abs(q);
        ans.append(q);
        r = Math.abs(r);
        if (r == 0)
            return ans.toString();
        else {
            ans.append(".");
            HashMap < Long, Integer > map = new HashMap < > ();
            num = Math.abs(num);
            den = Math.abs(den);
            while (r != 0) {
                if (map.containsKey(r)) {
                    int pos = map.get(r);
                    ans.insert(pos, "(");
                    ans.append(")");
                    break;
                } else {
                    map.put(r,ans.length());
                    r *= 10;
                    q = r / den;
                    r = r % den;
                    ans.append(Math.abs(q));
                }
            }
        }
        return ans.toString();
    }
}
