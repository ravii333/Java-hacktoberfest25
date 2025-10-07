# Continuous Subarrays — Java Solution

## Problem Description

You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:

Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
Return the total number of continuous subarrays.

A subarray is a contiguous non-empty sequence of elements within an array.
---

## Approach

We use a **sliding window** technique with two **deques** to efficiently maintain the **maximum** and **minimum** of the current window.

### Steps:
1. Expand the window by moving the `right` pointer.
2. Maintain:
   - A decreasing deque (`maxDeque`) for tracking the current window’s maximum.
   - An increasing deque (`minDeque`) for tracking the current window’s minimum.
3. If the difference `max - min > 2`, move the `left` pointer to shrink the window until it becomes valid again.
4. For every valid window ending at `right`, add `(right - left + 1)` to the total count — representing all subarrays ending at `right`.

### Time Complexity
- O(n) — each element is added and removed from the deques at most once.

### Space Complexity
- O(n) — due to the deques.

---

## Example

**Input:**
nums = [5,4,2,4]

**Output:**
- 8

## Explanation
Continuous subarray of size 1: [5], [4], [2], [4].
Continuous subarray of size 2: [5,4], [4,2], [2,4].
Continuous subarray of size 3: [4,2,4].
There are no subarrys of size 4.
Total continuous subarrays = 4 + 3 + 1 = 8.
It can be shown that there are no more continuous subarrays.

## Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
