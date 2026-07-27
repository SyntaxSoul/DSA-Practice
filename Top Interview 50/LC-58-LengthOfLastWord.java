

class Solution {
    public int lengthOfLastWord(String s) {
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (res > 0) break;
            } else {
                res++;
            }
        }
        return res;
    }
}


// First tried traversing from the front and found a edge case of having spaces in the last
// then used trim()
// later thought we can achieve this easily by traversing from the end of the string.

class Solution {
    public int lengthOfLastWord(String s) {
        int res=0;
        s=s.trim();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch-32==0){
                res=0;
            }
            else{
                res++;
            }
        }
        return res;
    }
}