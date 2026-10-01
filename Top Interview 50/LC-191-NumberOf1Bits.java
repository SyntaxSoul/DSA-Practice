//First code
class Solution {
    public int hammingWeight(int n) {
        String bs=Integer.toBinaryString(n);
        int count =0;
        for(int i=0;i<bs.length();i++){
            if(bs.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}

//Final optimal code
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}