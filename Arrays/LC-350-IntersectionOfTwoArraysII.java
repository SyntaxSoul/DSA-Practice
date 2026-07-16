
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] res=new int[Math.min(nums1.length,nums2.length)];
		// Intersections length is always <= the shortest array.
        for(int num:nums1){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        int i=0;
        for(int num:nums2){
            if(map.containsKey(num) && map.get(num)>0){
                res[i++]=num;
                map.put(num,map.get(num)-1);
            }
        }
        return Arrays.copyOf(res,i);
        
    }
}