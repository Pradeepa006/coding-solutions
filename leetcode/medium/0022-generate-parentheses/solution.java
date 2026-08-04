class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> li = new ArrayList<>();
        String s = "";
        backtrack(li , s , 0 , 0 , n);
        return li;
    }
    private static void backtrack(List<String> li , String s , int open , int close , int max){
        if(max == s.length() * 2) {
            li.add(s);
            return;
        }
        if(open < max ) 
            backtrack(li , "(" , open + 1 , close , max);
        if(close < max)
            backtrack(li , ")" , open , close + 1 , max);
    }
}