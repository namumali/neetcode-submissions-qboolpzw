class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for(int i=0; i<nums.length; i++){
            int currRob = notRob + nums[i];
            notRob = Math.max(notRob, rob);
            rob = currRob;
        }
        return Math.max(rob, notRob);
    }
}