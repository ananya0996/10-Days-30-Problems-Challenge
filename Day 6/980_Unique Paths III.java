class Solution {
    
    static final int[][] directions = {
        {0, 1},  //RIGHT
        {0, -1}, //LEFT
        {-1, 0}, //UP
        {1, 0,}  //DOWN
    };
    
    int[] START;
    int M;
    int N;
    int pathCount;
    int emptyCellCount;
    
    public int uniquePathsIII(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        START = find(grid, 1);
        pathCount = 0;
        emptyCellCount = 1;
        
        for(int[] row : grid) {
            for(int num : row) {
                if(num == 0) {
                    emptyCellCount++;
                }
            }
        }
        
        dfs(grid, START[0], START[1]);
        
        return pathCount;
    }
    
    private void dfs(int[][] grid, int x, int y) {
        if(grid[x][y] == 2) {
            if(emptyCellCount == 0) pathCount++;
            return;
        }
        
        emptyCellCount--;
        grid[x][y] = -2;
        
        for(int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if(canGoTo(grid, newX, newY)) {
                dfs(grid, newX, newY);
            }
        }
        
        emptyCellCount++;
        grid[x][y] = 0;
    }
    
    private boolean canGoTo(int[][] grid, int x, int y) {
        return x >= 0 && x < M
            && y >= 0 && y < N
            && grid[x][y] >= 0;
    }
    
    private int[] find(int[][] grid, int num) {
        for(int i = 0; i < M; ++i) {
            for(int j = 0; j < N; ++j) {
                if(grid[i][j] == num) {
                    return new int[] {i, j};
                }
            }
        }
        
        return new int[] {-1, -1};
    }
}
/*
1  0  0  0
0  0  0  0
0  0  2 -1
*/