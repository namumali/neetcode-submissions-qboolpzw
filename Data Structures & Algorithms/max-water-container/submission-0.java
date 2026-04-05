class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;

        for(int i=0; i<heights.length; i++){
            int currArea = Math.min(heights[left], heights[right]) * (right-left);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
