import java.util.*;

class Solution {
    public ArrayList<String> winner(String[] arr) {
        // code here
        HashMap<String , Integer> hs = new HashMap<>();
        for(int i = 0 ; i < arr.length ;i++) {
            String s = arr[i];
            hs.put(s , hs.getOrDefault(s,0)+1);
        }
        int max = -10;
        for(Integer value : hs.values()) {
            if(max < value) {
                max = value;
            }
        }
        String s = "" ;
        int c = 0;
        for (String key : hs.keySet()) {
            //System.out.println("Key: " + key);
            if((hs.get(key) == max && c == 0) || (hs.get(key) == max && c != 0 && key.compareTo(s) < 0)){
                s = key;
                c = 1;
            }
        }
        ArrayList<String> li = new ArrayList<>();
        li.add(s);
        li.add(Integer.toString(max));
        return li;
    }
}