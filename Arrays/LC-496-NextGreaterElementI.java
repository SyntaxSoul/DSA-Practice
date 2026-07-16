class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Preprocess nums2
        for (int num : nums2) {

            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        // Remaining elements have no next greater element
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
}

// First Attempt

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        boolean found=false;
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    found=true;
                }
                if(found && nums2[j]>nums1[i]){
                    ans[i]=nums2[j];
                    found=false;
                    break;
                }
            }
            if(ans[i]==0){
                ans[i]=-1;
                found=false;
            }
        }
        return ans;
    }
}
