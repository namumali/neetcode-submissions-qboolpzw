class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] tmap = new int[128];
        int[] smap = new int[128];

        int start = 0, end = 0, startIndex = 0, minLen = Integer.MAX_VALUE, count = t.length();

        for(char c : t.toCharArray()){
            tmap[c]++;
        }

        char[] schars = s.toCharArray();
        while(end < schars.length){
            if(tmap[schars[end++]]-- > 0){count--;}
            
            while(count == 0){
               if(end - start < minLen){
                 startIndex = start;
                 minLen = end - start;
               }
               if(tmap[schars[start++]]++ == 0) {count++;}
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : new String(schars, startIndex, minLen);
    }
}
