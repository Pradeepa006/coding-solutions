class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) {
            pq.add(nums[i]);
        }

        ArrayList<Integer> li = new ArrayList<>();
        int s = pq.poll();
        while(!(pq.isEmpty())){
            int t = pq.poll();
            if(s + 1 == t){
                s = t;
            }
            else{
                li.add(s + 1);
                s = s + 1;
                pq.add(t);
            }
        }

        return li;
    }
}