class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleZeros = 0;
        int length = arr.length - 1;

        // Step 1: Count the zeros that will be duplicated within the bounds
        for (int i = 0; i <= length - possibleZeros; i++) {
            if (arr[i] == 0) {
                // Edge case: If the zero cannot be duplicated because it's at the boundary
                if (i == length - possibleZeros) {
                    arr[length] = 0; // Copy it without duplication
                    length -= 1;
                    break;
                }
                possibleZeros++;
            }
        }

        // Step 2: Start from the end of the original valid items and shift backward
        int last = length - possibleZeros;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleZeros] = 0;
                possibleZeros--;
                arr[i + possibleZeros] = 0;
            } else {
                arr[i + possibleZeros] = arr[i];
            }
        }
    }
}
