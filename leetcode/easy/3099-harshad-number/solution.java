class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int num = x;
        while( x > 0) {
            int n = x % 10;
            x = x /  10;
            sum += n ;
        }
        if(num % sum == 0) {
            return sum ;
        }
        return -1;
    }
}