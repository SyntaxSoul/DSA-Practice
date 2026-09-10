class Solution {
    public boolean isSubsequence(String s, String t) {
        int len=s.length();
        int count=0;
        for(int i=0;i<t.length();i++){
            if(count==len){
                return true;
            }
            if(t.charAt(i)==s.charAt(count)){
                count++;
            }
        }
        return count==len;
    }
}