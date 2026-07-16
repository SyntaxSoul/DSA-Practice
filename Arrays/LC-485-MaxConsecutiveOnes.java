// First Attempt

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int current=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                max=Math.max(current,max);
                current=0;
            }
            else{
                current++;
            }
            
        }
        return Math.max(current,max);
    }
}

