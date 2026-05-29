class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, subset, ans);
        return ans;
    }

    public void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> ans){
        //base 
        ans.add(new ArrayList<>(subset));

        //logic
        for(int i = start; i< nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            dfs(nums, i+1, subset, ans);
            subset.remove(subset.size()-1);
        }
    }
}