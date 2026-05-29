class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", n, 0, 0);
        return ans;
    }

    public void dfs(List<String> ans, String temp, int n, int left, int right){
        // base 
        if(temp.length() == n*2){
            ans.add(temp);
            return;
        }

        // logic
        if(left < n){
            dfs(ans, temp + "(", n, left + 1, right);
        }
        if(right < left){
            dfs(ans, temp + ")", n, left, right + 1);
        }
    }
}