# Subarray Division

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it. 

Lily decides to share a contiguous segment of the bar selected such that: 

- The length of the segment matches Ron's birth month, and,
- The sum of the integers on the squares is equal to his birth day.

Determine how many ways she can divide the chocolate.

**Example**   
$s = [2, 2, 1, 3, 2]$    
$d = 4$   
$m = 2$   

Lily wants to find segments summing to Ron's birth day, $d = 4$ with a length equalling his birth month, $m = 2$.  In this case, there are two segments meeting her criteria: $[2, 2]$ and $[1,3]$.

**Function Description**

Complete the *birthday* function in the editor below.    

birthday has the following parameter(s):  

- *int s[n]:* the numbers on each of the squares of chocolate  
- *int d:* Ron's birth day  
- *int m:* Ron's birth month  

**Returns**   

- *int:* the number of ways the bar can be divided  



**Input Format**

The first line contains an integer $n$, the number of squares in the chocolate bar.  	
The second line contains $n$ space-separated integers $s[i]$, the numbers on the chocolate squares where $0 \le i \lt n$.  
The third line contains two space-separated integers, $d$ and $m$, Ron's birth day and his birth month.

**Constraints**

* ${1} \leq {n} \leq 100$  
* ${1}\leq {s[i]}\leq {5}$, where (${0}\leq {i} \lt {n}$)     
* ${1} \leq {d} \leq {31}$  
* ${1} \leq {m} \leq {12}$

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T05:42:36.139Z  

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int currentSum = 0;

        if (s.size() < m) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }

        if (currentSum == d) {
            count++;
        }

        for (int i = m; i < s.size(); i++) {
            currentSum = currentSum + s.get(i) - s.get(i - m);
            
            if (currentSum == d) {
                count++;
            }
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/the-birthday-bar/problem)