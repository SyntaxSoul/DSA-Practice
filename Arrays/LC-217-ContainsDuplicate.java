class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

// Before this code I coded using HashMap but realised used key-value pair is wasting of memory
// Get to know set with this problem
// Unique key-value => HashMap
// Unique value = > HashSet