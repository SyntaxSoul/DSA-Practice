class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<>();
        int len=nums.length;
        if(len==0){
            return list;
        }
        int start=nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]!=nums[i]+1){
                if(start==nums[i]){
                    list.add(""+nums[i]);
                }
                else{
                    list.add(start+"->"+nums[i]);
                }
                start=nums[i+1];
            }
        }
        if(start==nums[nums.length-1]){
            list.add(""+start);
            // Can replace "" with String.valueOf()
        }
        else{
            list.add(start+"->"+nums[nums.length-1]);
        }
        return list;
    }
}