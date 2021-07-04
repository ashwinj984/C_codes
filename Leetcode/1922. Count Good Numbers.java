// Not efficient by BigInteger
import java.math.BigInteger;
class Solution {
    public int countGoodNumbers(long n) {
        int m = 1000000007;
        // making n even, if odd set flag=1
		int flag=0;
        if(n%2==1){
            n--;
            flag=1;
        }
		// converting n to n/2, because (5*4) is calculated as one unit...
		// now simply do (20)^n 
        n=n/2;
        String mm  = String.valueOf(m); 
        BigInteger mod = new BigInteger(mm); //store modulus
        String num = String.valueOf(n);
        BigInteger x = new BigInteger(num); //store n
        BigInteger val = new BigInteger("20");
        BigInteger result = val.modPow(x, mod);// calculate result
        
        long ans = result.longValue();
		//if flag is 1, means we have converted odd n to even  n ,by making n--
		//so, (ans*5) is remaining
        if(flag==1)
            ans = (ans*5)%m;
        return (int)ans; // required ans
    }
}
// Efficient using recursion
class Solution {
    int mod = (int) (1e9 + 7);
    public int countGoodNumbers(long n) {
        return (int)(helper(5, (n + 1) / 2) * helper(4, (n / 2)) % mod);
    }
    
    public long helper(int x, long n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        
        if(n % 2 == 1){
            return (x * helper(x, (n - 1))) % mod;
        }
        
        
        long half = helper(x, n / 2);
        return (half * half % mod);
    }
}
