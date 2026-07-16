class Solution {
    public static int gcd(int a , int b) {
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] m = new int[n];
        m[0] = nums[0];
        for(int i = 1 ; i < n ; i++) {
            m[i] = Math.max(m[i - 1] , nums[i]);
        }
        int[] prefixGcd = new int[n];
        for(int  i = 0 ; i < n ; i++) {
            prefixGcd[i] = gcd(m[i] , nums[i]);
        }
        Arrays.sort(prefixGcd);
        int s = 0;
        int e = n - 1;
        long sum = 0 ;
        while(s < e) {
            sum += gcd(prefixGcd[s] , prefixGcd[e]);
            s++;
            e--;
        }
        return sum;
    }
}