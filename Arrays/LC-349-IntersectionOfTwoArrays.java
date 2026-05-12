
// set can be traversed using for each loop

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num)){
                set2.add(num);
            }
        }
        int[] result=new int[set2.size()];
        int i=0;
        for(int num:set2){
            result[i++]=num;
        }
        return result;
    }
}

// Thought there're 2 ways to solve this problem 1. Brute force 2. Hashing
// Tried solving using Hashing(HashSet) but stuck at returning int[]
// Searched for set to int array conversion and found stream
// The code works fine

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums){
            if(set1.contains(num)){
                set2.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}