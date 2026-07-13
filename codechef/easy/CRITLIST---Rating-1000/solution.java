// Node is defined as:
// class Node{
//     int val;
//     Node next;
//     Node(int x){
//     	val = x; next = null;
//     }
// }
class Solution{
    static int solve(Node root){
        if(root == null || root.next == null || root.next.next == null ) 
            return 0;
        Node prev = root;
        Node curr = root.next;
        Node temp = root.next.next;
        int count = 0 ;
        while(temp != null){
            if((prev.val > curr.val && temp.val > curr.val) || (prev.val < curr.val && temp.val < curr.val))
                count++;
            prev = prev.next ;
            curr = curr.next ;
            temp = temp.next;
        }
        return count;
    }
}