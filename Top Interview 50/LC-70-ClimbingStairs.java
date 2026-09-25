class Solution {
    public int climbStairs(int n) {

        int oneStep = 1;
        int twoStep = 1;

        for (int i = 2; i <= n; i++) {
            int current = oneStep + twoStep;

            oneStep = twoStep;
            twoStep = current;
        }

        return twoStep;
    }
}