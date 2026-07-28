class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;
        char[] half = s.substring(0, halfLen).toCharArray();
        java.util.Arrays.sort(half);
        String left = new String(half);
        String right = new StringBuilder(left).reverse().toString();      
        if (n % 2 != 0) {
            return left + s.charAt(halfLen) + right;
        }

        return left + right;
    }
}