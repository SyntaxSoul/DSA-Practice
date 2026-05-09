class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int current=0;
        for(int num: nums){
            if(count==0){
                current=num;
            }
            if(current==num){
                count++;
            }
            else{
                count--;
            }
        }
        return current;
    }
}

// First attemp I coded the below code 
// Thought only 2 diffrent numbers will be in the array (Misassumption)

class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int current=0;
        for(int num: nums){
            if(count==0){
                current=num;
            }
            if(current==num){
                count++;
            }
            else{
                count--;
            }
        }
        return current;
    }
}