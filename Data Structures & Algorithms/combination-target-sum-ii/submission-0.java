class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, ans, subset);
        return ans;
    }

    public void dfs(int[] candidates, int target, int start, List<List<Integer>> ans, List<Integer> subset){
        if(target < 0) return;
        else if(target == 0){
            ans.add(new ArrayList<>(subset));
        }else{
            //logic
            for(int i=start; i< candidates.length; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue;
                subset.add(candidates[i]);
                dfs(candidates, target - candidates[i], i+1, ans, subset);
                subset.remove(subset.size()-1);
            }
        }
    }
}