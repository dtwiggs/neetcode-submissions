class Solution {
    int rows, cols;
    HashSet<String> set = new HashSet<>();

    public int countPaths(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        
        rows = grid.length;
        cols = grid[0].length;
        if(grid[rows - 1][cols - 1] == 1){
            return 0;
        }

        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int r, int c){
        String str = r + "" + c;
        int res = 0;
        
        if(r == rows - 1 && c == cols - 1){
            return 1;
        } else if(set.contains(str) || r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 1){
            return 0;
        }

        set.add(str);
        res += dfs(grid, r + 1, c);
        res += dfs(grid, r - 1, c);
        res += dfs(grid, r, c + 1);
        res += dfs(grid, r, c - 1);
        set.remove(str);

        return res;
    }
}