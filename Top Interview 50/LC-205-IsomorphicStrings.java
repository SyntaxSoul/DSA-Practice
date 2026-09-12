class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> sToT=new HashMap<>();
        Map<Character,Character> tToS=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char sCh=s.charAt(i);
            char tCh=t.charAt(i);
            if(!sToT.containsKey(sCh) && !tToS.containsKey(tCh)){
                sToT.put(sCh,tCh);
                tToS.put(tCh,sCh);
            }
            else if(sToT.containsKey(sCh) && tToS.containsKey(tCh)){
                if(sToT.get(sCh)!=tCh || tToS.get(tCh)!=sCh){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }
}