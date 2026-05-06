
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int num: nums){
            ans^=num;
        }
        return ans;
    }
}

// Bit Manipulation (XOR)

// I thought it is a HashMap problem and solved
// The solution works but not optimal

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }
}