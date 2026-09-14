class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq=new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            if (--freq[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

// HashMap approach inefficient

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>0){
                map.put(ch,map.get(ch)-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
