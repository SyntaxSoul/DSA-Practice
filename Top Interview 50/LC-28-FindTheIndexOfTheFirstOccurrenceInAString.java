class Solution {
    public int strStr(String haystack, String needle) {
        int len=needle.length();
        int hslen=haystack.length();
        if(len>hslen){
            return -1;
        }
        for(int i=0;i<hslen;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(i+len<=hslen && haystack.substring(i,i+len).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}