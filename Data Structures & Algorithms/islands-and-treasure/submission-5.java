

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // 1. Add all Treasure chests to the queue immediately
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. BFS from all treasures simultaneously
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Check bounds and if the cell is Land (INF)
                // We skip -1 (Water) and anything not INF (already visited)
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == Integer.MAX_VALUE) {
                    
                    // Update distance directly using the previous cell's value + 1
                    grid[nr][nc] = grid[r][c] + 1;
                    
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}