class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int prev = 1, curr = 1, temp = 0;
        for(int i=n; i>=2; i--){
           temp = prev + curr;
           prev = curr;
           curr = temp;
        }
        return temp;
    }
}