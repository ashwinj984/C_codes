class Solution {
    public int nextGreaterElement(int n) {
        int k = n;
        String b = Integer.toString(k);
        ArrayList<String> some = permute(b);
        ArrayList<Integer> res = new ArrayList<>();
        for(String str : some){
            res.add(Integer.parseInt(str));
        }
        Collections.sort(res);
        int dummy = 0;
        for(int i = 0; i < res.size(); i++){
            if(n == res.get(i)){
                dummy = i; 
            }
        }
        if(res.get(res.size() - 1) == n){
            return -1;
        }
        try{
           return res.get(dummy + 1);
       }catch(Exception e){
           return -1;
       }
    }
    public static ArrayList<String> permute(String s){
        if(s.length() < 0){
            return new ArrayList<>();
        }
        if(s.length() == 1){
            ArrayList<String> res = new ArrayList<>();
            res.add(s);
            return res;
        }
        
        char ch = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String> s1 = permute(ros);
        ArrayList<String> res = new ArrayList<>();
        for(String str : s1){
            for(int i = 0; i <= str.length(); i++){
                String currans = str.substring(0,i) + ch + str.substring(i);
                res.add(currans);
            }
        }
        return res;
    }
}
//Time Limit Exceeded


class Solution {
    public int nextGreaterElement(int n) {
        char[] ch = ("" + n).toCharArray();
        int index = ch.length - 2;
        while(index >= 0 && ch[index] >= ch[index + 1])
            index--;
   
        if(index == -1)
            return -1;
        
        int index2 = ch.length - 1;
        while(index2 >= index && ch[index2] <= ch[index])
            index2--;
        
        swap(ch, index, index2);
        reverse(ch, index + 1);
        // Handle all case when number cross Integer.MAX_VALUE // 1999999999
        try {
            return Integer.parseInt(new String(ch));
        } catch (Exception e) {
            return -1;
        }
    }
    
    private void reverse(char[] ch, int start) {
        int l = start, r = ch.length - 1;
        while(l < r) {
            swap(ch, l, r);
            l++;
            r--;
        }
    }
    
    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}

//Better Approach
