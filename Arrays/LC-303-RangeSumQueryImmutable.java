
// =======================
// Final Optimized Solution
// =======================
//
// Prefix sum is calculated once in the constructor
// and reused later for constant-time queries.

class NumArray {
    int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = prefix[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }

        return prefix[right] - prefix[left - 1];
    }
}



/*
========================================
Second Attempt (Prefix Sum Idea Found)
========================================

I was close to the prefix sum approach,
but missed the main concept:
"calculate once and reuse later."

Mistake:
- Prefix array was being rebuilt inside sumRange()
- That means every query recalculates prefix sum again

Problem:
- sumRange() was still taking O(n) time

Realization:
- Prefix sum should be calculated once
  in the constructor and stored at class level
*/

class NumArraySecondAttempt {
    int[] nums;

    public NumArraySecondAttempt(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int[] prefix = new int[nums.length];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        if (left == 0) {
            return prefix[right];
        }

        return prefix[right] - prefix[left - 1];
    }
}



/*
========================================
First Attempt (Brute Force Traversal)
========================================

At this point I did not know the Prefix Sum concept.

Approach:
- Traverse from left to right for every query
- Calculate range sum independently every time

Problem:
- Every query takes variable time O(n)
- Repeated calculations happen again and again

Observation:
- The problem expects optimized repeated queries
- That led to discovering Prefix Sum
*/

class NumArrayFirstAttempt {

    int[] nums;

    public NumArrayFirstAttempt(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }
}