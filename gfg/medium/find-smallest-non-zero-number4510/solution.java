class Solution {
    public int find(int[] arr) {

        int start = 0;

        for(int i = arr.length - 1 ; i >= 0 ; i--){
            start = (start + arr[i] + 1) / 2;
        }
        return start;
    }
}