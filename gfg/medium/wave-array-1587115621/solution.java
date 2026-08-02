class Solution {
    
    private static void  swap (int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sortInWave(int arr[]) {
        // code here
        Arrays.sort(arr);
        
        for(int i = 0 ; i < arr.length - 1 ; i+=2) {
            swap(arr , i , i + 1);
        }
    }
}
