class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int rightProduct = 1;
        for(int i=nums.length-1; i>=0; i--){
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return ans;
    }
}  

// 1 [1,2,4,6] 1
// left  [1, 1, 2, 8]
// right [48, 24, 6, 1]
// ans = [48, 24,12, 8]