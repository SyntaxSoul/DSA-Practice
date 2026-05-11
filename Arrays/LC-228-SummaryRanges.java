
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

// Struggled a bit to handle the edge cases
// The code in which I tried to handle edge cases
// The below code misses edge cases

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<>();
        int start=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]>1){
                if(start==i){
                    list.add(""+nums[i]);
                }
                else{
                    list.add(nums[start]+"->"+nums[i]);
                }
                start=i+1;
                if(start==nums.length-1){
                    list.add(""+nums[start]);
                }
            }
        }
        if(start<=nums.length-1){
            list.add(nums[start]+"->"+nums[nums.length-1]);
        }
        return list;
    }
}
