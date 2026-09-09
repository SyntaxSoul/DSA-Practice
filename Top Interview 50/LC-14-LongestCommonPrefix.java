class Solution {
    public String longestCommonPrefix(String[] strs) {
        int count=strs[0].length();
        for(int i=1;i<strs.length;i++){
            int len=strs[i].length();
            for(int j=0;j<len && j<count;j++){
                if(strs[0].charAt(j)!=strs[i].charAt(j)){
                    count=j;
                    break;
                }
            }
            count = Math.min(count, strs[i].length());
        }
        return count>0?strs[0].substring(0,count):"";
    }
}