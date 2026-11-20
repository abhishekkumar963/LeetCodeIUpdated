// 63. Unique Paths II

class Solution {
    private Integer[][] memo;
    private int[][] obstacleGrid;
    private int rows;
    private int cols;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
      
        this.obstacleGrid = obstacleGrid;
      
        memo = new Integer[rows][cols];
      
        return dfs(0, 0);
    }

    private int dfs(int row, int col) {
        if (row >= rows || col >= cols || obstacleGrid[row][col] == 1) {
            return 0;
        }
      
        if (row == rows - 1 && col == cols - 1) {
            return 1;
        }
        if (memo[row][col] == null) {
            int pathsDown = dfs(row + 1, col);
            int pathsRight = dfs(row, col + 1);
          
            memo[row][col] = pathsDown + pathsRight;
        }
      
        return memo[row][col];
    }
}
