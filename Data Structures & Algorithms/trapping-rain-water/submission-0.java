class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        for(int i=0; i<height.length; i++){
           if(leftMax < rightMax){
              leftMax = Math.max(leftMax, height[left]);
              water += leftMax - height[left];
              left++;
           }else{
            rightMax = Math.max(rightMax, height[right]);
            water += rightMax - height[right];
            right--;
           }
        }
        return water;
    }
}
