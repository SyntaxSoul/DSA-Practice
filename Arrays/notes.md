## LC-88: Merge Sorted Array

[LC-88 Solution](./LC-88-MergeSortedArray.java)

Pattern:
- Two Pointers (merge from end)

Mistake:
- Initially forgot to handle case when nums1 is exhausted (i < 0)

Key Insight:
- Fill from the back to avoid overwriting elements in nums1

Time: O(m+n)
Space: O(1)

## LC-108: Convert Sorted Array to Binary Search Tree

[LC-108 Solution](./LC-108-ConvertSortedArrayToBinarySearchTree.java)

Pattern:
- Recursion (Divide and Conquer)

Mistake:
- Initially tried using loops instead of recursion
- Incorrect base case (was creating node when start > end instead of returning null)
- Used index instead of value (mid instead of nums[mid])

Key Insight:
- Pick middle element as root to maintain balance
- Recursively build left subtree from (start → mid-1)
- Recursively build right subtree from (mid+1 → end)
- Base case: when start > end, return null

Time: O(n)
Space: O(log n)  // recursion stack