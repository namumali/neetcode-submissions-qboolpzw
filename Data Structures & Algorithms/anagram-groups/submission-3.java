class Solution {
    private static final int[] PRIMES = {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
        47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
    };

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<>();

        for(String s : strs){
           long key = calculateProduct(s);
           
           map.putIfAbsent(key, new ArrayList<>());
           map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
        
    }

    public long calculateProduct(String s){
        long product = 1;
            for(char c : s.toCharArray()){
               product *= PRIMES[c-'a'];
            }
        return product;
    }
}
