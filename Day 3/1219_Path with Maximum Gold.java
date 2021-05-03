class Solution {
    
    private static int[][] directions = {
        {-1, 0}, //UP
        {0, 1},  //RIGHT
        {1, 0},  //DOWN
        {0, -1}  //LEFT
    };
    
    int result = 0;
    
    public int getMaximumGold(int[][] grid) {
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] != 0) {
                    maxGold(grid, i, j, 0);
                }
            }
        }
        
        return result;
    }
    
    private void maxGold(int[][] grid, int i, int j, int current) {
        if(!canMoveTo(grid, i, j)) {
            result = Math.max(result, current);
            return;
        }
        
        int oldVal = grid[i][j];
        grid[i][j] = 0;
        
        for(int[] d : directions) {
            maxGold(grid, i + d[0], j + d[1], current + oldVal);
        }
        
        grid[i][j] = oldVal;
    }
    
    private boolean canMoveTo(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length
            && y >= 0 && y < grid[0].length
            && grid[x][y] != 0;
    }
}