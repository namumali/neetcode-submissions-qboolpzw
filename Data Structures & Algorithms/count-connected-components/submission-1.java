class Solution {
    public int countComponents(int n, int[][] edges) {
      
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(visit.contains(i)){
                continue;
            }
            res++;
            queue.offer(i);
            visit.add(i);

            while (!queue.isEmpty()) {
            int current = queue.poll();
                for (int nei : adj.get(current)) {
                    if (visit.contains(nei)) {
                        continue;
                    }
                    queue.offer(nei);
                    visit.add(nei);
                }
        }
        }

        return res;
    }
}
