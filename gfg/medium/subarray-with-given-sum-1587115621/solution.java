
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int n = arr.length;
        ArrayList<Integer> idx = new ArrayList<>();
        
        int start = 0 ;
        int sum = 0;
        
        for(int end = 0 ; end < n ; end++) {
            sum += arr[end];
            
            while(sum > target) {
                sum -= arr[start];
                start++;
            }
            
            if(sum == target) {
                idx.add(start + 1);
                idx.add(end + 1);
                return idx;
            }
        }
        
        idx.add(-1);
        return idx;
    }
}
