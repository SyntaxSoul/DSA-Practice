

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int last=m+n-1;
        int j=n-1;
        while(j>=0){  // Add i>=0 in condition
            if(i<0){  // create a separate while loop to handle i<0 instead of if block
                nums1[last]=nums2[j];
                last--;
                j--;
            }
            else if(nums1[i]<nums2[j]){
                nums1[last]=nums2[j];
                last--;
                j--;
            }
            else{
                nums1[last]=nums1[i];
                last--;
                i--;
            }
        }
    }
}

// Can be simplified as 

/*
while (i >= 0 && j >= 0) {
    if (nums1[i] > nums2[j]) {
        nums1[last--] = nums1[i--];
    } else {
        nums1[last--] = nums2[j--];
    }
}

while (j >= 0) {
    nums1[last--] = nums2[j--];
}
*/