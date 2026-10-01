class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length() % 2 != 0) {
            return false;
        }
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
                continue;
            }
            else {
            if(st.isEmpty()) {
                return false;
            }
            if ((ch == ')' && st.pop() != '(') || (ch == '}' && st.pop() != '{') || (ch == ']' && st.pop() != '[') ) {
                return false;
            }
            }
            

        
        }
        return st.isEmpty();
    }
}