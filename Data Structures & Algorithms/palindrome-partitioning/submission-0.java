class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(s, 0, part, ans);
        return ans;
    }

    public void dfs(String s, int i, List<String> part, List<List<String>> ans){
        if(i == s.length()){
            ans.add(new ArrayList<>(part));
            return;
        }

        for(int j=i; j<s.length(); j++){
            if(isPalindrome(s, i, j)){
                part.add(s.substring(i, j+1));
                dfs(s, j+1, part, ans);
                part.remove(part.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}