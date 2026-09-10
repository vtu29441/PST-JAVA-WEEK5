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
