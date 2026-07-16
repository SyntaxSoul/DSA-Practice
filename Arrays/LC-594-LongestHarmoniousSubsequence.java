class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        for(int i:map.keySet()){
            if(map.containsKey(i+1)){
                max=Math.max(max,map.get(i)+map.get(i+1));
            }
        }
        return max;
    }
}

// First Attempt

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        
        Set<Integer> set=map.keySet();
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        Integer prev=null;
        for(int i:list){
            if(prev==null){
                prev=i;
                continue;
            }
            if(Math.abs(prev-i)==1){
                max=Math.max(max,map.get(prev)+map.get(i));
                prev=i;
            }
            else{
                prev=null;
            }
        }
        return max;
    }
}
