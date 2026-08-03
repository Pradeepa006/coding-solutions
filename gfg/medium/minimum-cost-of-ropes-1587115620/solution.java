class Solution {
    public int minCost(int[] arr) {
        // code here
        // Arrays.sort(arr);
        // int cost = 0 ;
        // int rel = arr[0];
        // for(int i = 1 ; i < arr.length ; i++) {
        //     cost += (rel + arr[i]);
        //     rel = cost;
        // }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            pq.add(arr[i]);
        }
        
        int cost = 0 ;
        
        while(pq.size() > 1) {
            int f = pq.poll();
            int s = pq.poll();
            cost += (f + s);
            pq.add((f + s));
        }
        return cost;
    }
}