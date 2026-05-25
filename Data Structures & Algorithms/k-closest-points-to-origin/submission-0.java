class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(k == points.length) return points;

        PriorityQueue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });

        for(int[] point : points){
            heap.offer(point);

            if(heap.size() > k) heap.poll();
        }
        return heap.toArray(new int[0][0]);
    }
}