class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int cycle = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {

            for (int i = row; i < s.length(); i += cycle) {

                sb.append(s.charAt(i));

                int diagonal = i + cycle - 2 * row;

                if (row > 0 && row < numRows - 1
                        && diagonal < s.length()) {
                    sb.append(s.charAt(diagonal));
                }
            }
        }

        return sb.toString();
    }
}