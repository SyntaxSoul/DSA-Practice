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