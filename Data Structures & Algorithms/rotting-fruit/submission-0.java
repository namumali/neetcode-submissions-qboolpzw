class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }

                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int minutes = 0;
        if(fresh == 0) return minutes;

        while(!queue.isEmpty()){
            int level = queue.size();
            minutes++;

            for(int i=0; i<level; i++){
                int[] curr = queue.poll();

                for(int[] dir : directions){
                    int currRow = dir[0] + curr[0];
                    int currCol = dir[1] + curr[1];

                    if(currRow >= 0 && currRow < m && currCol >= 0 && currCol < n && grid[currRow][currCol] == 1){
                        grid[currRow][currCol] = 2;
                        queue.add(new int[]{currRow, currCol});
                        fresh--;
                        if(fresh == 0) return minutes;
                    }
                }
            }
        }
        return -1;
    }
}