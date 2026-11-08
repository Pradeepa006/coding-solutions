class Solution {
    public int minMoves(int[] nums) {
        int max = -10;
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; i++) {
            if(max < nums[i]) 
                max = nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++) {
            int num = max - nums[i];
            sum += num;
        }
        return sum;
    }
}