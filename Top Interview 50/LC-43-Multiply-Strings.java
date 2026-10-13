class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        // Multiply each digit
        for (int i = m - 1; i >= 0; i--) {

            int digit1 = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {

                int digit2 = num2.charAt(j) - '0';

                result[i + j + 1] += digit1 * digit2;
            }
        }

        // Handle carry
        for (int i = result.length - 1; i > 0; i--) {

            result[i - 1] += result[i] / 10;
            result[i] %= 10;
        }

        // Convert array to String
        StringBuilder sb = new StringBuilder();

        int i = 0;

        // Remove leading zero
        if (result[0] == 0) {
            i = 1;
        }

        while (i < result.length) {
            sb.append(result[i]);
            i++;
        }

        return sb.toString();
    }
}