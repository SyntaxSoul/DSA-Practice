
class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                int temp=nums[i];
                nums[i++]=nums[j];
                nums[j]=temp;
            }
        }
    }
}

// I wrote the below solution first which works fine
// But there's a overincluded condition i.e first if() inside for()
// Which is not necessory as the i won't move if the number is "0" bcoz it moves only when the number is non-zero
// But j moves ahead as loop continues

class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]!=0 && nums[j]==0){ // Not necessory
                i=j;
            }
            if(nums[j]!=0){
                int temp=nums[i];
                nums[i++]=nums[j];
                nums[j]=temp;
            }
        }
    }
}