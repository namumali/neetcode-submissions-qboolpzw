class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
           if (!set.contains(num)) continue;
           int count = 1;
           int curr = num;
           while(set.contains(--curr)){
            count++;
            set.remove(curr);
           }

           curr = num;
           while(set.contains(++curr)){
            count++;
            set.remove(curr);
           }

           maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
