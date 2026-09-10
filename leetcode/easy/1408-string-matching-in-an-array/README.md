# String Matching in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of string `words`, return all strings in `words` that are a substring of another word. You can return the answer in  **any order**.

 

 **Example 1:** 

```
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

```

 **Example 2:** 

```
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".

```

 **Example 3:** 

```
Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.

```

 

 **Constraints:** 

- 1 <= words.length <= 100
- 1 <= words[i].length <= 30
- words[i] contains only lowercase English letters.
- All the strings of words are unique.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 97.55%)  
**Memory:** 43.5 MB (beats 80.67%)  
**Submitted:** 2026-09-10T06:04:48.812Z  

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Break to prevent adding the same word multiple times
                }
            }
        }
        
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/string-matching-in-an-array/)