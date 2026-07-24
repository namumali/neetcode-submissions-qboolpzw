class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for(int num : map.keySet()){
            heap.add(num);
            if(heap.size() > k){
                heap.remove();
            }
        }
        
        int[] res = new int[heap.size()];
        int i=0;
        while(!heap.isEmpty()){
            res[i++] = heap.remove();
        }
        return res;
    }
}
