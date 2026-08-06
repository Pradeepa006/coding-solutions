class Solution {
    private static boolean isTrue(int n , int t) {
        int p = 1;
        while( n > 0) {
            p *= (n % 10);
            n = n / 10;
        }
        if(p % t == 0)
            return true;
        return false;
    }
    public int smallestNumber(int n, int t) {
        for(int i = 0 ; i < 10 ; i++) {
            if(isTrue(n , t))
                return n ;
            else 
                n++;
        }
        return -1;
    }
}