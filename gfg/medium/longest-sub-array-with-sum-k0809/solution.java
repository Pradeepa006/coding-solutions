class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int prefix_sum = 0 ;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            prefix_sum += arr[i];
            if(prefix_sum == k )
                res = i + 1;
            if(map.containsKey(prefix_sum - k)){
                res = Math.max(res , i - map.get(prefix_sum - k));
            }
            if(!(map.containsKey(prefix_sum))){
                map.put(prefix_sum , i);
            }
        }
        return res;
    }
}
