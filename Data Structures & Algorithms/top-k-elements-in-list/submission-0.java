class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> map.get(a) - map.get(b));
        for(int val : map.keySet()){
            heap.add(val);
            if(heap.size() > k){
                heap.remove();
            }
        }

        int[] arr = new int[k];
        int i=0;
        while(!heap.isEmpty()){
            arr[i++] = heap.remove();
        }
        return arr;
    }
}
