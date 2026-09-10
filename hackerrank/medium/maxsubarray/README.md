# The Maximum Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

We define *subsequence* as any subset of an array.  We define a *subarray* as a *contiguous subsequence* in an array.  

Given an array, find the maximum possible sum among:

1. all nonempty subarrays. 
2. all nonempty subsequences. 

Print the two values as space-separated integers on one line. 

**Note** that empty subarrays/subsequences should not be considered. 

**Example**  
$arr = [-1, 2, 3, -4, 5, 10]$   

The maximum subarray sum is comprised of elements at inidices $[1-5]$.  Their sum is $2 + 3 + -4 + 5 + 10 = 16$.  The maximum subsequence sum is comprised of elements at indices $[1, 2, 4, 5]$ and their sum is $2 + 3 + 5 + 10 = 20$.  

**Function Description**  

Complete the *maxSubarray* function in the editor below.    

maxSubarray has the following parameter(s):  

- *int arr[n]:* an array of integers  

**Returns**  

- *int[2]:* the maximum subarray and subsequence sums  

**Input Format**

The first line of input contains a single integer $t$, the number of test cases.

The first line of each test case contains a single integer $n$.   
The second line contains $n$ space-separated integers $arr[i]$ where $0 \le i \lt n$.   

**Constraints**

- $1 \le t \le 10$
- $1 \le n \le 10^5$   
- $-10^4 \le arr[i] \le 10^4$   


*The subarray and subsequences you consider should have at least one element.*

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-09-10T05:50:24.165Z  

```java
import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxEndingHere = arr.get(0);
        int maxSoFar = arr.get(0);
        
        int maxElement = arr.get(0);
        int positiveSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            
            // 1. Max Subarray
            if (i > 0) {
                maxEndingHere = Math.max(val, maxEndingHere + val);
                maxSoFar = Math.max(maxSoFar, maxEndingHere);
            }
            
            // 2. Max Subsequence
            if (val > 0) {
                positiveSum += val;
            }
            maxElement = Math.max(maxElement, val);
        }

        int maxSubseq = (maxElement <= 0) ? maxElement : positiveSum;

        return Arrays.asList(maxSoFar, maxSubseq);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            List<Integer> result = Result.maxSubarray(arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/maxsubarray/problem)