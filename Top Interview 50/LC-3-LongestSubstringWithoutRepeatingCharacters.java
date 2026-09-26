class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int max=0;
        int front=0;
        int back=0;
        while(back<s.length()){
            if(!set.contains(s.charAt(back))){
                set.add(s.charAt(back++));
                max=Math.max(max,back-front);
            }
            else{
                set.remove(s.charAt(front));
                front++;
            }
        }
        return max;
    }
}