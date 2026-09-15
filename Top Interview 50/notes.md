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

## LC-167: Two Sum II - Input Array Is Sorted

[Solution](./LC-167-TwoSumII-InputArrayIsSorted.java)

Pattern:
- Two Pointers
- Array Traversal

Mistakes:
- Initially recalculated `numbers[start] + numbers[end]` multiple times in the same iteration.
- Learned that storing the sum once makes the code cleaner and easier to read.
- Realized that the sorted property eliminates the need for a HashMap.

Key Insights:
- Start with pointers at both ends of the array.
- If the sum is too small, move the left pointer to increase it.
- If the sum is too large, move the right pointer to decrease it.
- The sorted order guarantees that these local decisions never miss the correct answer.

Mental Model:
- Imagine two people standing at opposite ends of a sorted line.
- If their combined value is too small, the smaller value must increase, so move the left pointer.
- If the combined value is too large, the larger value must decrease, so move the right pointer.
- Continue until the target sum is found.

Trigger:
- Input array is sorted.
- Need to find a pair satisfying a condition.
- Adjusting one pointer predictably changes the sum.

Time: O(n)

Space: O(1)

## LC-11: Container With Most Water

[Solution](./LC-11-ContainerWithMostWater.java)

Pattern:
- Two Pointers
- Greedy

Mistakes:
- Initially, it wasn't obvious why moving only the shorter pointer is the correct choice.
- Learned that moving the taller pointer can never increase the area because the width always decreases while the limiting height remains unchanged.

Key Insights:
- The area is determined by the shorter of the two heights.
- The width decreases after every pointer movement.
- To have any chance of increasing the area, the limiting (shorter) height must increase.
- Therefore, always move the pointer pointing to the shorter line.

Mental Model:
- Imagine two walls holding water.
- The shorter wall limits the water level.
- Moving the taller wall only reduces the width without increasing the water level.
- Moving the shorter wall gives a chance to find a taller wall while accepting the reduced width.

Trigger:
- Input is an array with decisions involving both ends.
- Need to maximize or minimize a value based on two endpoints.
- One pointer movement can be eliminated using a greedy observation.

Time: O(n)

Space: O(1)

## LC-383: Ransom Note

[Solution](./LC-383-RansomNote.java)

Pattern:
- HashMap
- Frequency Counting

Mistakes:
- Initially used `break` when a required character was unavailable instead of returning `false` immediately.
- Returned `true` inside the loop after processing the last character, which was unnecessary.
- Learned that consuming character frequencies while traversing the ransom note is simpler than comparing two complete frequency maps.

Key Insights:
- Count the frequency of each character in the magazine.
- For every character in the ransom note, consume one occurrence from the frequency map.
- If a required character is missing or exhausted, construction is impossible.
- Successfully consuming every character means the ransom note can be constructed.

Mental Model:
- Imagine the magazine as a bag of letters.
- Each time you need a letter for the ransom note, take one from the bag.
- If the bag doesn't contain the required letter, stop immediately.
- If every required letter is available, the ransom note can be formed.

Trigger:
- Need to verify whether one collection can supply another.
- Character frequencies matter.
- Characters are consumed after use.

Time: O(n + m)

Space: O(k)
- `k` = number of distinct characters (or O(1) for lowercase English letters)

## LC-205: Isomorphic Strings

[Solution](./LC-205-IsomorphicStrings.java)

Pattern:
- HashMap
- Character Mapping

Mistakes:
- Initially tried solving the problem using character frequencies, but realized equal frequencies do not guarantee isomorphic strings.
- Struggled to understand what "mapping" meant.
- First implemented only `s → t` mapping, then realized two different characters from `s` could still map to the same character in `t`.
- Learned that the mapping must be one-to-one, requiring validation in both directions.

Key Insights:
- Each character in `s` must always map to the same character in `t`.
- No two different characters in `s` can map to the same character in `t`.
- Maintain two HashMaps:
  - `s → t`
  - `t → s`
- Verify both mappings at every character.

Mental Model:
- Imagine assigning permanent partners.
- Once `a` is paired with `x`, it can never pair with another character.
- Likewise, `x` cannot be paired with anyone except `a`.
- Every new character pair must respect both existing mappings.

Trigger:
- Need to enforce a one-to-one relationship between two sets of characters.
- Character frequencies are insufficient.
- Bidirectional consistency suggests using two HashMaps.

Time: O(n)

Space: O(k)

## LC-290: Word Pattern

[Solution](./LC-290-WordPattern.java)

Pattern:
- HashMap
- Bidirectional Mapping
- String Parsing

Mistakes:
- Initially tried parsing the sentence manually, making the logic more complex than necessary.
- Compared `StringBuilder` objects with `String` values instead of converting them using `toString()`.
- Learned that checking only `pattern → word` mapping is insufficient; the reverse mapping (`word → pattern`) is also required.
- Missed the edge case where the number of pattern characters and words do not match.

Key Insights:
- The problem is an extension of **LC-205: Isomorphic Strings**.
- Every pattern character must map to exactly one word.
- Every word must map back to exactly one pattern character.
- Use two HashMaps to enforce one-to-one mapping.
- Always ensure the number of words matches the length of the pattern before validating mappings.

Mental Model:
- Imagine assigning permanent nicknames.
- Once a pattern character is paired with a word, that pairing can never change.
- Likewise, a word cannot be assigned to two different pattern characters.
- Every new pair must satisfy both existing mappings.

Trigger:
- Need to establish a one-to-one relationship between two different types of objects.
- Bidirectional consistency is required.
- Think of LC-205 whenever mapping between two sequences is involved.

Time: O(n)

Space: O(k)
- `k` = number of distinct pattern characters and words.

## LC-242: Valid Anagram

[Solution](./LC-242-ValidAnagram.java)

Pattern:
- Frequency Counting
- Fixed-Size Array
- String Traversal

Mistakes:
- Initially solved the problem using a `HashMap`, then realized a fixed-size frequency array is more suitable since the input contains only lowercase English letters.
- Learned that a fixed-size array (`int[26]`) uses constant extra space, not O(n).
- Initially decremented the frequency in two steps, then learned it can be combined into a single operation (`--freq[index]`).

Key Insights:
- If the string lengths differ, they cannot be anagrams.
- Count the frequency of each character in the first string.
- Decrease the frequency while traversing the second string.
- If any frequency becomes negative, the strings are not anagrams.
- If every character is successfully consumed, the strings are anagrams.

Mental Model:
- Imagine the first string as a bag of letters.
- Every character from the second string removes one matching letter from the bag.
- If a required letter is unavailable, the strings cannot be anagrams.
- Successfully removing every letter means both strings contain exactly the same characters.

Trigger:
- Need to compare character frequencies.
- Character order does not matter.
- Character set is fixed (lowercase English letters), making a frequency array preferable to a HashMap.

Time: O(n)

Space: O(1)

## LC-202: Happy Number

[Solution](./LC-202-HappyNumber.java)

Pattern:
- HashSet
- Cycle Detection
- Digit Manipulation

Mistakes:
- Initially used `^2` to square digits, then learned that `^` is the bitwise XOR operator in Java, not exponentiation.
- First attempted to detect a cycle by checking whether the number returned to its original value, but realized cycles may not include the starting number.
- Learned that storing previously seen numbers in a HashSet reliably detects any cycle.

Key Insights:
- Replace the number with the sum of the squares of its digits.
- If the number becomes `1`, it is a happy number.
- If a number repeats, the process has entered a cycle and will never reach `1`.
- A HashSet efficiently detects repeated states.

Mental Model:
- Imagine each number as a state in a journey.
- Every transformation moves to a new state.
- Reaching `1` means success.
- Visiting a previously seen state means you're trapped in a loop forever.

Trigger:
- Repeatedly transform a value.
- Need to detect whether a sequence enters a cycle.
- HashSet is a natural choice for remembering previously visited states.

Time: O(k)

Space: O(k)

(`k` = number of unique intermediate values before reaching `1` or a cycle. In practice, both are effectively O(1).)
