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