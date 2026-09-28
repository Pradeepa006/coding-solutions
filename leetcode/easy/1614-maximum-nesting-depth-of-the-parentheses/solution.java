class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int curr = 0 ;
        int max = 0 ;
        for(char ch : s.toCharArray()) {
            if(ch == '('){
                curr++;
            }
            else if(ch == ')'){
                curr--;
            }
            max = Math.max(curr , max);
        }
        return max;
    }
}