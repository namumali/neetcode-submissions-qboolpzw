class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int i=0; i<nums.length; i++){
            int len = 1;
            int num = nums[i]; 

            while(set.contains(--num)){
                len++;
                set.remove(num);
            }

            num = nums[i];
            while(set.contains(++num)){
                len++;
                set.remove(num);
            }

            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
