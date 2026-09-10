## LC-134: Gas Station

[Solution](./LC-134-GasStation.java)

Pattern:
- Greedy
- Array Traversal
- Running Sum

Mistakes:
- Initially separated positive and negative fuel differences instead of considering their order.
- Assumed a station with `gas[i] >= cost[i]` was automatically a good starting point.
- Focused on the total surplus/deficit without tracking when the tank became negative.
- Discovered the greedy approach but initially forgot to verify that the total gas was sufficient to complete the circuit.

Key Insights:
- The order of fuel differences matters more than simply counting positive and negative values.
- Maintain a running tank while traversing the stations.
- If the tank becomes negative, none of the stations from the current start to the failure point can be the answer, so start from the next station.
- A valid starting station exists only if the total gas is at least the total cost.

Mental Model:
- Imagine driving around the circuit with a fuel tank.
- Keep adding the current station's net fuel (`gas[i] - cost[i]`).
- If the tank drops below zero, abandon the current starting point and restart from the next station.
- At the end, if the overall fuel balance is non-negative, the last chosen start is the answer.

Trigger:
- Need to find a valid starting position in a circular traversal.
- Running total determines whether the current candidate remains valid.
- When failure at one point eliminates an entire range of candidates, think Greedy.

Time: O(n)

Space: O(1)

## LC-58: Length of Last Word

[Solution](./LC-58-LengthOfLastWord.java)

Pattern:
- String Traversal
- Reverse Traversal

Mistakes:
- Initially used `trim()`, which creates a new string unnecessarily.
- Compared spaces using `ch - 32 == 0` instead of `ch == ' '`, making the code less readable.
- Later realized that traversing from the end naturally avoids the need for `trim()`.

Key Insights:
- Skip all trailing spaces first.
- Once the first non-space character is found, start counting.
- Stop counting when the next space is encountered.
- Reverse traversal makes the solution simple and avoids extra string creation.

Mental Model:
- Start from the end of the string.
- Ignore trailing spaces.
- Count characters of the last word.
- Stop when the previous space is reached.

Trigger:
- Need information about the last word or last token in a string.
- Trailing spaces may be present.
- Reverse traversal is simpler than preprocessing the string.

Time: O(n)

Space: O(1)

## LC-14: Longest Common Prefix

[Solution](./LC-14-LongestCommonPrefix.java)

Pattern:
- String Traversal
- Prefix Comparison

Mistakes:
- Initially assumed the first string's length could always be used as the comparison limit.
- Later realized the common prefix cannot be longer than the shortest string.
- Learned to update the valid prefix length whenever a shorter string is encountered.

Key Insights:
- Use the first string as the reference.
- Compare every other string character by character.
- Keep reducing the maximum possible prefix length whenever a mismatch occurs.
- The final prefix is the substring of the first string up to the remaining valid length.

Mental Model:
- Imagine the first string as a template.
- Every new string trims the template whenever a mismatch is found.
- The template keeps shrinking until all strings agree.

Trigger:
- Need the common starting sequence among multiple strings.
- Compare characters column by column.
- The answer can only become shorter as more strings are processed.

Time: O(n × m)
- n = number of strings
- m = length of the shortest string

Space: O(1)

## LC-28: Find the Index of the First Occurrence in a String

[Solution](./LC-28-FindTheIndexOfTheFirstOccurrenceInAString.java)

Pattern:
- String Traversal
- Substring Matching

Mistakes:
- Initially used `==` instead of `.equals()` for string comparison.
  - `==` compares whether two references point to the same object in memory.
  - `.equals()` compares the actual sequence of characters.
- Forgot to check whether `needle.length()` is greater than `haystack.length()`.
- Forgot to verify that `i + needle.length()` does not exceed the length of `haystack` before calling `substring()`.
- Initially underestimated the time complexity because `substring()` and `.equals()` are not constant-time operations.

Key Insights:
- Compare only when the first character matches.
- Always ensure the substring boundaries are valid before extracting it.
- Use `.equals()` for string content comparison.
- Early boundary checks prevent unnecessary work and runtime exceptions.

Mental Model:
- Slide a window of length `needle.length()` over the `haystack`.
- Whenever the first character matches, compare the entire window with `needle`.
- Return the first matching index.

Trigger:
- Need to find the first occurrence of one string inside another.
- Compare fixed-length windows over a larger string.
- Brute-force matching is acceptable when advanced string algorithms are not required.

Time: O(n × m)

Space: O(m)

## LC-125: Valid Palindrome

[Solution](./LC-125-ValidPalindrome.java)

Pattern:
- Two Pointers
- String Traversal

Mistakes:
- Initially cleaned the string using `replaceAll()` and created a reversed copy, leading to unnecessary extra space.
- Built the reversed string using `+=`, which resulted in O(n²) time because Java `String` is immutable.
- Got stuck implementing the two-pointer approach because special characters appeared in between valid characters.
- Later realized invalid characters don't need to be removed; they can simply be skipped during traversal.

Key Insights:
- Use two pointers starting from both ends of the string.
- Skip all non-alphanumeric characters before comparing.
- Compare characters in a case-insensitive manner.
- No extra string or regex is required.

Mental Model:
- Imagine two people walking towards each other from opposite ends.
- If either person stands on a special character, they simply step over it.
- Only when both stand on letters or digits do they compare.
- If every comparison matches, the string is a palindrome.

Trigger:
- Need to compare characters from both ends.
- Invalid characters should be ignored rather than removed.
- String reversal or extra memory is unnecessary.

Time: O(n)

Space: O(1)

## LC-392: Is Subsequence

[Solution](./LC-392-IsSubsequence.java)

Pattern:
- Two Pointers
- String Traversal

Mistakes:
- Initially forgot to handle the case when all characters of `s` are matched before reaching the end of `t`.
- Learned that only one pass through `t` is required; backtracking is unnecessary.
- Realized the answer depends on preserving the order of characters, not on them being contiguous.

Key Insights:
- Traverse `t` once while tracking the current character of `s`.
- Whenever characters match, move to the next character in `s`.
- If every character of `s` is matched in order, `s` is a subsequence of `t`.
- An early return is possible as soon as all characters of `s` are matched.

Mental Model:
- Imagine `s` as a checklist.
- Walk through `t` from left to right.
- Every time the current checklist item is found, cross it off and move to the next one.
- If the entire checklist is completed, the answer is `true`.

Trigger:
- Need to determine whether one sequence appears in another while preserving order.
- Characters do not need to be adjacent.
- Single forward traversal is sufficient.

Time: O(n)
- n = length of `t`

Space: O(1)