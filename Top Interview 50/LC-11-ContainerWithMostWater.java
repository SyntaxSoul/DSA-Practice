class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int start=0;
        int end=height.length-1;
        while(start<end){
            int area=Math.min(height[start],height[end])*(end-start);
            if(area>max){
                max=area;
            }
            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return max;
    }
}