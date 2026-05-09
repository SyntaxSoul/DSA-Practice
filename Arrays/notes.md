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

## LC-118: Pascal's Triangle

[LC-118 Solution](./LC-118-PascalsTriangle.java)

Pattern:
- Dynamic Programming (Build from previous state)

Mistake:
- Incorrect syntax
- Missing return statement
- Treated list like a 2D array instead of building row by row

Key Insights:
- First and last elements of each row are always 1
- Each inner element = sum of two elements from previous row
- Create a new row each time and append it to the main list

Time: O(n²)
Space: O(n²)

## LC-119: Pascal's Triangle II

[LC-119 Solution](./LC-118-PascalsTriangleII.java)

Pattern:
- Dynamic Programming (Build from previous state)

Mistake:
- Initially thought full triangle is required (but only one row is needed)

Key Insights:
- Only previous row is needed to compute current row
- First and last elements are always 1
- Reuse a single list (`prev`) and update it for each row

Time: O(n²)
Space: O(n) 

## LC-121: Best Time to Buy and Sell Stock

[Solution](./LC-121-BestTimeToBuyAndSellStock.java)

Pattern:
- Single traversal
- Running minimum tracking
- Greedy traversal

Mistake:
- Initially thought it was a two-pointer approach

Key Insights:
- Maintain the minimum price seen so far
- Calculate current profit dynamically
- Update maximum profit continuously

Time: O(n)
Space: O(1)

## LC-136: Single Number

[Solution](./LC-136-SingleNumber.java)

Pattern:
- Bit Manipulation (XOR)

Mistake:
- Initially thought it was a hashing/frequency-counting problem

Key Insights:
- XOR cancels out repeating elements
- Even occurrences become 0
- Only the unique element survives
- XOR works regardless of element order

Mental Model:
- XOR behaves like toggle switches
- First occurrence → ON
- Second occurrence → OFF

Trigger:
- Every element appears twice except one

Time: O(n)
Space: O(1)

## LC-169: Majority Element

[Solution](./LC-169-MajorityElement.java)

Pattern:
- Boyer-Moore Voting Algorithm

Mistake:
- Initially thought there would only be two different candidates in the array

Key Insights:
- When count becomes 0, choose the current element as the new candidate
- If the same candidate appears, increase count
- If a different element appears, decrease count

Mental Model:
- Candidate gains support when repeated
- Different elements cancel support
- Majority element survives all cancellations

Trigger:
- One element appears more than n/2 times
- Majority element can cancel out all other elements combined

Time: O(n)
Space: O(1)