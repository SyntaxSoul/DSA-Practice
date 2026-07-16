class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] result = new String[n];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        int[] sorted = score.clone();
        Arrays.sort(sorted);

        int rank = 1;

        for (int i = n - 1; i >= 0; i--) {

            int originalIndex = map.get(sorted[i]);

            if (rank == 1) {
                result[originalIndex] = "Gold Medal";
            } else if (rank == 2) {
                result[originalIndex] = "Silver Medal";
            } else if (rank == 3) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(rank);
            }

            rank++;
        }

        return result;
    }
}

// First Attempt

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] res=new String[score.length];
        int[] copy=score.clone();
        int len=score.length;
        int pos=4;
        Arrays.sort(copy);
        for(int i=len-1;i>=0;i--){
            for(int j=0;j<len;j++){
                if(copy[i]==score[j]){
                    if(i==len-1){
                        res[j]="Gold Medal";
                    }
                    else if(i==len-2){
                        res[j]="Silver Medal";
                    }
                    else if(i==len-3){
                        res[j]="Bronze Medal";
                    }
                    else{
                        res[j]=pos++ +"";
                    }
                }
            }
        }
        return res;
    }
}

