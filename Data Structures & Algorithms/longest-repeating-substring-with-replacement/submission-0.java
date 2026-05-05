class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int left = 0, maxLen = 0, largestCount = 0;

        for(int right = 0; right < s.length(); right++){
            arr[s.charAt(right) - 'A']++;
            largestCount = Math.max(largestCount, arr[s.charAt(right) - 'A']);

            if((right - left + 1) - largestCount > k){
                arr[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
