class Solution {
    public int minJumps(int[] arr) {
        // code here
        if(arr[0] < 1)
            return -1;
        int n = arr.length;
        if(n == 1)
            return 0;
        int jumps = 0 ;
        int dest = n -1 ;
        int coverage = 0 ;
        int lastjumpidx = 0;
        
        for(int i = 0 ; i < n ; i++) {
            coverage = Math.max(coverage , arr[i] + i);
            if(lastjumpidx == i){
                jumps++;
                lastjumpidx = coverage ;
                if(coverage >= dest){
                    return jumps;
                }
            }
        }
        return -1;
        
    }
}