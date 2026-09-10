# Maximum Sum Circular Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a  **circular integer array**  `nums` of length `n`, return  *the maximum possible sum of a non-empty  **subarray**  of* `nums`.

A  **circular array**  means the end of the array connects to the beginning of the array. Formally, the next element of `nums[i]` is `nums[(i + 1) % n]` and the previous element of `nums[i]` is `nums[(i - 1 + n) % n]`.

A  **subarray**  may only include each element of the fixed buffer `nums` at most once. Formally, for a subarray `nums[i], nums[i + 1],..., nums[j]`, there does not exist `i <= k1`, `k2 <= j` with `k1 % n == k2 % n`.

 

 **Example 1:** 

```
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

```

 **Example 2:** 

```
Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

```

 **Example 3:** 

```
Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.

```

 

 **Constraints:** 

- n == nums.length
- 1 <= n <= 3 * 104
- -3  *104 <= nums[i] <= 3*  104

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 79.40%)  
**Memory:** 51.1 MB (beats 60.90%)  
**Submitted:** 2026-09-10T05:54:30.041Z  

```java
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int currentMax = 0;
        int minSum = nums[0];
        int currentMin = 0;
        
        for (int num : nums) {
            // Find max subarray sum
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
            
            // Find min subarray sum
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
            
            // Calculate total sum
            totalSum += num;
        }
        
        // If maxSum is less than or equal to 0, it means all numbers are negative.
        // Returning totalSum - minSum would return 0 (an empty subarray), which is invalid.
        if (maxSum <= 0) {
            return maxSum;
        }
        
        // Return the max of the normal max sum or the wrapped max sum
        return Math.max(maxSum, totalSum - minSum);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-sum-circular-subarray/)