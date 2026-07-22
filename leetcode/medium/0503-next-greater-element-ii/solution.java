class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length ;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res , -1);
        //int index = 0 ;

        for(int i = 0 ; i < 2*n ; i++) {
            int idx = i % n;

            while (!st.isEmpty() && arr[idx] > arr[st.peek()]) {
                int top = st.pop();
                res[top] = arr[idx];
            }

            if (i < n) {
                st.push(idx);
            }

        }
        return res;
    }
}