class Solution {
    public void swap(int[] arr , int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void sort012(int[] arr) {
        // code here
        int n = arr.length ;
        int left = 0 ;
        int right = n - 1;
        int mid = 0 ;
        while(mid <= right) {
            if(arr[mid] == 0){
                swap(arr , mid , left);
                left++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr , mid , right);
                right--;
            }
        }
    }
}