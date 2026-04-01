class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1, visit, adj)){
            return false;
        }
        return visit.size() == n;
    }

    public boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj){
        //base
        if(visit.contains(node)) return false;

        //logic
        visit.add(node);
        for(int nei : adj.get(node)){
            if(nei == parent){
                continue;
            }
            if(!dfs(nei, node, visit, adj)){
                return false;
            }
        }

        //return
        return true;
    }
}
