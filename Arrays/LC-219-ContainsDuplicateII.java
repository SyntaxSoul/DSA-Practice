class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) &&
            i - map.get(nums[i]) <= k) {
                return true;
                }
            map.put(nums[i], i);
        }
        return false;
    }
}

// I wrote the code like this and commented statement is the thing I forgot in the first step but solved when test cases didn't get cleared
// No ChatGPT

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k){
                    return true;
                }
                map.put(nums[i],i); // I missed to update after diff>key
            }
            else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
