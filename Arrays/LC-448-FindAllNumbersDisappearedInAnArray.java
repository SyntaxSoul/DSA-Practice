class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len=nums.length;
        List<Integer> res=new ArrayList<>();
        int i=0;
        while(i<len){
            if(i+1==nums[i] || nums[i]==nums[nums[i]-1]){
                i++;
                continue;
            }
            int temp=nums[nums[i]-1];
            nums[nums[i]-1]=nums[i];
            nums[i]=temp;
        }
        for(i=0;i<len;i++){
            if(i+1!=nums[i]){
                res.add(i+1);
            }
        }
        return res;
    }
}

// First Attempt

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len=nums.length;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<len;i++){
            int temp=nums[nums[i]-1];
            nums[nums[i]-1]=nums[i];
            nums[i]=temp;
        }
        for(int i=0;i<len;i++){
            if(i!=nums[i]-1){
                res.add(i+1);
            }
        }
        return res;
    }
}