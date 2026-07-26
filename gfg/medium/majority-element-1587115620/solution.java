class Solution {
    int majorityElement(int arr[]) {
        // code here
        int count = 0 ;
        int el = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            if(count == 0 ){
                el = arr[i];
            }
            if(arr[i] == el){
                count++;
            }
            else {
                count--;
            }
        }
        
        count = 0;
        
        for(int i : arr) {
            if(i == el)
                count++;
        }
        if(count > arr.length / 2){
            return el;
        }
        return -1;
    }
}