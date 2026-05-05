class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Char = new int[128];
        int[] s2Char = new int[128];
        int left = 0;

        for(char c : s1.toCharArray()){
            s1Char[c - 'a']++;
        }

        for(int right=0; right<s2.length(); right++){
            s2Char[s2.charAt(right)-'a']++;

            if(right-left+1 > s1.length()){
                s2Char[s2.charAt(left) - 'a']--;
                left++;
            }
            if(Arrays.equals(s1Char, s2Char)){
                return true;
            }
        }
        return false;
    }
}
