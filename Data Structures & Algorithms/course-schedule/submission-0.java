class Solution {
    //TC: V+E
    //sc: v+e
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // [(1,0),(2,0),(3,1),(5,3),(5,4),(4,1),(3,2),(5,2)]
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<prerequisites.length; i++){
            // Build indegree array
            int dst = prerequisites[i][0];
            int src = prerequisites[i][1];
            indegree[dst]++; 

            // build the map
            map.putIfAbsent(src, new ArrayList<Integer>());
            map.get(src).add(dst);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> dependencies = map.get(curr);
            if(dependencies != null){
             for(int dependent : dependencies){
                indegree[dependent]--;
                if(indegree[dependent] == 0){
                    q.offer(dependent);
                }
            }
            }
        }

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}