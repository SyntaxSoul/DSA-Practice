class Solution {
    public int findContentChildren(int[] g, int[] s) {
       int res=0;
       Arrays.sort(g);
       Arrays.sort(s);
       int j=s.length-1;
       if(j<0){
        return 0;
       }
       for(int i=g.length-1;i>=0;i--){
        if( j>=0 && s[j]>=g[i]){
            j--;
            res++;
        }
       }
       return res;
    }
}

// First Attempt

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res=0;
        int i=0;
        while(i<g.length){
            for(int j=0;j<s.length;j++){
                if(i<g.length && s[j]>=g[i]){
                    res++;
                    i++;
                }
            }
            i++;
        }
        return res;
    }
}

/*The issue with the logic is it uses used cookies and asigns and counts again

For this problem while thinking also I'm feeling like need sort, 
but I also know that's not the optimal solution and the current sol is O(n^2) . 
I am stuck finding solution*/