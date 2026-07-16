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

## LC-217: Contains Duplicate

[Solution](./LC-217-ContainsDuplicate.java)

Pattern:
- Hashing (HashSet)

Mistake:
- Initially thought of using brute force → O(n²)
- Later considered HashMap, but realized key-value storage was unnecessary for this problem

Key Insights:
- Need memory of previously seen elements to detect duplicates efficiently
- Faster lookup requires extra space

Mental Model:
- HashSet stores only unique elements
- If an element already exists in the set, a duplicate is found

Trigger:
- Detect duplicates quickly
- Check whether an element has been seen before

Time: O(n)
Space: O(n)

## LC-219: Contains Duplicate II

[Solution](./LC-219-ContainsDuplicateII.java)

Pattern:
- Hashing (HashMap)

Mistake:
- Initially forgot to update the latest index of a duplicate element when the index difference was greater than k

Key Insights:
- Need memory of previously seen elements and their indices
- Store the latest index for accurate distance checking

Mental Model:
- HashMap stores:
  value → latest index
- containsKey() helps detect previously seen elements quickly
- Updating the index prevents stale distance calculations

Trigger:
- Detect duplicates quickly
- Need index/distance tracking
- Check whether the difference between indices is <= k

Time: O(n)
Space: O(n)

## LC-228: Summary Ranges

[Solution](./LC-228-SummaryRanges.java)

Pattern:
- Range Building / Interval Traversal

Mistake:
- Initially thought it was a brute-force problem
- Tried handling remaining/final elements inside the loop instead of after traversal

Key Insights:
- Need to track the start of the current range
- A range ends when consecutive numbers break
- Final remaining range should be handled after traversal

Mental Model:
- start stores the beginning of the active range
- Continue the range while next element is consecutive
- Close the range when continuity breaks
- Single-element ranges should be added separately
- Move start to the beginning of the next range

Trigger:
- Consecutive elements
- Group continuous ranges
- Summarize intervals in sorted data

Time: O(n)
Space: O(n)

## LC-268: Missing Number

[Solution](./LC-268-MissingNumber.java)

Pattern:
- Mathematical Summation
- XOR (alternative approach)

Mistake:
- Unable to recall the summation formula initially

Key Insights:
- Numbers are in the range [0, n]
- Compute expected sum using mathematical formula
- Compute actual sum of array elements
- Difference between expected and actual sum gives the missing number

Mental Model:
- Expected sum = sum of complete range [0, n]
- Actual sum = sum of given array
- Missing number = expected sum - actual sum

Trigger:
- Complete range with one missing element
- Need missing value from known total/range

Time: O(n)
Space: O(1)

## LC-283: Move Zeroes

[Solution](./LC-283-MoveZeroes.java)

Pattern:
- Two Pointers (Slow-Fast / Overwrite-Compaction)

Mistake:
- Initially added unnecessary conditions to update i when encountering zeroes

Key Insights:
- Non-zero elements should be compacted toward the left
- Zeroes naturally move toward the end during swaps
- Maintaining a clean write position simplifies logic

Mental Model:
- i = next position to place a non-zero element
- j = traversal pointer
- Swap when nums[j] is non-zero
- Preserve relative order by processing elements left → right

Trigger:
- Move/filter elements in-place
- Preserve relative order
- Compact valid elements toward one side

Time: O(n)
Space: O(1)

## LC-303: Range Sum Query - Immutable

[Solution](./LC-303-RangeSumQueryImmutable.java)

Pattern:
- Prefix Sum
- Preprocessing

Mistake:
- Initially solved each query independently using traversal
- Later computed prefix sum inside sumRange(), which rebuilt the prefix array for every query
- Missed the main idea of preprocessing once and reusing later

Key Insights:
- Prefix sum stores cumulative sums
- Precompute prefix sums once in constructor
- Range sum can be calculated using subtraction

Mental Model:
- prefix[i] stores sum from index 0 to i
- To find sum from left to right:
  prefix[right] - prefix[left - 1]
- Subtract unwanted prefix portion

Trigger:
- Multiple range sum queries
- Repeated calculations on same array
- Precompute once and reuse

Time:
- Constructor: O(n)
- sumRange(): O(1)

Space:
- O(n)

## LC-349: Intersection of Two Arrays

[Solution](./LC-349-IntersectionOfTwoArrays.java)

Pattern:
- Hashing (HashSet)

Mistake:
- Didn’t know how to convert Set<Integer> to int[]

Key Insights:
- set1 stores all unique elements from nums1
- set2 stores only unique intersection elements
- HashSet provides fast existence lookup

Mental Model:
- set1 = memory of elements from nums1
- While traversing nums2:
  - if element exists in set1
  - add it to set2
- set2 automatically avoids duplicates

Trigger:
- Need fast existence lookup
- Need unique elements
- Find common/intersection elements

Time: O(n + m)
Space: O(n + m)

## LC-350: Intersection of Two Arrays II

[Solution](./LC-350-IntersectionOfTwoArraysII.java)

Pattern:
- HashMap
- Frequency Counting

Mistakes:
- Initially thought of using HashSet, but HashSet removes duplicates, whereas this problem requires preserving duplicate occurrences.
- Was unsure how to convert a List<Integer> to an int[].

Key Insights:
- Store the frequency of every element from nums1 in a HashMap.
- Traverse nums2.
- If an element exists in the map with frequency > 0:
  - Add it to the answer.
  - Decrease its frequency.
- Frequency count naturally handles duplicates.

Mental Model:
- HashMap acts like an inventory.
- nums1 fills the inventory.
- nums2 consumes items from the inventory.
- Once the count becomes zero, that element is no longer available.

Trigger:
- Need duplicate occurrences.
- Need fast lookup.
- Need to know how many times an element can still be used.

Time: O(n + m)
Space: O(n)

## LC-414: Third Maximum Number

[Solution](./LC-414-ThirdMaximumNumber.java)

Pattern:
- Array Traversal
- Track Maximum Values
- State Tracking

Mistakes:
- Initially focused on finding the three largest values instead of the three **distinct** largest values.
- Forgot that duplicate values must not be counted as separate maximums.
- Tried updating maximum values without carefully maintaining their order, which caused incorrect tracking.

Key Insights:
- Only distinct maximum values should be considered.
- Whenever a new maximum is found, the previous maximums must be shifted correctly.
- Before updating any maximum, check whether the current number is already one of the tracked maximums.

Mental Model:
- Imagine three podium positions:
  - First Maximum
  - Second Maximum
  - Third Maximum
- Every new distinct value competes for one of these positions.
- If it becomes the new first, everyone else shifts down one position.

Trigger:
- Need to find the top K distinct elements.
- Constant extra space is expected.
- Single array traversal is sufficient.

Time: O(n)
Space: O(1)

## LC-448: Find All Numbers Disappeared in an Array

[Solution](./LC-448-FindAllNumbersDisappearedInAnArray.java)

Pattern:
- Cyclic Sort
- Array Traversal
- In-place Index Placement

Mistakes:
- First thought was to use a HashSet, but realized the follow-up required O(1) extra space.
- Tried swapping elements only once using a `for` loop, which failed because a swapped element may also be in the wrong position.
- Initially thought arranging the array would directly give the answer and didn't realize a second traversal is required to identify missing numbers.
- Learned that duplicates prevent every number from reaching its correct index, leaving mismatched indices that reveal the missing numbers.

Key Insights:
- Every number belongs to index `value - 1`.
- Continue swapping until the current number is either:
  - at its correct index, or
  - blocked by a duplicate.
- After placement, if `nums[i] != i + 1`, then `i + 1` is missing.
- A second traversal is necessary after cyclic placement to collect all missing numbers.

Mental Model:
- Imagine every number has a "home" at index `value - 1`.
- Keep sending each number to its home.
- If a home is already occupied by the same number, it's a duplicate and cannot move further.
- The empty homes (incorrect indices) correspond to the missing numbers.

Trigger:
- Numbers are in the range `[1, n]`.
- Need O(n) time and O(1) extra space.
- Problem asks to place numbers at their correct indices or detect missing values.

Time: O(n)
Space: O(1)

## LC-455: Assign Cookies

[Solution](./LC-455-AssignCookies.java)

Pattern:
- Greedy
- Sorting
- Two Pointers

Mistakes:
- Initially tried assigning every cookie to every child using nested loops, which reused cookies multiple times.
- Couldn't think of an optimal solution because sorting didn't initially seem necessary.
- Thought sorting might not be optimal, but later realized it is the key observation for the greedy approach.
- Initially matched children from the largest greed factor, but later learned that matching the smallest available cookie to the least greedy child is the natural greedy strategy.

Key Insights:
- Sort both the greed array and the cookie array.
- Always satisfy the least greedy child first using the smallest cookie that can satisfy them.
- If the current cookie cannot satisfy a child, it can never satisfy a greedier child.
- Each cookie is used exactly once, so advancing pointers naturally prevents reuse.

Mental Model:
- Line up children by increasing greed.
- Line up cookies by increasing size.
- Try to satisfy the current child with the current smallest available cookie.
- If successful, move to the next child and next cookie.
- Otherwise, discard the small cookie and try the next larger one.

Trigger:
- Need to maximize the number of successful assignments.
- Each resource can be used only once.
- Matching smallest feasible resource with smallest requirement suggests a Greedy approach.
- Sorting helps make local optimal decisions.

Time: O(n log n + m log m)
Space: O(1)

## LC-463: Island Perimeter

[Solution](./LC-463-IslandPerimeter.java)

Pattern:
- Matrix Traversal
- Neighbour Traversal
- Counting

Mistakes:
- Initially tried handling boundary cells separately, which made the code complex and error-prone.
- Assumed corner and edge cells required different logic instead of treating every land cell uniformly.
- Accidentally skipped the 0th row and 0th column while checking neighbours due to restrictive boundary conditions.
- Got confused by nested braces, causing the neighbour-checking logic to execute incorrectly.
- Overcomplicated the solution before realizing every land cell contributes 4 edges, and each shared neighbour removes 1 exposed edge.

Key Insights:
- Every land cell initially contributes 4 sides to the perimeter.
- For every adjacent land neighbour, subtract 1 from the current cell's perimeter contribution.
- The same shared edge is counted once from each cell, naturally removing 2 from the total perimeter.
- Boundary checks are only required before accessing neighbours, not for calculating perimeter separately.

Mental Model:
- Imagine every land cell as an independent square with 4 walls.
- Whenever two land cells touch, they share a wall, so that wall is no longer exposed.
- Final perimeter = Total walls - Shared walls.

Trigger:
- Need to count exposed sides of cells.
- Each cell contributes a fixed value initially.
- Neighbour relationships reduce the contribution.
- Matrix traversal with four-direction neighbour checks.

Time: O(m × n)
Space: O(1)

## LC-485: Max Consecutive Ones

[Solution](./LC-485-MaxConsecutiveOnes.java)

Pattern:
- Array Traversal
- Running Count
- Maximum Tracking

Mistakes:
- Initially forgot to compare the final running count with the maximum after the loop.
- Realized the longest sequence might end at the last element, so updating `max` only when encountering `0` is insufficient.

Key Insights:
- Maintain a running count of consecutive `1`s.
- Reset the count whenever a `0` is encountered.
- Update the maximum length whenever the streak ends.
- Perform one final comparison after the loop to handle a streak ending at the last element.

Mental Model:
- Think of `current` as the length of the ongoing streak.
- A `0` acts as a wall that ends the current streak.
- Every time a wall appears, compare the streak with the best one seen so far.
- After finishing the traversal, check the last streak since it may never have encountered a wall.

Trigger:
- Need to find the longest continuous sequence.
- Sequence breaks on a specific value.
- Maintain a running count and update the answer when the sequence ends.

Time: O(n)
Space: O(1)

## LC-495: Teemo Attacking

[Solution](./LC-495-TeemoAttacking.java)

Pattern:
- Array Traversal
- Interval Overlap
- Greedy Counting

Mistakes:
- Initially thought the solution would be more complicated than it actually was.
- Used `<=` instead of `<` while checking overlap, then realized the poison duration includes the attack time, so the overlap condition depends on the interval boundaries.
- Learned that when two poison intervals overlap, only the non-overlapping duration should be added instead of adding the full duration again.

Key Insights:
- The first attack always contributes the full poison duration.
- For every subsequent attack:
  - If it overlaps with the previous poison interval, add only the time difference.
  - Otherwise, add the full duration.
- The problem is about calculating the union of overlapping intervals, not simulating every poisoned second.

Mental Model:
- Imagine every attack creates a poison interval.
- If the next interval starts before the previous one ends, merge them by adding only the uncovered portion.
- If there is no overlap, simply add a new interval of full duration.

Trigger:
- Need to calculate total covered time.
- Intervals may overlap.
- Previous interval affects the contribution of the current interval.

Time: O(n)
Space: O(1)

## LC-496: Next Greater Element I

[Solution](./LC-496-NextGreaterElementI.java)

Pattern:
- Monotonic Stack
- HashMap
- Array Traversal

Mistakes:
- Started with a brute-force nested loop solution without recognizing the repeated work.
- Couldn't understand why a Stack was required when a HashMap seemed sufficient.
- Initially thought the HashMap could directly store the next greater element, but didn't realize the values must be discovered first.
- Found the Stack explanation confusing until realizing it keeps elements whose next greater value is still unknown.

Key Insights:
- A HashMap stores the final answers, but it cannot discover them by itself.
- A Monotonic Stack maintains decreasing elements waiting for their next greater element.
- When a larger element appears, it becomes the next greater element for every smaller element on top of the stack.
- After preprocessing `nums2`, answering each query from `nums1` becomes a simple HashMap lookup.

Mental Model:
- Imagine people standing in a queue waiting for someone taller.
- The Stack contains everyone still waiting.
- As soon as a taller person arrives, everyone shorter on top of the stack gets their answer and leaves the queue.
- The HashMap records these answers for future lookup.

Trigger:
- Need the first greater element to the right.
- Multiple queries depend on preprocessing another array.
- Repeated right-side searching suggests using a Monotonic Stack.

Time: O(n + m)
Space: O(n)

## LC-500: Keyboard Row

[Solution](./LC-500-KeyboardRow.java)

Pattern:
- Hashing
- String Traversal
- Character Mapping

Mistakes:
- Initially tried using `String.contains()` for every character, which made the implementation complicated.
- Confused `char` with `String` while using `contains()`.
- Tried manually comparing keyboard rows instead of assigning each character a row number.
- Didn't realize that a fixed-size array (`int[26]`) is simpler and faster than a `HashMap` because the alphabet size is fixed.

Key Insights:
- Every alphabet belongs to exactly one keyboard row.
- Map every character to its row number (1, 2, or 3).
- Determine the row of the first character.
- Every remaining character must belong to the same row.
- If any character belongs to a different row, reject the word immediately.

Mental Model:
- Imagine every letter has a permanent row ID.
- Pick the row ID of the first letter.
- Verify that every other letter has the same ID.
- One mismatch means the word cannot be typed using a single keyboard row.

Trigger:
- Need to classify characters into fixed groups.
- Character-to-category mapping is required.
- Fixed alphabet size (26) suggests using an array instead of a HashMap.

Time: O(n × m)
- n = number of words
- m = average word length

Space: O(1)

## LC-506: Relative Ranks

[Solution](./LC-506-RelativeRanks.java)

Pattern:
- Sorting
- HashMap (Index Mapping)

Mistakes:
- Initially tried sorting a copy of the array and searching the original array using nested loops, resulting in O(n²) time.
- Couldn't figure out how to preserve the original indices after sorting.
- Thought sorting alone would be sufficient, but realized the final answer must be returned in the original order.
- Took time to understand that a HashMap can directly map each score to its original index, eliminating repeated searches.

Key Insights:
- Sort only to determine the ranking order.
- The original order must be preserved while building the final answer.
- Use a HashMap to connect each score with its original index.
- Assign "Gold Medal", "Silver Medal", "Bronze Medal", then numerical ranks starting from 4.

Mental Model:
- Imagine preparing a leaderboard.
- Sorting tells you who came 1st, 2nd, 3rd...
- The HashMap tells you where that person originally stood in the input array.
- Place the corresponding rank back into the correct position.

Trigger:
- Need ranking based on sorted values.
- Final output must follow the original input order.
- Sorting changes positions, so index mapping is required.

Time: O(n log n)
Space: O(n)

## LC-561: Array Partition

[Solution](./LC-561-ArrayPartition.java)

Pattern:
- Sorting
- Greedy

Mistakes:
- Initially overthought the problem instead of looking for a pairing strategy.
- Didn't immediately realize that sorting makes the optimal pairing obvious.
- Thought pairing from the end using `Math.min()` was different, then realized it is equivalent to summing every alternate element after sorting.

Key Insights:
- Sorting places similar values together.
- Pairing adjacent elements maximizes the sum of the minimum values.
- In every sorted pair, the smaller element always contributes to the answer.
- Traversing from either direction works as long as adjacent sorted elements are paired consistently.

Mental Model:
- Arrange all numbers in ascending order.
- Form pairs using neighbouring elements.
- Every pair contributes its smaller element to the final answer.
- Greedy works because pairing nearby numbers prevents wasting large numbers.

Trigger:
- Need to maximize or minimize a value by forming pairs.
- Sorting naturally exposes the optimal pairing.
- Local optimal choices lead to the global optimum.

Time: O(n log n)
Space: O(1)