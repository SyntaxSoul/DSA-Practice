import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        // int sum = Integer.parseInt(a,2)+Integer.parseInt(b,2);
        // return Integer.toBinaryString(sum);

        BigInteger a1=new BigInteger(a,2);
        BigInteger b1=new BigInteger(b,2);
        BigInteger sum = a1.add(b1);
        return sum.toString(2);
    }
}