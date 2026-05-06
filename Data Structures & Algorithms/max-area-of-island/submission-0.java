class Solution {
    int rows, cols;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int area = 0;
        rows = grid.length;
        cols = grid[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    area = dfs(grid, r, c);
                    if(area > res){
                        res = area;
                    }
                }
            }
        }

        return res;
    }

    public int dfs(int[][] grid, int r, int c){
        if(grid[r][c] == 0){
            return 0;
        }
            
        grid[r][c] = 0;
        int area = 1;

        if(r + 1 < rows){
            area += dfs(grid, r + 1, c);
        }
        if(r - 1 >= 0){
            area += dfs(grid, r - 1, c);
        }
        if(c + 1 < cols){
            area += dfs(grid, r, c + 1);
        }
        if(c - 1 >= 0){
            area += dfs(grid, r, c - 1);
        }

        return area;
    }
}