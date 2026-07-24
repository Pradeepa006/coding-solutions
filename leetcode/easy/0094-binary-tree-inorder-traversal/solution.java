/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> li = new ArrayList<>();
        inorder(root , li);
        return li;
    }
    private static void inorder(TreeNode root , ArrayList<Integer> li) {
        if(root == null){
            return;
        }
        inorder(root.left , li);
        li.add(root.val);
        inorder(root.right , li);
    }
}