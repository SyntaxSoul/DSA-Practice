// Final working code

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tank = 0;
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            tank += diff;
            total += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }
}

// I was unable to find the solution as I wasn't thinking interms of tank and total
// so wrote the below code, it works but misses the concept of total.


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0;
        int start=-1;
        for(int i=0;i<gas.length;i++){
            tank+=gas[i]-cost[i];
            if(start==-1){
                start=i;
            }
            if(tank<0){
                tank=0;
                start=-1;
            }
        }
        for(int i=0;i<start;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                return -1;
            }
        }
        return start;
    }
}

// How I was thinking before

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        Integer start=null;
        int req=0;
        int tank=0;
        boolean cont =false;
        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i]){
                if(!cont){
                    start=i;
                }
                tank+=gas[i]-cost[i];
                cont=true;
            }
            else if(gas[i]<cost[i] && cont){
                cont=false;
            }
            if(!cont){
                req+=gas[i]-cost[i];
            }

        }
        if(req+tank>=0){
            return start;
        }
        return -1;
    }
}