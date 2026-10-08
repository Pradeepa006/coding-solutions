class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res =  new StringBuilder();
        int open = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                if(open > 0)
                    res.append(ch);
                open++;
            }
            else {
                open--;
                if(open > 0)
                    res.append(ch);
            }
        }
        return res.toString();
    }
}