class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        dfs(candidates, target, subList, ans, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<Integer> subList, List<List<Integer>> ans, int start){
        //base case
        if(target < 0) return;
        else if(target == 0){
            ans.add(new ArrayList<>(subList));
        }else{
            //logic
            for(int i = start; i< candidates.length; i++){
                subList.add(candidates[i]);
                dfs(candidates, target - candidates[i], subList, ans, i);
                subList.remove(subList.size()-1);
                
            }
        }
        }
}