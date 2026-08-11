class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(res , new ArrayList<>() , nums , 0);
        return res;
    }
    private static void backtrack(List<List<Integer>> res , List<Integer> li , int[] nums , int start ) {
        res.add(new ArrayList<>(li));
        int n = nums.length;
        for(int i = start ; i < n ; i++) {
            li.add(nums[i]);
            backtrack(res , li , nums , i + 1);
            li.remove(li.size() - 1);
        }
        
    }
}