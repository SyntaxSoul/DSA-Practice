
class Solution {
    public int thirdMax(int[] nums) {

        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (int num : nums) {

            // Skip duplicates
            if ((max1 != null && num == max1) ||
                (max2 != null && num == max2) ||
                (max3 != null && num == max3)) {
                continue;
            }

            // New maximum
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }

            // New second maximum
            else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            }

            // New third maximum
            else if (max3 == null || num > max3) {
                max3 = num;
            }
        }

        // If third distinct maximum doesn't exist
        return (max3 == null) ? max1 : max3;
    }
}

// Earlier I was not aware of using Wrapper classes, insted used int max1=0.
// Buautified this code with AI as it was a bit confusing initially
