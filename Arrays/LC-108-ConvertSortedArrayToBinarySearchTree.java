
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start=0;
        int end=nums.length-1;
        return BuildBST(nums,start,end);
    }

    public TreeNode BuildBST(int[] nums,int start,int end){
        
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode left= BuildBST(nums,start,mid-1);
        TreeNode right= BuildBST(nums,mid+1,end);
        TreeNode parent=new TreeNode(nums[mid],left,right);
        return parent;
    }
}

//Before fix
/*
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start=0;
        int end=nums.length-1;
        TreeNode root;
        return root = HBBST(nums,start,end);
    }

    public TreeNode HBBST(int[] nums,int start,int end){
        int mid=(start+end)/2;
        if(start>=end){
            return new TreeNode(nums[mid]);
        }
        TreeNode left= HBBST(nums,start,mid);
        TreeNode right= HBBST(nums,mid,end);
        TreeNode parent=new TreeNode(mid,left,right);
        return parent;
    }
}class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start=0;
        int end=nums.length-1;
        TreeNode root;
        return root = HBBST(nums,start,end);
    }

    public TreeNode HBBST(int[] nums,int start,int end){
        int mid=(start+end)/2;
        if(start>=end){
            return new TreeNode(nums[mid]);
        }
        TreeNode left= HBBST(nums,start,mid);
        TreeNode right= HBBST(nums,mid,end);
        TreeNode parent=new TreeNode(mid,left,right);
        return parent;
    }
}
*/