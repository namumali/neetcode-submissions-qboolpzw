class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        dfs(nums, 0, ans, subList);
        return ans;
    }

    public void dfs(int[] nums, int i, List<List<Integer>> ans, List<Integer> subList){
        if(i == nums.length){
            ans.add(new ArrayList<>(subList));
            return;
        }

        subList.add(nums[i]);
        dfs(nums, i+1, ans, subList);
        subList.remove(subList.size()-1);
        dfs(nums, i+1, ans, subList);
    }
}