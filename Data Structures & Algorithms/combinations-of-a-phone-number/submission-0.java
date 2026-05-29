class Solution {
    List<String> res = new ArrayList<>();
    String[] digitChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        dfs(digits, "", 0);
        return res;
    }

    public void dfs(String digits, String currStr, int i){
        if(currStr.length() == digits.length()){
            res.add(currStr);
            return;
        }

        String chars = digitChars[digits.charAt(i)- '0'];
        for(char c : chars.toCharArray()){
            dfs(digits, currStr + c, i+1);
        }
    }
}