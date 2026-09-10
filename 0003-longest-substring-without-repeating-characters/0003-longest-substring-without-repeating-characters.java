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