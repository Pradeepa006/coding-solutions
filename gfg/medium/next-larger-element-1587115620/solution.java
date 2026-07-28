class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> li = new ArrayList<>();
        int n = arr.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        st.push(arr[n - 1]);
        for(int i = n - 2 ; i >= 0 ; i--){
            while(!(st.isEmpty()) && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) {
                res[i] = -1;
            }
            else 
                res[i] = st.peek();
            
            st.push(arr[i]);
            
        }
        for(int i = 0 ; i < n ; i++) {
            li.add(res[i]);
        }
        return li;
    }
}