// First Attempt

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res=0;
        for(int i=0;i<timeSeries.length;i++){
            if(i==0){
                res+=duration;
                continue;
            }
            if(timeSeries[i]<=timeSeries[i-1]+duration){
                res+=timeSeries[i]-timeSeries[i-1];
                continue;
            }
            res+=duration;
        }
        return res;
    }
}

