class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            int curr = left[i - 1];
            left[i] = Math.max(curr , arr[i]);
        }
        
        right[n - 1] = arr[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--) {
            int curr = right[i + 1];
            right[i] = Math.max(curr, arr[i]);
        }
        
        int tot = 0 ;
        
        for(int i = 0 ; i < n ; i++) {
            tot += Math.min(left[i] , right[i]) - arr[i];
        }
        return tot;
    }
}
