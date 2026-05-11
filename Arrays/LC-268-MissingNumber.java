class Solution {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int sum=(len*(len+1))/2;
        int total=0;
        for(int num:nums){
            total+=num;
        }
        return sum-total;
    }
}

// I remembered there's a formula to find sum of n numbers
// But unable to recall the formula, searched it on google and used it
// This problem can also be solved using XOR the currect approach is Math summention