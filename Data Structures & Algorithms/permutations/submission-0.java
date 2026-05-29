class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, ans, subset);
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> subset){
        // base case
        if(subset.size() == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        // logic
        for(int i=0; i<nums.length; i++){
            if(subset.contains(nums[i])) continue;
            subset.add(nums[i]);
            dfs(nums, ans, subset);
            subset.remove(subset.size()-1);
        }
    }
}