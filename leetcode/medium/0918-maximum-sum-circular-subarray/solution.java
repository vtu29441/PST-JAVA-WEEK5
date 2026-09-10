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