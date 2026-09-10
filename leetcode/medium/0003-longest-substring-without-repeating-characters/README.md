# Longest Substring Without Repeating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, find the length of the  **longest**   **substring**  without duplicate characters.

 

 **Example 1:** 

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

```

 **Example 2:** 

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

```

 **Example 3:** 

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

```

 

 **Constraints:** 

- 0 <= s.length <= 105
- s consists of English letters, digits, symbols and spaces.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 96.59%)  
**Memory:** 48.2 MB (beats 9.13%)  
**Submitted:** 2026-09-10T06:01:13.749Z  

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Array to store the last seen index of each character (using ASCII size 128)
        int[] charIndex = new int[128];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen before, move the left pointer 
            // to the right of the character's last occurrence.
            // Math.max ensures the left pointer doesn't go backwards.
            left = Math.max(left, charIndex[currentChar]);
            
            // Calculate the current window length and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
            
            // Store the next index of the current character
            charIndex[currentChar] = right + 1;
        }

        return maxLength;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/)