class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
           heap.offer(stone);
        }

        while(heap.size() > 1){
            int x = heap.poll();
            int y = heap.poll();

            if(x != y){
                heap.offer(x - y);
            }
        }
            if(!heap.isEmpty()){
                return heap.peek();
            }
        return 0;
    }
}
