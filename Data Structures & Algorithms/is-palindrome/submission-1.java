class Solution {
    public boolean isPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = s.length()-1;

        for(int i=0; i<s.length(); i++){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            else{
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
