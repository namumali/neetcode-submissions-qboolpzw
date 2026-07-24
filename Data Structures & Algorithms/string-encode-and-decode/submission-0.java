class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for(String s : strs){
            st.append(s.length()).append('#').append(s);
        }
        return st.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i=0;

        while(i < str.length()){
            int deLimiter = str.indexOf('#',i);
            int len = Integer.parseInt(str.substring(i, deLimiter));
            String s = str.substring(deLimiter+1, deLimiter + len + 1);
            decoded.add(s);
            i = deLimiter + len + 1;
        }
        return decoded;
    }
}
