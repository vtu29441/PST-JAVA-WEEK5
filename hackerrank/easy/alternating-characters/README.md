# Alternating Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a string containing characters $A$ and $B$ only.  Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.  

Your task is to find the minimum number of required deletions.

**Example**  
$s = AABAAB$  

Remove an $A$ at positions $0$ and $3$ to make $s = ABAB$ in $2$ deletions.

**Function Description**

Complete the *alternatingCharacters* function in the editor below.  

alternatingCharacters has the following parameter(s):

- *string s*: a string  

**Returns**  

- *int:* the minimum number of deletions required

**Input Format**

The first line contains an integer $q$, the number of queries.  
The next $q$ lines each contain a string $s$ to analyze.

**Constraints**

- $ 1 \le q \le 10$  
- $ 1 \le \text{ length of s }\le 10^5$
- Each string $s$ will consist only of characters $A$ and $B$.

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T06:00:15.105Z  

```java
import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        int deletions = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }
        
        return deletions;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/alternating-characters/problem)